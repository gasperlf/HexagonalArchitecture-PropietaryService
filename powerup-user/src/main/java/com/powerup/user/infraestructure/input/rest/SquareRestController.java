package com.powerup.user.infraestructure.input.rest;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.powerup.user.application.dto.*;
import com.powerup.user.application.handler.impl.UserHandler;
import com.powerup.user.domain.exception.RestaurantAlreadyExistsException;
import com.powerup.user.domain.exception.UserDoNotExistException;
import com.powerup.user.infraestructure.RestaurateClientFeign.RestauranteClient.RestaurantClient;
import com.powerup.user.infraestructure.out.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/square")
@RequiredArgsConstructor
public class SquareRestController {
    private final RestaurantClient restaurantClient;
    private final UserHandler userHandler;

    private final IUserRepository userRepository;

    @PostMapping("/createRestaurant")
    public ResponseEntity<RestaurantRequest> saveRestaurantEntity(@RequestBody RestaurantRequest restaurantRequest,
                                                                  @RequestHeader(HttpHeaders.AUTHORIZATION)String token){
        // Getting info from token
        token = token.replace("Bearer ", "");

        // Split into 3 parts with . delimiter
        String[] parts = token.split("\\.");
        Base64.Decoder decoder = Base64.getUrlDecoder();
        String payload = new String(decoder.decode(parts[1]));

        //Accessing to the Json String info
        JSONObject jsonObject = new JSONObject(payload);
        String email = (String) jsonObject.get("sub");
        String role = (String) jsonObject.get("role");

        if(!userRepository.findByEmail(email).isPresent()){
            throw new UserDoNotExistException();
        }

        restaurantRequest.setIdOwner(userRepository.findByEmail(email).get().getId());

        RestaurantRequest restaurant = restaurantClient.saveRestaurant(restaurantRequest).getBody();
        return ResponseEntity.status(HttpStatus.CREATED).body(restaurant);
    }

    @PostMapping("/createPlate/")
    public ResponseEntity<PlateRequest> savePlateEntity( @RequestBody PlateRequest plateRequest){
        plateRequest.setIdRestaurant(userRepository.findByEmail(userLoginApplication()).get().getId());
        restaurantClient.savePlate(plateRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/putPlate/")
    public ResponseEntity<Void> editPlate(@Validated @RequestBody PlateUpdatingRequest plateUpdatingRequest){
        plateUpdatingRequest.setIdOwner(userRepository.findByEmail(userLoginApplication()).get().getId());
        restaurantClient.editPlate(plateUpdatingRequest);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/putActivate")
    public ResponseEntity<Void> editPlateStatus(@RequestBody PlateIsActiveRequest plateIsActiveRequest){
        restaurantClient.editPlateStatus(plateIsActiveRequest);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/allRestaurants")
    public ResponseEntity<List<RestaurantResponse>> getAllRestaurant(@RequestBody RestaurantListRequest restaurantListRequest){
        return restaurantClient.getAllRestaurant(restaurantListRequest);
    }

    @PostMapping("/allPlates")
    public ResponseEntity<List<PlateResponse>> getPlatesFromRestaurant(@RequestBody PlateListRequest plateListRequest){
        return restaurantClient.getPlatesFromRestaurant(plateListRequest);
    }


    public static String userLoginApplication() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }
        return userDetails.getUsername();
    }



}
