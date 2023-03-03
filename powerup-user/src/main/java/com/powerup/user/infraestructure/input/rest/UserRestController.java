package com.powerup.user.infraestructure.input.rest;

import com.powerup.user.application.dto.PlateRequest;
import com.powerup.user.application.dto.RestaurantRequest;
import com.powerup.user.application.dto.UserRequest;
import com.powerup.user.application.dto.UserResponse;
import com.powerup.user.application.handler.IUserHandler;
import com.powerup.user.infraestructure.RestaurateClientFeign.RestauranteClient.RestaurantClient;
import com.powerup.user.infraestructure.out.jpa.repository.IUserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor

public class UserRestController {

    private final RestaurantClient restaurantClient;

    private final IUserRepository userRepository;
    private final IUserHandler userHandler;
    @Operation(summary = "Add propietary")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created", content = @Content),
            @ApiResponse(responseCode = "400", description = "User already exists", content = @Content)
    })
    @PostMapping("/proprietary")
    public ResponseEntity<Void> saveUserEntityProprietary(@Validated @RequestBody UserRequest userRequest){
            userHandler.saveUser(userRequest, 2L);
            return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Add Employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created", content = @Content),
            @ApiResponse(responseCode = "400", description = "Employer already exists", content = @Content)
    })
    @PostMapping("/employee")
    public ResponseEntity<Void> saveUserEntityEmployee(@Validated @RequestBody UserRequest userRequest){
                userHandler.saveUser(userRequest, 3L);
                return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @Operation(summary = "Add Client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created", content = @Content),
            @ApiResponse(responseCode = "400", description = "Client already exists", content = @Content)
    })
    @PostMapping("/client")
    public ResponseEntity<Void> saveUserEntityClient(@Validated @RequestBody UserRequest userRequest){
        userHandler.saveUser(userRequest, 4L);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Obtain user by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created", content = @Content),
            @ApiResponse(responseCode = "400", description = "Userid do not already exists", content = @Content)
    })
    @GetMapping("/userById")
    public UserResponse getUserById(@PathVariable Long id){

        UserResponse userResponse = userHandler.getUser(id);
        return userResponse;
    }
}
