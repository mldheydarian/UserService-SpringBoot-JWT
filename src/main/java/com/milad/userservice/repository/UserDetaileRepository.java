package com.milad.userservice.repository;

import com.milad.userservice.model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetaileRepository extends JpaRepository<UserDetail,Long> {
}
