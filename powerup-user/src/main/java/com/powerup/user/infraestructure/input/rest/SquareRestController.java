package com.powerup.user.infraestructure.input.rest;

import com.powerup.user.application.dto.PlateIsActiveRequest;
import com.powerup.user.application.dto.PlateRequest;
import com.powerup.user.application.dto.PlateUpdatingRequest;
import com.powerup.user.application.dto.RestaurantRequest;
import com.powerup.user.infraestructure.RestaurateClientFeign.RestauranteClient.RestaurantClient;
import com.powerup.user.infraestructure.out.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/square")
@RequiredArgsConstructor
public class SquareRestController {
    private final RestaurantClient restaurantClient;

    private final IUserRepository userRepository;

    @PostMapping("/createRestaurant")
    public ResponseEntity<RestaurantRequest> saveRestaurantEntity(@RequestBody RestaurantRequest restaurantRequest){
        RestaurantRequest restaurant = restaurantClient.saveRestaurant(restaurantRequest).getBody();

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(restaurantRequest);
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


    public static String userLoginApplication() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }
        return userDetails.getUsername();
    }



}
