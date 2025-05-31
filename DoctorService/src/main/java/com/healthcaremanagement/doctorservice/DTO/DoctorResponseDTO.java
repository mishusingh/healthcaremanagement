package com.healthcaremanagement.doctorservice.DTO;

import lombok.Data;

@Data
public class DoctorResponseDTO {
    private String doctorId;
    private String name;
    private String specialization;
    private String contactNumber;
    private String email;
}
