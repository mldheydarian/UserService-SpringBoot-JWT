package com.milad.userservice.resource;


import com.milad.userservice.model.User;
import com.milad.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserResource {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users =  userService.getAllUsers();
        if(!users.isEmpty()) {
            return new ResponseEntity<List<User>>(users,HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);

    }

    @PostMapping
    public User save(@RequestBody User user) {
        userService.save(user);
        return user;
    }
}
