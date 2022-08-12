package com.milad.userservice.service.impl;

import com.milad.userservice.dto.PersonalityDto;
import com.milad.userservice.dto.UserDto;
import com.milad.userservice.dto.mapper.PersonalityMapping;
import com.milad.userservice.dto.mapper.RoleMapping;
import com.milad.userservice.dto.mapper.UserMapping;
import com.milad.userservice.model.Personality;
import com.milad.userservice.model.User;
import com.milad.userservice.repository.PersonalityRepository;
import com.milad.userservice.repository.RoleRepository;
import com.milad.userservice.service.PersonalityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;


@Transactional
@Service
@Slf4j

public class PersonalityServiceImpl implements PersonalityService {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    PersonalityRepository personalityRepository;

    @Override
    public PersonalityDto save(@RequestBody PersonalityDto personalityDto) {

//        personalityDto.getUsersDto().setRoleDto(RoleMapping.getDto(roleRepository.findRoleByRoleName("ROLE_USER")));
//        personalityDto.getUsersDto().setActive(true);
//        Personality personality=new Personality();
//        personality = PersonalityMapping.getEntity(personalityDto);
//        personality.setUser(UserMapping.getEntityWithOutPersonality(personalityDto.getUsersDto()));
//        personality.getUser().setPassword(passwordEncoder.encode(personality.getUser().getPassword()));
//       personalityRepository.save(personality);
        return personalityDto;
    }

}
