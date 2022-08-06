package com.milad.userservice.service;

import com.milad.userservice.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    public User getUserById(Long id);

    public List<User> getAllUsers();

    public ResponseEntity<String> save(User user);
}
