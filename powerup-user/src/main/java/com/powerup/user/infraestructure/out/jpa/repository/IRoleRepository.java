package com.powerup.user.infraestructure.out.jpa.repository;

import com.powerup.user.infraestructure.out.jpa.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByName(String name);
    @Override
    Optional<RoleEntity> findById(Long aLong);
}
