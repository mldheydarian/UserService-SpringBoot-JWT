package com.milad.userservice.service.impl;

import com.milad.userservice.exception.wrapper.UserModelNotFoundException;
import com.milad.userservice.model.User;
import com.milad.userservice.model.Role;
import com.milad.userservice.repository.UserRepository;
import com.milad.userservice.repository.RoleRepository;
import com.milad.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


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
    public User getUserById(Long id) {
        log.info("UserServise:Fetch All User");
        return userRepository.findById(id)
        // .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "**User not found*"));
           .orElseThrow(()-> new UserModelNotFoundException(String.format("**ControlAdvice:User by id:%d not found",id)));


    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public ResponseEntity<String> save(User user) {
        try {

            user.setActive(true);
            Role role = RoleRepository.findRoleByRoleName("ROLE_USER");
            //TODO:USER ROLE SHUOLD BE SET IN USER
            user.setRole(role);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return ResponseEntity.ok("User save suuccsesfully");
        }
        catch (Exception ex){

            return ResponseEntity.badRequest().body("Something went wrong :" + ex.getMessage());        }
    }


}
