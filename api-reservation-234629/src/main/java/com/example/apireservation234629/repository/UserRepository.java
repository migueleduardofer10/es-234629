package com.example.apireservation234629.repository;

import com.example.apireservation234629.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    //Encontrar usuario por email
    List<User> findByEmail(String email);
}