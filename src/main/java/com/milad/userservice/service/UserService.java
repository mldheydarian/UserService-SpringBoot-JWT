package com.milad.userservice.service;

import com.milad.userservice.dto.UserDto;

import java.util.List;

public interface UserService {

     UserDto getUserById(Long id);

     List<UserDto> getAllUsers();

     UserDto save(UserDto UserDto);
}
