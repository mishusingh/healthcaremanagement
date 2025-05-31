package com.healthcaremanagement.patientservice.DTO;

import lombok.Data;

import java.util.UUID;

@Data
public class PatientResponseDTO {

    private Long patientId;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;


}
