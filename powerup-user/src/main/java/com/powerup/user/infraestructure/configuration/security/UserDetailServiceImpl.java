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

//    private final IUserRepository userRepository;
    private final IUserAuthRepository userAuthRepository;
    private final IUserMapper userMapper;

    public UserDetailServiceImpl(IUserAuthRepository userAuthRepository, IUserMapper userMapper) {
        this.userAuthRepository = userAuthRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

//        UserEntity user = userRepository.findByEmail(email);
//        UserEntity user = userRepository
//                .findByEmail(email);
//        try {
//            User user = userMapper.toUser(userRepository
//                    .findByEmail(email));
//
//            return new UserDetailsImpl(user);
            UserAuthEntity user = userAuthRepository.findOneByEmail(email);
            if(user == null) {
                throw new UsernameNotFoundException("USER NOT FOOOUND");
            }


            return new UserDetailsImpl(user);
//        } catch(UsernameNotFoundException e) {
//                System.out.println("No user found");
//                return null;
//        }
    }

//                .orElseThrow(() -> new UsernameNotFoundException("El usuario con email "+ email + " no existe"));





}
