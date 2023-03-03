package com.powerup.user.infraestructure.out.jpa.adapter;

import com.powerup.user.domain.model.Role;
import com.powerup.user.domain.model.User;
import com.powerup.user.infraestructure.out.jpa.entity.RoleEntity;
import com.powerup.user.infraestructure.out.jpa.entity.UserEntity;

public class SaveUserJpaAdapterDataTest {

    public static User obtainUser() {

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

    public static UserEntity obtainUserEntity(){
        UserEntity userEntity = new UserEntity();

        userEntity.setId(11L);
        userEntity.setName("Jeisson");
        userEntity.setLastname("Garcia");
        userEntity.setPhone("3013218602");
        userEntity.setEmail("jeisson@gmail.com");
        userEntity.setPassword("12345");
        userEntity.setRole(new RoleEntity(
                2L,
                "ROLE_PROPRIETARY",
                "Proprietary"
        ));
        userEntity.setIdDocument("1025630112");

        return userEntity;
    }

}
