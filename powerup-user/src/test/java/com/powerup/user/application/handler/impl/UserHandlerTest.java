package com.powerup.user.application.handler.impl;

import com.powerup.user.application.dto.UserRequest;
import com.powerup.user.application.dto.UserResponse;
import com.powerup.user.application.mapper.IUserRequestMapper;
import com.powerup.user.application.mapper.IUserResponseMapper;
import com.powerup.user.domain.api.IUserServicePort;
import com.powerup.user.domain.model.Role;
import com.powerup.user.domain.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class UserHandlerTest {

    @InjectMocks
    UserHandler userHandler;

    @Mock
    IUserServicePort iUserServicePort;

    @Mock
    IUserRequestMapper iUserRequestMapper;

    @Mock
    IUserResponseMapper iUserResponseMapper;

    @Mock
    PasswordEncoder passwordEncoder;


    @Test
    void saveProprietaryUser() {

        // Given
        User user = SaveHandlerDataTest.obtainProprietaryUser();
        UserRequest userRequest = SaveHandlerDataTest.obtainUserRequest();
        Long idRol = 2L;

        // When
        when(iUserRequestMapper.toUser(any())).thenReturn(user);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userHandler.saveUser(userRequest, idRol);

        // Then
        verify(iUserServicePort).saveUser(user,idRol);
    }

    @Test
    void saveEmployeeUser() {

        // Given
        User user = SaveHandlerDataTest.obtainEmployeeUser();
        UserRequest userRequest = SaveHandlerDataTest.obtainUserRequest();
        Long idRol = 3L;

        // When
        when(iUserRequestMapper.toUser(any())).thenReturn(user);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userHandler.saveUser(userRequest, idRol);

        // Then
        verify(iUserServicePort).saveUser(user,idRol);
    }

    @Test
    void saveClientUser() {

        // Given
        User user = SaveHandlerDataTest.obtainClientUser();
        UserRequest userRequest = SaveHandlerDataTest.obtainUserRequest();
        Long idRol = 4L;

        // When
        when(iUserRequestMapper.toUser(any())).thenReturn(user);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userHandler.saveUser(userRequest, idRol);

        // Then
        verify(iUserServicePort).saveUser(user,idRol);
    }

    @Test
    void getUser() {
        // Given
        User user = SaveHandlerDataTest.obtainProprietaryUser();
        UserResponse userResponse = SaveHandlerDataTest.obtainUserResponse();

        // When
        when(iUserServicePort.getUser(anyLong())).thenReturn(user);
        userHandler.getUser(anyLong());

        // Then
        verify(iUserResponseMapper).toUserResponse(any(User.class));
    }

    @Test
    void getUserByEmail() {
        //Given
        String email = "angela@gmail.com";

        //When
        userHandler.getUserByEmail(email);

        verify(iUserResponseMapper).toUserResponse(iUserServicePort.getUserByEmail(email));
    }

    @Test
    void findClientByRol() {
        // Given
        String roleName = "ROLE_PROPRIETARY";

        // When
        userHandler.findClientByRol(roleName);

        // Then
        verify(iUserResponseMapper).toUserResponse(iUserServicePort.findClientByIdRole(roleName));
    }
}