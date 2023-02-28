package com.powerup.user.domain.api;

import com.powerup.user.domain.model.User;

import java.util.List;


public interface IUserServicePort {
    void saveUser(User user, Long idRol);
    User getUser(Long id);
    User getUserByEmail(String email);
    boolean existByEmail(String email);
    List<User> findClientByIdRole(String roleName);
    boolean existByID(Long id);
}
