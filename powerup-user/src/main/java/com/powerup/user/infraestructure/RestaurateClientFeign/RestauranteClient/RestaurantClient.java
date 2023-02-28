package com.powerup.user.infraestructure.RestaurateClientFeign.RestauranteClient;

import com.powerup.user.application.dto.RestaurantRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="plazoleta",url = "http://localhost:8282/restaurants" ) //configuration = CustomFeignConfig.class)
public interface RestaurantClient {
    //@PostMapping("/restaurante")
    @RequestMapping(method = RequestMethod.POST, value = "/createRestaurant/")
    public ResponseEntity<RestaurantRequest> saveRestaurante(@RequestBody RestaurantRequest restaurantRequest);

}
