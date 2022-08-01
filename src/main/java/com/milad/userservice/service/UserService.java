package com.milad.userservice.service;

import com.milad.userservice.model.User;

import java.util.List;

public interface UserService {

    public User getUserById(Long id);

    public List<User> getAllUsers();

    public User save(User user);
}
