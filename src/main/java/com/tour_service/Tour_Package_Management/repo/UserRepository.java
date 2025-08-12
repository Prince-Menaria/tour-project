package com.tour_service.Tour_Package_Management.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tour_service.Tour_Package_Management.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
