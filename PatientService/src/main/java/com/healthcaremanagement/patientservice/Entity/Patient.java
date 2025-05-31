package com.healthcaremanagement.patientservice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "patient_id")
    public Long patientId;
    @Column(name = "name", nullable = false)
    public String name;
    @Column(name = "email", unique = true, nullable = false)
    public String email;
    @Column(name = "phone_number", unique = true, nullable = false)
    public String phoneNumber;
    @Column(name = "address", nullable = false)
    public String address;
}
