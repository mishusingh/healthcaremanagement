package com.healthcaremanagement.appointmentservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {
    private Long patientId;
    private String name;
    private String email;
    private String phoneNumber;


}
