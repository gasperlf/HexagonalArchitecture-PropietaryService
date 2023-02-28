package com.powerup.user.domain.usecase;

import com.powerup.user.domain.api.IUserServicePort;
import com.powerup.user.domain.exception.UserAlreadyExistsException;
import com.powerup.user.domain.model.User;
import com.powerup.user.domain.spi.IRolePersistencePort;
import com.powerup.user.domain.spi.IUserPersistencePort;

import java.util.List;

public class UserUseCase implements IUserServicePort {
    private final IUserPersistencePort userPersistencePort;
    private final IRolePersistencePort rolePersistencePort;
    public UserUseCase(IUserPersistencePort userPersistencePort, IRolePersistencePort rolePersistencePort) {
        this.userPersistencePort = userPersistencePort;
        this.rolePersistencePort = rolePersistencePort;
    }
    @Override
    public void saveUser(User user, Long idRol) {
        if(existByEmail(user.getEmail())) throw new UserAlreadyExistsException();
        user.setRole(rolePersistencePort.getRoleById(idRol));
        user.setId(-1L);
        userPersistencePort.saveUser(user);
    }
    @Override
    public User getUser(Long id) {
        return userPersistencePort.getUser(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userPersistencePort.getUserByEmail(email);
    }

    @Override
    public boolean existByEmail(String email) {
        return userPersistencePort.existsByEmail(email);
    }

    @Override
    public List<User> findClientByIdRole(String roleName) {
        return userPersistencePort.findClientByRol(roleName);
    }
    @Override
    public boolean existByID(Long id) {
        return userPersistencePort.existsByID(id);
    }
}
