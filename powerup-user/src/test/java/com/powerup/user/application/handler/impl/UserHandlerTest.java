package com.powerup.user.application.handler.impl;

import com.powerup.user.application.mapper.IUserRequestMapper;
import com.powerup.user.application.mapper.IUserResponseMapper;
import com.powerup.user.domain.api.IUserServicePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

// Simulates application context
@ExtendWith(SpringExtension.class)
class UserHandlerTest {

    // Injecting the class to test
    @InjectMocks
    UserHandler userHandler;

    // Injecting dependencies
    @Mock
    IUserServicePort iUserServicePort;

    @Mock
    IUserRequestMapper iUserRequestMapper;

    @Mock
    IUserResponseMapper iUserResponseMapper;

    @Test
    void mustsaveUser() {
    }

    @Test
    void getUser() {
    }
}