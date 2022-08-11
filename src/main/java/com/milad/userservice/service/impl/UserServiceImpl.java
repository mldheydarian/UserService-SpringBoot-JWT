package com.milad.userservice.service.impl;

import com.milad.userservice.dto.UserDto;
import com.milad.userservice.exception.wrapper.UserModelNotFoundException;
import com.milad.userservice.model.Role;
import com.milad.userservice.model.User;
import com.milad.userservice.model.mapper.UserMapping;
import com.milad.userservice.repository.RoleRepository;
import com.milad.userservice.repository.UserRepository;
import com.milad.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Transactional
@Service
@Slf4j

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository RoleRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public UserDto getUserById(Long id) {
        log.info("UserServise:Fetch All Personality");
        return userRepository.findById(id)
                .map(UserMapping::getDto)
                .orElseThrow(() -> new UserModelNotFoundException(String.format("**ControlAdvice:Usersby id:%d not found", id)));
// .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "**Usersnot found*"));
    }



    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapping::getDto)
                .collect(Collectors.toList());

    }

    @Override
    public UserDto save(UserDto userDto) {
            User user = new User();

            user = UserMapping.getEntity(userDto);
        user.setActive(true);
            Role role = RoleRepository.findRoleByRoleName("ROLE_USER");
            //TODO:USER ROLE SHUOLD BE SET IN USER
        user.setRole(role);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

            return UserMapping.getDto(userRepository.save(user));
    }
}