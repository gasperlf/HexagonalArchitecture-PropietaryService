package com.powerup.user.infraestructure.out.jpa.mapper;

import com.powerup.user.domain.model.User;
import com.powerup.user.infraestructure.out.jpa.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {
    @Mappings({
            @Mapping(target="id", source="id"),
            @Mapping(target="name", source="name"),
            @Mapping(target="lastName", source="lastName"),
            @Mapping(target="idDocument", source="idDocument"),
            @Mapping(target="phone", source="phone"),
            @Mapping(target="email", source="email"),
            @Mapping(target="password", source="password")
    })
    UserEntity toEntity(User user);
    User toUser(UserEntity userEntity);
    List<User> toUser(List<UserEntity> userEntity);
}
