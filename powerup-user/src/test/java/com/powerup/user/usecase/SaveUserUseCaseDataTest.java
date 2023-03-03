package com.powerup.user.usecase;

import com.powerup.user.domain.model.Role;
import com.powerup.user.domain.model.User;

public class SaveUserUseCaseDataTest {

    public static User obtainUser(){

        User user = new User(
                2L,
                "Luis",
                "Cardoso",
                "3013212310",
                "luis@gmail.com",
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



}
