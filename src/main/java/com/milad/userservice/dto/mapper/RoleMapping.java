package com.milad.userservice.dto.mapper;

import com.milad.userservice.dto.RoleDto;
import com.milad.userservice.dto.UserDto;
import com.milad.userservice.model.Role;

import java.util.stream.Collectors;

public interface RoleMapping {

 public    static Role getEntity(final RoleDto roleDto)
    {

        return Role.builder()
                .roleId(roleDto.getRoleId())
                .roleName(roleDto.getRoleName())
//                .users(roleDto.getUsersDtos()
//                        .stream()
//                        .map(UserMapping::getEntity)
//                        .collect(Collectors.toList())) //cause looping between roleDto and personalityDto
                
                .build();
    }

  public   static RoleDto getDto(final Role role)
    {
        return RoleDto.builder()
                .roleId(role.getRoleId())
                .roleName(role.getRoleName())
//               .usersDtos(role.getUsers()
//                        .stream()
//                        .map(UserMapping::getDto)
//                        .collect(Collectors.toList()))

                .build();
    }
}
