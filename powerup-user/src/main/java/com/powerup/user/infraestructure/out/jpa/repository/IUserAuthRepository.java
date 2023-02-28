package com.powerup.user.infraestructure.out.jpa.repository;

import com.powerup.user.infraestructure.out.jpa.entity.UserAuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserAuthRepository extends JpaRepository<UserAuthEntity, Long> {

    UserAuthEntity findOneByEmail(String emailUser);

}
