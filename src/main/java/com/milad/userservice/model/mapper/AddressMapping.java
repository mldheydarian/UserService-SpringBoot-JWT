package com.milad.userservice.model.mapper;

import com.milad.userservice.dto.AddressDto;
import com.milad.userservice.model.Address;


public interface AddressMapping {

     static AddressDto getDto(Address address) {
        return AddressDto.builder()
                .tittle(address.getTittle())
                .fullAddress(address.getFullAddress())
                .city(address.getCity())
                .postalCode(address.getPostalCode())
                .personalityDto(PersonalityMapping.getDto(address.getPersonality())) //todo:For pressent
                .build();
    }

     static Address getEntity(AddressDto addressDto) {
        return Address.builder()
                .tittle(addressDto.getTittle())
                .fullAddress(addressDto.getFullAddress())
                .city(addressDto.getCity())
                .postalCode(addressDto.getPostalCode())
                .personality(PersonalityMapping.getEntity(addressDto.getPersonalityDto()))//todo:For pressent
                .build();
    }
}
