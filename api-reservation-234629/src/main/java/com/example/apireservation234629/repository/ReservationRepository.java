package com.example.apireservation234629.repository;

import com.example.apireservation234629.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    boolean existsByDateAndTable(Date date, int table);
}

