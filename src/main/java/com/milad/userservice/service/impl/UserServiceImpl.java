package com.milad.userservice.service.impl;

import com.milad.userservice.dto.UserDto;
import com.milad.userservice.dto.mapper.RoleMapping;
import com.milad.userservice.exception.wrapper.UserModelNotFoundException;
import com.milad.userservice.model.User;
import com.milad.userservice.dto.mapper.UserMapping;
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
    private RoleRepository roleRepository;
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

        userDto.setActive(true);
        userDto.setRoleDto(RoleMapping.getDto(roleRepository.findRoleByRoleName("ROLE_USER")));
        User user = UserMapping.getEntity(userDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));


       return UserMapping.getDto(userRepository.save(user));
    }
}