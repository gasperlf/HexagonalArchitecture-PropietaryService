package com.powerup.user.application.dto;

import com.powerup.user.domain.model.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    private Long id;
    private String name;
    private String lastName;
    private String phone;
    private String email;
    private Role role;
    private String idDocument;
}
