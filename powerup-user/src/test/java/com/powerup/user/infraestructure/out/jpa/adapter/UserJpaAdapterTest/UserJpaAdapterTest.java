//package com.powerup.user.infraestructure.out.jpa.adapter.UserJpaAdapterTest;
//
//import com.powerup.user.domain.model.User;
//import com.powerup.user.domain.model.Role;
//import com.powerup.user.domain.exception.UserAlreadyExistsException;
//import com.powerup.user.infraestructure.out.jpa.adapter.RoleJpaAdapter;
//import com.powerup.user.infraestructure.out.jpa.adapter.UserJpaAdapter;
//import com.powerup.user.infraestructure.out.jpa.entity.RoleEntity;
//import com.powerup.user.infraestructure.out.jpa.entity.UserEntity;
//import com.powerup.user.infraestructure.out.jpa.mapper.IUserMapper;
//import com.powerup.user.infraestructure.out.jpa.repository.IUserRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.Optional;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//
//@ExtendWith(SpringExtension.class)
//class UserJpaAdapterTest {
//
//    @InjectMocks
//    UserJpaAdapter userJpaAdapter;
//
//    @Mock
//    IUserRepository userRepository;
//
//    @Mock
//    IUserMapper userMapper;
//
//    @Mock
//    RoleJpaAdapter roleJpaAdapter;
//
//    @Test
//    void saveUser() {
//        // Given
//        // User makes a request to saveUser
//
//
//        UserEntity userEntity = SaveUserDataTest.obtainUserEntity();
//        RoleEntity roleEntity = SaveUserDataTest.obtainRoleEntity();
//        User user = SaveUserDataTest.obtainUser();
//        Role role = SaveUserDataTest.obtainRole();
//
//        // When
//        // Validations to make
//        when(userRepository.findByEmail(any())).thenReturn(Optional.empty());
//        when(userMapper.toEntity(any())).thenReturn(userEntity);
//        when(roleJpaAdapter.getRole(user.getIdRole())).thenReturn(role);
//        when(roleJpaAdapter.toRoleEntity(role)).thenReturn(roleEntity);
//
//        userJpaAdapter.saveUser(user);
//
//        // Then
//        // UserEntity is created
//        verify(userRepository).save(any(UserEntity.class));
//
//    }
//
//    @Test
//    void throwUserAlreadyExistsExceptionWhenAttemptToSaveUser(){
//        // Given
//        User expectedUser = SaveUserDataTest.obtainUser();
//        UserEntity userEntity = SaveUserDataTest.obtainUserEntity();
//
//        // When
//        when(userRepository.findByEmail(any())).thenReturn(Optional.of(userEntity));
//
//        // Then
//        Assertions.assertThrows(
//                UserAlreadyExistsException.class,
//                () -> {
//                    userJpaAdapter.saveUser(expectedUser);
//                }
//        );
//
//    }
//}