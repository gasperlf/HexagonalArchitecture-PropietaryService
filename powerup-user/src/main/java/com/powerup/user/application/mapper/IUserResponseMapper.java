package com.powerup.user.application.mapper;

import com.powerup.user.application.dto.UserResponse;
import com.powerup.user.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserResponseMapper {
    @Mappings({
            @Mapping(target="name", source="name"),
            @Mapping(target="lastName", source="lastName"),
            @Mapping(target="phone", source="phone"),
            @Mapping(target="email", source="email"),
            @Mapping(target="role", source="role")
    })
    UserResponse toUserResponse(User user);
    List<UserResponse> toUserResponse(List<User> user);


}
