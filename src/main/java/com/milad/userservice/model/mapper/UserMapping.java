package com.milad.userservice.model.mapper;

import com.milad.userservice.dto.UserDto;
import com.milad.userservice.model.User;

public interface UserMapping {

    static User getEntity(UserDto UsersDto) {
        return User.builder()
                .userName(UsersDto.getUserName())
                .password(UsersDto.getPassword())
                .build();
    }

    static UserDto getDto(User user) {
        return UserDto.builder()
                .userName(user.getUserName())
                .personalityDto((PersonalityMapping.getDto(user.getPersonality())))
                .roleDto(RoleMapping.getDto(user.getRole()))
                .active(user.getActive())
                .build();
    }


}
