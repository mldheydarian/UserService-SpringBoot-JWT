package com.milad.userservice.repository;

import com.milad.userservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetaileRepository extends JpaRepository<Customer,Long> {
}
