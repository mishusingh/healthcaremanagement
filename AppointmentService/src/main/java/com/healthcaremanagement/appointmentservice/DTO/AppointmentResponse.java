package com.healthcaremanagement.appointmentservice.DTO;

import com.healthcaremanagement.appointmentservice.Entity.Status;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentResponse {
    private Long appointmentId;
    private Long patientId;
    private Long doctorId;
    private LocalDateTime appointmentDateTime;
    private String status;
}
