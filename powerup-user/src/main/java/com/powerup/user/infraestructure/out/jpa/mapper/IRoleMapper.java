
package com.powerup.user.infraestructure.out.jpa.mapper;

import com.powerup.user.domain.model.Role;
import com.powerup.user.infraestructure.out.jpa.entity.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRoleMapper {
    @Mappings({
            @Mapping(target="id", source="id"),
            @Mapping(target="name", source="name"),
            @Mapping(target="description", source="description")
    })
    RoleEntity toEntity(Role role);

    Role toRole(RoleEntity roleEntity);
    List<Role> toRoles(List<RoleEntity> roleEntity);
}