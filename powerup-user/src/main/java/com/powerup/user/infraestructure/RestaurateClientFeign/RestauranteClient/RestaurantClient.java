package com.powerup.user.infraestructure.RestaurateClientFeign.RestauranteClient;

import com.powerup.user.application.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name="plazoleta",url = "http://localhost:8093/" ) //configuration = CustomFeignConfig.class)
public interface RestaurantClient {

    @RequestMapping(method = RequestMethod.POST, value = "restaurants/createRestaurant")
    public ResponseEntity<RestaurantRequest> saveRestaurant(@RequestBody RestaurantRequest restaurantRequest);

    @RequestMapping(method = RequestMethod.POST, value = "plates/createPlate")
    public ResponseEntity<PlateRequest> savePlate(@RequestBody PlateRequest restaurantRequest);

    @RequestMapping(method = RequestMethod.PUT, value = "plates/putPlate")
    public ResponseEntity<Void> editPlate(@RequestBody PlateUpdatingRequest plateUpdatingRequest);

    @RequestMapping(method = RequestMethod.POST, value = "employee/createEmployee")
    public ResponseEntity<EmployeeRequest> saveEmployee(@RequestBody EmployeeRequest employeeRequest);

    @RequestMapping(method = RequestMethod.PUT, value = "plates/putActivate")
    public ResponseEntity<Void> editPlateStatus(@RequestBody PlateIsActiveRequest plateIsActiveRequest);

    @RequestMapping(method = RequestMethod.POST, value = "restaurants/allRestaurants")
    public ResponseEntity<List<RestaurantResponse>> getAllRestaurant(@RequestBody RestaurantListRequest restaurantListRequest);
}
