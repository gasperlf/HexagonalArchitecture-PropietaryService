package com.powerup.user.domain.spi;

import com.powerup.user.domain.model.User;

import java.util.List;


public interface IUserPersistencePort {
    void saveUser(User user);
    User getUser(Long id);
    User getUserByEmail(String email);
    boolean existsByEmail(String email);
    List<User> findClientByRol(String roleName);
    boolean existsByID(Long id);
}
