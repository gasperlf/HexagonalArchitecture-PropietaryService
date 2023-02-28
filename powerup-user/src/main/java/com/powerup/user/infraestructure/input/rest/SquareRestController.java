package com.powerup.user.infraestructure.input.rest;

import com.powerup.user.application.dto.RestaurantRequest;
import com.powerup.user.infraestructure.RestaurateClientFeign.RestauranteClient.RestaurantClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/square")
@RequiredArgsConstructor
public class SquareRestController {
    private final RestaurantClient restaurantClient;
    @PostMapping("/restaurant")
    public ResponseEntity<RestaurantRequest> saveRestaurant(@RequestBody RestaurantRequest restaurantRequest){
        RestaurantRequest restaurant = restaurantClient.saveRestaurante(restaurantRequest).getBody();

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(restaurantRequest);
    }
}
