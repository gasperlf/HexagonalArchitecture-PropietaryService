package com.powerup.user.application.handler.impl;

import com.powerup.user.application.dto.UserRequest;
import com.powerup.user.application.dto.UserResponse;
import com.powerup.user.domain.model.Role;
import com.powerup.user.domain.model.User;

public class SaveHandlerDataTest {
    // Proprietary
    public static User obtainProprietaryUser(){
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

    public static User obtainEmployeeUser(){
        User user = new User(
                3L,
                "Jaime",
                "Cardoso",
                "3013542311",
                "jaime@gmail.com",
                "12345",
                new Role(
                        3L,
                        "ROLE_EMPLOYEE",
                        "Employee"
                ),
                "1025841145"
        );

        return user;
    }

    public static User obtainClientUser(){
        User user = new User(
                4L,
                "Stephenie",
                "Graire",
                "3013542315",
                "stephenie@gmail.com",
                "12345",
                new Role(
                        4L,
                        "ROLE_CLIENT",
                        "Client"
                ),
                "1025841143"
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
        userResponse.setEmail("alejandro@gmail.com");

        return userResponse;
    }

}
