package com.milad.userservice.service.impl;

import com.milad.userservice.model.User;
import com.milad.userservice.model.UserRole;
import com.milad.userservice.repository.UserRepository;
import com.milad.userservice.repository.UserRoleRepository;
import com.milad.userservice.service.UserService;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public User getUserById(Long id) {
        log.info("UserServise:Fetch All User");
        return userRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        user.setActive(true);
     UserRole userRole= userRoleRepository.findUserRoleByRoleName("ROLE_USER");
     user.setRole(userRole);
     return userRepository.save(user);
    }
}
