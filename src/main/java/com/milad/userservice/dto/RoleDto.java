package com.milad.userservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RoleDto   {

    private Long roleId;

    private String roleName;

    @JsonProperty("users")
    private List<UserDto> usersDtos;


}