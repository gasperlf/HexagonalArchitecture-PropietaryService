package com.powerup.user.infraestructure.configuration;

//import com.powerup.user.domain.api.IUserServicePort;
//import com.powerup.user.domain.spi.IRolePersistencePort;
//import com.powerup.user.domain.spi.IUserPersistencePort;
//import com.powerup.user.domain.usecase.UserUseCase;
//import com.powerup.user.infraestructure.out.jpa.adapter.RoleJpaAdapter;
//import com.powerup.user.infraestructure.out.jpa.adapter.UserJpaAdapter;
//import com.powerup.user.infraestructure.out.jpa.entity.UserEntity;
//import com.powerup.user.infraestructure.out.jpa.mapper.IRoleMapper;
//import com.powerup.user.infraestructure.out.jpa.mapper.IUserMapper;
//import com.powerup.user.infraestructure.out.jpa.repository.IRoleRepository;
//import com.powerup.user.infraestructure.out.jpa.repository.IUserRepository;
//import com.powerup.user.infraestructure.security.aut.DetailsUser;
//import com.powerup.user.infraestructure.security.aut.IUserDetailsMapper;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.util.Optional;


import com.powerup.user.domain.api.IUserServicePort;
import com.powerup.user.domain.spi.IRolePersistencePort;
import com.powerup.user.domain.spi.IUserPersistencePort;
import com.powerup.user.domain.usecase.UserUseCase;
import com.powerup.user.infraestructure.out.jpa.adapter.RoleJpaAdapter;
import com.powerup.user.infraestructure.out.jpa.adapter.UserJpaAdapter;
import com.powerup.user.infraestructure.out.jpa.entity.UserEntity;
import com.powerup.user.infraestructure.out.jpa.mapper.IRoleMapper;
import com.powerup.user.infraestructure.out.jpa.mapper.IUserMapper;
import com.powerup.user.infraestructure.out.jpa.repository.IRoleRepository;
import com.powerup.user.infraestructure.out.jpa.repository.IUserRepository;
import com.powerup.user.infraestructure.security.aut.DetailsUser;
import com.powerup.user.infraestructure.security.aut.IUserDetailsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IUserRepository userRepository;

    private final IUserDetailsMapper userDetailsMapper;
    private final IUserMapper userMapper;
    private final IRoleRepository roleRepository;
    private final IRoleMapper roleMapper;


    @Bean
    public IUserPersistencePort userPersistencePort(){
        return new UserJpaAdapter(userRepository,userMapper);
    }
    @Bean
    public IRolePersistencePort rolePersistencePort(){
        return new RoleJpaAdapter(roleRepository,roleMapper);
    }
    @Bean
    public IUserServicePort userServicePort(){
        return new UserUseCase(userPersistencePort(), rolePersistencePort());
    }
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {

        return username -> optionalDetailsUser(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
    private Optional<DetailsUser> optionalDetailsUser(String username) {
        Optional<UserEntity> userEntity = userRepository.findByEmail(username);
        if(userEntity.isEmpty()){
            throw new RuntimeException();
        }
        DetailsUser user = userDetailsMapper.toUser(userEntity.get());
        user.setRole(userEntity.get().getRole().getName());
        return Optional.of(user);
    }
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
