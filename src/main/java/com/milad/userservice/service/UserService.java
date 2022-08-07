package com.milad.userservice.service;

import com.milad.userservice.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

     User getUserById(Long id);

     List<User> getAllUsers();

     ResponseEntity<String> save(User user);
}
