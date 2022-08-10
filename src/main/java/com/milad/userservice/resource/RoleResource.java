package com.milad.userservice.resource;

import com.milad.userservice.exception.wrapper.UserModelNotFoundException;
import com.milad.userservice.model.Role;
import com.milad.userservice.model.User;
import com.milad.userservice.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@Slf4j
public class RoleResource {

    @Autowired
  RoleService roleService;

//    @GetMapping()
//    public ResponseEntity<List<Role>> getAllRole() {
//        List<Role> roles = roleService.getAllRoles();
//        if (!roles.isEmpty()) {
//            return new ResponseEntity<>(rolse, HttpStatus.ACCEPTED);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }


    @GetMapping()
    public List<Role> getAllRole() {
        List<Role> roles = roleService.getAllRoles();
        if (!roles.isEmpty()) {
            return roles;
        }
        throw new UserModelNotFoundException("dfdf");
    }
}
