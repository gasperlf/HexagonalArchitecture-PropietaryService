package com.powerup.user.domain.usecase;

import com.powerup.user.domain.api.IRoleServicePort;
import com.powerup.user.domain.model.Role;
import com.powerup.user.domain.spi.IRolePersistencePort;

import java.util.List;

public class RoleUseCase implements IRoleServicePort {

    private final IRolePersistencePort rolePersistencePort;

    public RoleUseCase(IRolePersistencePort rolePersistencePort) {
        this.rolePersistencePort = rolePersistencePort;
    }

    @Override
    public List<Role> getAllRoles() {
        return rolePersistencePort.getAllRoles();
    }

    @Override
    public Role getRoleById(Long id) {
        return rolePersistencePort.getRoleById(id);
    }

    @Override
    public Role getRoleByName(String name) {
        return rolePersistencePort.getRoleByName(name);
    }
}
