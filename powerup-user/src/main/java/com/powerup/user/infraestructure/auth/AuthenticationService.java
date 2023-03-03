package com.powerup.user.infraestructure.auth;

import com.powerup.user.domain.exception.UserDoNotExistException;
import com.powerup.user.infraestructure.out.jpa.entity.UserEntity;
import com.powerup.user.infraestructure.out.jpa.repository.IRoleRepository;
import com.powerup.user.infraestructure.out.jpa.repository.IUserRepository;
import com.powerup.user.infraestructure.security.JwtService;
import com.powerup.user.infraestructure.security.aut.DetailsUser;
import com.powerup.user.infraestructure.security.aut.IUserDetailsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final IUserRepository repository;
    private final IUserDetailsMapper userDetailsMapper;
    private final IRoleRepository rolRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public AuthenticationResponse  authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = optionalDetailsUser(request.getEmail()).get();

        var jwtToken = jwtService.generateToken(user, user.getRole());
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    private Optional<DetailsUser> optionalDetailsUser(String username) {
        Optional<UserEntity> userEntity = repository.findByEmail(username);
        if(userEntity.isEmpty()){
            throw new UserDoNotExistException();
        }
        DetailsUser user = userDetailsMapper.toUser(userEntity.get());
        user.setRole(userEntity.get().getRole().getName());
        return Optional.of(user);
    }


    public UserAuthDto getUserAuth(String email) {
        Optional<UserEntity> userEntity = repository.findByEmail(email);
        if(userEntity.isEmpty()){
            throw new UserDoNotExistException();
        }
        DetailsUser user = userDetailsMapper.toUser(userEntity.get());
        user.setRole(userEntity.get().getRole().getName());

        return userDetailsMapper.toUserAuth(user);
    }
}