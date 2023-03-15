package com.powerup.user.infraestructure.configuration.security.aut;

import com.powerup.user.infraestructure.configuration.security.auth.dto.UserAuthDto;
import com.powerup.user.infraestructure.out.jpa.entity.UserEntity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserDetailsMapper {
    @Mapping(source = "userEntity.role.name", target = "role")
    DetailsUser toUser(UserEntity userEntity);
    UserAuthDto toUserAuth(DetailsUser user);

}
