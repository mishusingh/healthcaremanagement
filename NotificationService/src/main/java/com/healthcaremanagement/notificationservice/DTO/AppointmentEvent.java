package com.healthcaremanagement.notificationservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppointmentEvent {
    private String type;
    private String patientEmail;
    private String doctorName;
    private LocalDateTime appointmentDateTime;
}
