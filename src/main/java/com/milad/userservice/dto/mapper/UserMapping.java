package com.milad.userservice.dto.mapper;

import com.milad.userservice.dto.UserDto;
import com.milad.userservice.model.User;

public interface UserMapping {

     static User getEntity(final UserDto usersDto) {
        return User.builder()
                .userId(usersDto.getUserId())
                .userName(usersDto.getUserName())
                .password(usersDto.getPassword())
                .active(usersDto.getActive())
                .personality(PersonalityMapping.getEntity(usersDto.getPersonalityDto()))
                .role(RoleMapping.getEntity(usersDto.getRoleDto()))

                .build();
    }

     static UserDto getDto(final User user) {
           return UserDto.builder()
                   .userId(user.getUserId())
                .userName(user.getUserName())
                .active(user.getActive())
                .roleDto(RoleMapping.getDto(user.getRole()))
                .personalityDto( (PersonalityMapping.getDto(user.getPersonality())))
                .build();
    }


}
