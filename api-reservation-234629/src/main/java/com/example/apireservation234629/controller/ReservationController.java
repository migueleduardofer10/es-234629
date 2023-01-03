package com.example.apireservation234629.controller;

import com.example.apireservation234629.model.Reservation;
import com.example.apireservation234629.model.User;
import com.example.apireservation234629.repository.ReservationRepository;
import com.example.apireservation234629.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ReservationController {
    private final UserRepository userRepository;
    private final ReservationRepository reservationRepository;

    public ReservationController(UserRepository userRepository, ReservationRepository reservationRepository) {
        this.userRepository = userRepository;
        this.reservationRepository = reservationRepository;
    }

    @PostMapping("/reservations")
    @Transactional
    public ResponseEntity<Reservation> save(@RequestParam("date") LocalDateTime date,
                                            @RequestParam("numberOfPeople") int numberOfPeople,
                                            @RequestParam("table") int table,
                                            @RequestParam("userEmail") String userEmail)throws IOException {

        Reservation reservation = new Reservation();
        reservation.setDate(date);
        reservation.setNumberOfPeople(numberOfPeople);
        reservation.setTable(table);

        List<User> user = userRepository.findByEmail(userEmail);

        if( user!=null) {
            reservation.setUser(user.get(0));
        }


        Reservation productSaved=reservationRepository.save(reservation);

        return new ResponseEntity<Reservation>(productSaved, HttpStatus.CREATED);
    }

    @Transactional
    @DeleteMapping("/reservations/{id}")
    public ResponseEntity<Reservation> delete(@PathVariable Long id) {
        reservationRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
