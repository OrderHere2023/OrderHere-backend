package com.backend.OrderHere.repository;

import com.backend.OrderHere.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.OrderHere.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
//    User findByEmail(String email);
    User findByUsernameAndEmail(String username, String email);
}
