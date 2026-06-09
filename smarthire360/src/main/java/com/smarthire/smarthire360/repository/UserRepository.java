package com.smarthire.smarthire360.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smarthire.smarthire360.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}