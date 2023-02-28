package com.powerup.user.application.mapper;

import com.powerup.user.application.dto.UserRequest;
import com.powerup.user.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserRequestMapper {
    @Mappings({
            @Mapping(target="name", source="name"),
            @Mapping(target="lastName", source="lastName"),
            @Mapping(target="idDocument", source="idDocument"),
            @Mapping(target="phone", source="phone"),
            @Mapping(target="email", source="email"),
            @Mapping(target="password", source="password")
    })
    User toUser(UserRequest userRequest);
}
