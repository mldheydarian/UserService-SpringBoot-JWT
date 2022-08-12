package com.milad.userservice.dto.mapper;

import com.milad.userservice.dto.AddressDto;
import com.milad.userservice.model.Address;

 /*
    only package member access to this interface
    because address return by personalityDto
 */
interface AddressMapping {

    static AddressDto getDto(final Address address) {
        return AddressDto.builder()
                .tittle(address.getTittle())
                .fullAddress(address.getFullAddress())
                .city(address.getCity())
                .postalCode(address.getPostalCode())
                //.personalityDto(PersonalityMapping.getDto(address.getPersonality())) //cause  loop
                .build();
    }

    static Address getEntity(final AddressDto addressDto) {
        return Address.builder()
                .tittle(addressDto.getTittle())
                .fullAddress(addressDto.getFullAddress())
                .city(addressDto.getCity())
                .postalCode(addressDto.getPostalCode())
                // loop .personality(PersonalityMapping.getEntity(addressDto.getPersonalityDto())) //cause  loop
                .build();
    }
}
