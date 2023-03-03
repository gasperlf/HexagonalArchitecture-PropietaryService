package com.powerup.user.infraestructure.out.jpa.adapter;

import com.powerup.user.domain.model.Role;

public class SaveRoleJpaAdapterDataTest {

    public static Role obtainRole(){
        Role role = new Role(
                2L,
                "ROLE_PROPRIETARY",
                "Proprietary"
        );

        return role;
    }

}
