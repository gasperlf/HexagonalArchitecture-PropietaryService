package com.powerup.user.infraestructure.out.jpa.adapter;

import com.powerup.user.domain.exception.UserAlreadyExistException;
import com.powerup.user.domain.exception.UserDoNotExistException;
import com.powerup.user.domain.model.User;
import com.powerup.user.domain.spi.IUserPersistencePort;
import com.powerup.user.infraestructure.out.jpa.entity.UserEntity;
import com.powerup.user.infraestructure.out.jpa.mapper.IUserMapper;
import com.powerup.user.infraestructure.out.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserJpaAdapter implements IUserPersistencePort {
    private final IUserRepository userRepository;
    private final IUserMapper userMapper;

    @Override
    public void saveUser(User user) {
        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new UserAlreadyExistException();
        }
        UserEntity userEntity = userMapper.toEntity(user);
        userRepository.save(userEntity);
    }
    @Override
    public User getUser(Long id) {
        if(userRepository.findById(id).isPresent()){
            throw new UserDoNotExistException();
        }

        return userMapper.toUser(userRepository.findById(id).get());
    }

    @Override
    public User getUserByEmail(String email) {
        return userMapper.toUser(userRepository.findByEmail(email).get());
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public List<User> findClientByRol(String roleName) {
        return userMapper.toUser(userRepository.findClientByRoleId(roleName));
    }
    @Override
    public boolean existsByID(Long id) {
        return userRepository.existsById(id);
    }
}
