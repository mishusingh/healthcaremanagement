package com.healthcaremanagement.appointmentservice.DTO;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class AppointmentRequest {
    private Long patientId;
    private Long doctorId;
    private LocalDateTime appointmentDateTime;
    private String status; // e.g., "Scheduled", "Completed", "Cancelled"

}
