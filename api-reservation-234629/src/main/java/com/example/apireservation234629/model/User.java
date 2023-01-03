package com.example.apireservation234629.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name", length = 60, nullable = false)
    private String name;
    @Column(name="email", length = 60, nullable = false)
    private String email;
    @Column(name="phone" , length = 60, nullable = false)
    private BigDecimal phone;
    @Column(name="address", length = 60, nullable = false)
    private String address;
}
