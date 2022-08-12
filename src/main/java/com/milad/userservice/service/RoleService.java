package com.milad.userservice.service;

import com.milad.userservice.dto.RoleDto;
import com.milad.userservice.model.Role;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface RoleService {

    Role getRoleById(Long id);

    List<RoleDto> getAllRoles();

    ResponseEntity<String> save(Role role);


}
