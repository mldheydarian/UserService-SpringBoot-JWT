package com.milad.userservice.resource;

import com.milad.userservice.dto.RoleDto;
import com.milad.userservice.dto.UserDto;
import com.milad.userservice.exception.wrapper.UserModelNotFoundException;
import com.milad.userservice.model.Role;

import com.milad.userservice.model.User;
import com.milad.userservice.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.milad.userservice.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/role")
@Slf4j
public class RoleResource {

    @Autowired
  RoleService roleService;


    @GetMapping()
    @ResponseBody
    public ResponseEntity<List<RoleDto>> getAllRole() {
        List<RoleDto> roleDtos = roleService.getAllRoles();
        if (!roleDtos.isEmpty()) {
            return new ResponseEntity<>(roleDtos,HttpStatus.ACCEPTED);
        }
        throw new UserModelNotFoundException("find all Roles  failed!");
    }
}
