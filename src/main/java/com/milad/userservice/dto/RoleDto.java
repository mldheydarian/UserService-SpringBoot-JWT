package com.milad.userservice.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RoleDto  implements Serializable {

    private Long id;

    private String roleName;

    private List<UserDto> usersDtos;


}