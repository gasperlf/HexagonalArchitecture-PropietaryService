package com.powerup.user.application.handler;

import com.powerup.user.application.dto.UserRequest;
import com.powerup.user.application.dto.UserResponse;
import com.powerup.user.domain.model.User;

import java.util.List;

public interface IUserHandler {
    void saveUser(UserRequest userRequest, Long idRol);
    UserResponse getUser(Long id);
    UserResponse getUserByEmail(String email);
    List<UserResponse> findClientByRol(String roleName);
}
