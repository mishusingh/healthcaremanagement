package com.healthcaremanagement.appointmentservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentEventListener{

    private String type;
    private String patientEmail;
    private String doctorName;
    private LocalDateTime appointmentDateTime;

}
