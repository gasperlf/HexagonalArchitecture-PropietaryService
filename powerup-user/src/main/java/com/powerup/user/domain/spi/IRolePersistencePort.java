package com.powerup.user.domain.spi;

import com.powerup.user.domain.model.Role;

import java.util.List;


public interface IRolePersistencePort {
    List<Role> getAllRoles();
    Role getRoleById(Long id);
    Role getRoleByName(String name);
}
