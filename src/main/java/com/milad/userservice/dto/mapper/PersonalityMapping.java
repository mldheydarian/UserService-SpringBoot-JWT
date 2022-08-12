package com.milad.userservice.dto.mapper;

import com.milad.userservice.dto.PersonalityDto;
import com.milad.userservice.model.Personality;

import java.util.stream.Collectors;

public interface PersonalityMapping {

     static PersonalityDto getDto(final Personality personality){
        return PersonalityDto.builder()
                .firstName(personality.getFirstName())
                .lastName(personality.getLastName())
                .imageUrl(personality.getImageUrl())
                .email(personality.getEmail())
                .phone(personality.getPhone())
               .addressesDtos(personality.getAddresses()
                       .stream()
                       .map(AddressMapping::getDto)
                       .collect(Collectors.toList()))
               .build();
                //.map(ad -> AddressMapping.getDto(ad))
                //TODO:For pressent
    }

     static Personality getEntity(final PersonalityDto personalityDto){
        return Personality.builder()
                .firstName(personalityDto.getFirstName())
                .lastName(personalityDto.getLastName())
                .imageUrl(personalityDto.getImageUrl())
                .email(personalityDto.getEmail())
                .phone(personalityDto.getPhone())
                .addresses(personalityDto.getAddressesDtos()
                        .stream()
                        .map(AddressMapping::getEntity)
                        .collect(Collectors.toList()))
                .build();


    }
}
