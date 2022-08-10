package com.milad.userservice.service.impl;

import com.milad.userservice.model.Role;
import com.milad.userservice.model.User;
import com.milad.userservice.repository.RoleRepository;
import com.milad.userservice.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository RoleRepository;

    @Override
    public Role getRoleById(Long id) {
        return null;
    }

    @Override
    public List<Role> getAllRoles() {
        return RoleRepository.findAll();
    }

    @Override
    public ResponseEntity<String> save(Role role) {
        return null;
    }
}
