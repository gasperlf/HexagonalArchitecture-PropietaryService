package com.powerup.user.infraestructure.out.jpa.repository;

import com.powerup.user.infraestructure.out.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {
    @Override
    Optional<UserEntity> findById(Long id);
    Optional<UserEntity> findByEmail(String email);
    boolean existsByEmail(String email);
    List<UserEntity> findClientByRoleId(String roleName);
}
