package com.milad.userservice.repository;

import com.milad.userservice.model.Personality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalityRepository extends JpaRepository<Personality,Long> {


}
