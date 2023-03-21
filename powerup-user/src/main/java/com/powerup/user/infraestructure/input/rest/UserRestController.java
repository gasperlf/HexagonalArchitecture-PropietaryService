package com.powerup.user.infraestructure.input.rest;

import com.powerup.user.application.dto.*;
import com.powerup.user.application.handler.IUserHandler;
import com.powerup.user.domain.exception.EmptyInputException;
import com.powerup.user.infraestructure.RestaurateClientFeign.RestauranteClient.RestaurantClient;
import com.powerup.user.infraestructure.out.jpa.repository.IUserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
//        return new ResponseEntity("Created: new proprietary",HttpStatus.CREATED);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @Operation(summary = "Add Employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created", content = @Content),
            @ApiResponse(responseCode = "400", description = "Employer already exists", content = @Content)
    })
    @PostMapping("/employee")
    public ResponseEntity<UserResponse> saveUserEntityEmployee(@Validated @RequestBody UserRequest userRequest){

        return ResponseEntity.status(HttpStatus.OK).body(userHandler.saveUser(userRequest, 3L));
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

    @Operation(summary = "Find user by email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "302", description = "User found", content = @Content),
            @ApiResponse(responseCode = "404", description = "User don't exists", content = @Content),
            @ApiResponse(responseCode = "400", description = "bad request", content = @Content),
            @ApiResponse(responseCode = "403", description = "No authorized", content = @Content)
    })
    @PostMapping("/email/{email}")
    public UserResponse getUserByEmail(@PathVariable String email){
        return userHandler.getUserByEmail(email);
    }

//    public static String userLoginApplication() {
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        UserDetails userDetails = null;
//        if (principal instanceof UserDetails) {
//            userDetails = (UserDetails) principal;
//        }
//        return userDetails.getUsername();
//    }
}
