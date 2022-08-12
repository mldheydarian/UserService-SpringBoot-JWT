package com.milad.userservice.resource;

import com.milad.userservice.dto.UserDto;
import com.milad.userservice.model.User;
import com.milad.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserResource {

    private  final UserService userService;

   public UserResource(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id)
    {
     return new ResponseEntity(userService.getUserById(id),HttpStatus.OK);

    }

   @GetMapping("")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> userDtos =  userService.getAllUsers();
        if(!userDtos.isEmpty()) {
            return new ResponseEntity<>(userDtos,HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/hellow")
    public ResponseEntity<String> hellowUser(){

        return new ResponseEntity<>("Hellow personality roool",HttpStatus.OK);
    }


}
