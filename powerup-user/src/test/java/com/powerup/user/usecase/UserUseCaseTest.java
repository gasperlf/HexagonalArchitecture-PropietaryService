package com.powerup.user.usecase;

import com.powerup.user.domain.model.User;
import com.powerup.user.domain.spi.IRolePersistencePort;
import com.powerup.user.domain.spi.IUserPersistencePort;
import com.powerup.user.domain.usecase.UserUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class UserUseCaseTest {

    @InjectMocks
    UserUseCase userUseCase;

    @Mock
    IUserPersistencePort userPersistencePort;

    @Mock
    IRolePersistencePort rolePersistencePort;

    @Test
    void saveUser() {
//        when(userRepository.findByEmail(any())).thenReturn(Optional.empty());
        //Given
        User user = SaveUserUseCaseDataTest.obtainUser();
        Long idRol = 2L;

        //When
        user.setRole(rolePersistencePort.getRoleById(anyLong()));
        user.setId(anyLong());

        userUseCase.saveUser(user, idRol);

        // Then
        verify(userPersistencePort).saveUser(any(User.class));
    }

    @Test
    void getUser() {

        // When
        userUseCase.getUser(anyLong());

        // Then
        verify(userPersistencePort).getUser(anyLong());
    }

    @Test
    void getUserByEmail() {
        //Given
        String email = "luis@gmail.com";

        //When
        userUseCase.getUserByEmail(email);

        //Then
        verify(userPersistencePort).getUserByEmail(email);
    }

    @Test
    void existByEmail() {
        //Given
        String email = "jeisson@gmail.com";

        //When
        userUseCase.existByEmail(email);

        //Then
        verify(userPersistencePort).existsByEmail(email);
    }

    @Test
    void findClientByIdRole() {
        //Given
        String roleName = "ROLE_PROPRIETARY";

        //When
        userUseCase.findClientByIdRole(roleName);

        //Then
        verify(userPersistencePort).findClientByRol(roleName);
    }

    @Test
    void existByID() {
        //When
        userUseCase.existByID(anyLong());

        //Then
        verify(userPersistencePort).existsByID(anyLong());
    }
}