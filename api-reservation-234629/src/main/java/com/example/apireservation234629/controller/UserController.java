package com.example.apireservation234629.controller;

import com.example.apireservation234629.model.Reservation;
import com.example.apireservation234629.model.User;
import com.example.apireservation234629.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @PostMapping("/users")
    public ResponseEntity<User> createEmployee(@RequestBody User user){
        return new ResponseEntity<User>(userRepository.save(user), HttpStatus.CREATED);
    }


}
