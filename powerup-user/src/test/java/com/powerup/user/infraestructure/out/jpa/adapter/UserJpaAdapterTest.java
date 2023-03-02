package com.powerup.user.infraestructure.out.jpa.adapter;

import com.powerup.user.domain.model.User;
import com.powerup.user.infraestructure.out.jpa.mapper.IUserMapper;
import com.powerup.user.infraestructure.out.jpa.repository.IUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class UserJpaAdapterTest {

    @InjectMocks
    UserJpaAdapter userJpaAdapter;

    @Mock
    IUserRepository userRepository;

    @Mock
    IUserMapper userMapper;

    @Test
    void saveUser() {
        //Given
//        when(userRepository.findByEmail(any())).thenReturn(Optional.empty());

    }

    @Test
    void getUser() {
    }

    @Test
    void getUserByEmail() {
    }

    @Test
    void existsByEmail() {
    }

    @Test
    void findClientByRol() {
    }

    @Test
    void existsByID() {
    }
}