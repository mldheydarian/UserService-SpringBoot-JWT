package com.milad.userservice.auth.service;

import com.milad.userservice.model.User;
import com.milad.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@Slf4j
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
     UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUserName(username); // fetch user by email is beeter
        if (user != null && user.getActive()) {
            log.info("User Found in database.");
            return org.springframework.security.core.userdetails.User
                    .withUsername(username)
                    .password(user.getPassword())
                    .authorities(user.getRole().getRoleName()).build();
            // return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getUserPassword()));

        } else {
            log.info("My login Exception.");
            throw new UsernameNotFoundException("Authentication of user is failed.");
        }
    }
}
