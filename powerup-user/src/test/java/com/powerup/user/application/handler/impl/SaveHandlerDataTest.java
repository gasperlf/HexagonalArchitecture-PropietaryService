package com.powerup.user.application.handler.impl;

import com.powerup.user.application.dto.UserRequest;
import com.powerup.user.application.dto.UserResponse;
import com.powerup.user.domain.model.Role;
import com.powerup.user.domain.model.User;

public class SaveHandlerDataTest {

    public static User obtainUser(){
        User user = new User(
                2L,
                "David",
                "Cardoso",
                "3013542310",
                "alejandro@gmail.com",
                "12345",
                new Role(
                        2L,
                        "ROLE_PROPRIETARY",
                        "Proprietary"
                ),
                "1025841144"
        );

        return user;
    }

    public static UserRequest obtainUserRequest(){
        UserRequest userRequest = new UserRequest();

        userRequest.setName("David");
        userRequest.setLastName("Tolosa");
        userRequest.setIdDocument("1025841144");
        userRequest.setPhone("3013542310");
        userRequest.setEmail("alejandro@gmail.com");
        userRequest.setPassword("12345");

        return userRequest;
    }

    public static UserResponse obtainUserResponse(){
        UserResponse userResponse = new UserResponse();

        userResponse.setName("David");
        userResponse.setLastName("Tolosa");
        userResponse.setPhone("3013542310");
        userResponse.setEmail("alejandro@gmail.com");
        userResponse.setRole(new Role(2L, "ROLE_PROPRIETARY", "Proprietary"));

        return userResponse;
    }

}
