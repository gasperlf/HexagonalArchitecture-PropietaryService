package com.powerup.user.infraestructure.out.jpa.adapter;

import com.powerup.user.domain.model.Role;
import com.powerup.user.domain.spi.IRolePersistencePort;
import com.powerup.user.infraestructure.out.jpa.entity.RoleEntity;
import com.powerup.user.infraestructure.out.jpa.mapper.IRoleMapper;
import com.powerup.user.infraestructure.out.jpa.repository.IRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RoleJpaAdapter implements IRolePersistencePort {
    private final IRoleRepository roleRepository;
    private final IRoleMapper roleMapper;

    @Override
    public List<Role> getAllRoles() {
        return roleMapper.toRoles(roleRepository.findAll());
    }

    @Override
    public Role getRoleById(Long id) {
        return roleMapper.toRole(roleRepository.findById(id).get());
    }

    @Override
    public Role getRoleByName(String name) {
        return roleMapper.toRole(roleRepository.findByName(name).get());
    }
}
