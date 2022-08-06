package com.milad.userservice.resource;


import com.milad.userservice.dto.UserAuthenticationRequestDto;
import com.milad.userservice.model.User;
import com.milad.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class UserResource {

    private  final UserService userService;

   public UserResource(UserService userService){
        this.userService=userService;
    }




    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserbyId(@PathVariable("id") Long id)
    {
     return new ResponseEntity<>(userService.getUserById(id),HttpStatus.OK);

    }


    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users =  userService.getAllUsers();
        if(!users.isEmpty()) {
            return new ResponseEntity<List<User>>(users,HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/hellowuser")
    public ResponseEntity<String> hellowUser(){

        return new ResponseEntity<String>("Hellow user roool",HttpStatus.OK);
    }


}
