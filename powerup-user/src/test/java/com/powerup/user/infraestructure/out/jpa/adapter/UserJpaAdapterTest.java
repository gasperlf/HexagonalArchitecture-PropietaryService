package com.powerup.user.infraestructure.out.jpa.adapter;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.powerup.user.domain.model.User;
import com.powerup.user.infraestructure.out.jpa.entity.UserEntity;
import com.powerup.user.infraestructure.out.jpa.mapper.IUserMapper;
import com.powerup.user.infraestructure.out.jpa.repository.IUserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.Optional;


@ExtendWith(SpringExtension.class)
class UserJpaAdapterTest {

    @InjectMocks
    UserJpaAdapter userJpaAdapter;

    @Mock
    IUserRepository userRepository;

    @Mock
    IUserMapper userMapper;

    private static User user;
    private static UserEntity userEntity;

    @BeforeAll
    public static void init(){
        user = SaveUserJpaAdapterDataTest.obtainUser();
        userEntity = SaveUserJpaAdapterDataTest.obtainUserEntity();
    }

    @Test
    void saveUser() {
        //Given
        //When
        when(userRepository.findByEmail(any())).thenReturn(Optional.empty());
        when(userMapper.toEntity(user)).thenReturn(userEntity);
        userJpaAdapter.saveUser(user);

        //Then
        verify(userRepository).save(any(UserEntity.class));


    }



//    @Test
//    void getUser() {
//        //When
//        when(userRepository.findById(5L)).thenReturn(Optional.empty());
//
//        userJpaAdapter.getUser(2L);
//        System.out.println("sigo");
//        //Then
//        verify(userMapper).toUser(userRepository.findById(anyLong()).get());
//
//    }

//    @Test
//    void getUserByEmail() {
//        //Given
//        String email = "luis@gmail.com";
//
//        //When
//        userJpaAdapter.getUserByEmail(email);
//
//        //Then
//        verify(userRepository).existsByEmail(any());
//    }

    @Test
    void existsByEmail() {
        //Given
        String email = "angela@gmail.com";

        //When
        userJpaAdapter.existsByEmail(email);

        //Then
        verify(userRepository).existsByEmail(email);
    }

    @Test
    void findClientByRol() {
        //Given
        String roleName = "ROLE_ADMIN";
        //When
        userJpaAdapter.findClientByRol(roleName);
        //Then
        verify(userMapper).toUser(userRepository.findClientByRoleId(roleName));
    }

    @Test
    void existsByID() {
        //Given
        Long id = 3L;
        //When
        userJpaAdapter.existsByID(id);
        //Then
        verify(userRepository).existsById(id);
    }
}