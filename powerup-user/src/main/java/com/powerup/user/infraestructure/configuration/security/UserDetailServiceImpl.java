package com.powerup.user.infraestructure.configuration.security;

import com.powerup.user.infraestructure.out.jpa.entity.UserAuthEntity;
import com.powerup.user.infraestructure.out.jpa.entity.UserEntity;
import com.powerup.user.infraestructure.out.jpa.repository.IUserAuthRepository;
import com.powerup.user.infraestructure.out.jpa.repository.IUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final IUserAuthRepository userAuthRepository;
    private final IUserRepository userRepository;


    public UserDetailServiceImpl(IUserAuthRepository userAuthRepository, IUserRepository userRepository) {
        this.userAuthRepository = userAuthRepository;

        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        try{
            UserAuthEntity user = userAuthRepository.findOneByEmail(email);
//            UserEntity user = userRepository.findByEmail(email);


            return new UserDetailsImpl(user);

        } catch(UsernameNotFoundException e) {
                return null;
        }

    }

//                .orElseThrow(() -> new UsernameNotFoundException("El usuario con email "+ email + " no existe"));


}
