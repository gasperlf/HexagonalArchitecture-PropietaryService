package com.powerup.user.infraestructure.out.jpa.adapter.UserJpaAdapterTest;

import com.powerup.user.domain.model.User;
import com.powerup.user.domain.model.Role;
import com.powerup.user.infraestructure.out.jpa.entity.RoleEntity;
import com.powerup.user.infraestructure.out.jpa.entity.UserEntity;

public class SaveUserDataTest {

    public static User obtainUser(){
        User user = new User(-1L,"juan","cardoso","3013237026","juan@gmail.com",
                "dasd343",obtainRole(),"100042144");
        return user;
    }

    public static Role obtainRole(){
        Role role = new Role(0L,"Admin","Adminid");
        return role;

    }

    public static UserEntity obtainUserEntity(){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setName("juan");
        userEntity.setLastName("carodoso");
        userEntity.setPhone("3013237026");
        userEntity.setEmail("ajuan@gmail.com");
        userEntity.setPassword("dasd343");
        userEntity.setIdDocument("100042144");

        return userEntity;
    }

    public static RoleEntity obtainRoleEntity(){
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setId(1L);
        roleEntity.setDescription("Adminid");
        roleEntity.setName("Admin");

        return roleEntity;
    }

}
