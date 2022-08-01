package com.milad.userservice.repository;

import com.milad.userservice.model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetaileRepository extends JpaRepository<UserDetail,Long> {
}
