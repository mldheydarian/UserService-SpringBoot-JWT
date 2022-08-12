package com.milad.userservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public  class AddressDto  {
	

	private String tittle;

	private String fullAddress;

	private String postalCode;

	private String city;

	@JsonProperty("personality")
	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private PersonalityDto personalityDto;
	
}










