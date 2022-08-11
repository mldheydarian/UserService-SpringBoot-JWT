package com.milad.userservice.model.mapper;

import com.milad.userservice.dto.RoleDto;
import com.milad.userservice.model.Role;

import java.util.stream.Collectors;

public interface RoleMapping {

    static Role getEntity(RoleDto roleDto)
    {

        return Role.builder()
                .roleName(roleDto.getRoleName())
                .users(roleDto.getUsersDtos()
                        .stream()
                        .map(UserMapping::getEntity)
                        .collect(Collectors.toList()))
                
                .build();
    }

    static RoleDto getDto(Role role)
    {

        return RoleDto.builder()
                .roleName(role.getRoleName())
                .usersDtos(role.getUsers()
                        .stream()
                        .map(UserMapping::getDto)
                        .collect(Collectors.toList()))

                .build();
    }
}
