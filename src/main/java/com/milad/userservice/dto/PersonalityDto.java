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
public class PersonalityDto {

    private long personalityId;

    private String firstName;

    private String lastName;

    private String imageUrl;

    private String email;

    private String phone;

    @JsonProperty("addresses")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private List<AddressDto> addressesDtos;

    @JsonProperty("Users")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private UserDto UsersDto;


}
