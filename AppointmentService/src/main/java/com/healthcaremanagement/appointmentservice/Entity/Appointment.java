package com.healthcaremanagement.appointmentservice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;
    private Long patientId;
    private Long doctorId;
    @Column(name = "appointment_date_time", nullable = false)
    private LocalDateTime appointmentDateTime;

    private String status; // e.g., "Scheduled", "Completed", "Cancelled"
}
