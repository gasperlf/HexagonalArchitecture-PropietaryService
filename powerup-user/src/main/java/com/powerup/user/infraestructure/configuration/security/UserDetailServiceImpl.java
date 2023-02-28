package com.powerup.user.infraestructure.configuration.security;

import com.powerup.user.infraestructure.out.jpa.entity.UserAuthEntity;
import com.powerup.user.infraestructure.out.jpa.mapper.IUserMapper;
import com.powerup.user.infraestructure.out.jpa.repository.IUserAuthRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final IUserAuthRepository userAuthRepository;


    public UserDetailServiceImpl(IUserAuthRepository userAuthRepository) {
        this.userAuthRepository = userAuthRepository;

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        try{
            UserAuthEntity user = userAuthRepository.findOneByEmail(email);
            return new UserDetailsImpl(user);

        } catch(UsernameNotFoundException e) {
                return null;
        }

    }

//                .orElseThrow(() -> new UsernameNotFoundException("El usuario con email "+ email + " no existe"));


}
