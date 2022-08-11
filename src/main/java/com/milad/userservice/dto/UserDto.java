package com.milad.userservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserDto implements Serializable {


    private String userName;

    private String password;

    private Boolean active;

    private RoleDto roleDto;

    @JsonProperty("personality")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private PersonalityDto personalityDto;
}
