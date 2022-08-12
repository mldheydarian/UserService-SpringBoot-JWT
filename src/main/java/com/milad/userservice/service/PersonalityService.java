package com.milad.userservice.service;


import com.milad.userservice.dto.PersonalityDto;
import com.milad.userservice.model.Personality;
import org.springframework.stereotype.Service;

@Service
public interface PersonalityService {
     PersonalityDto save(PersonalityDto personalityDto);
}
