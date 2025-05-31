package com.healthcaremanagement.appointmentservice.DTO;


import lombok.Data;

@Data
public class DoctorDTO {
    private Long doctorId;
    private String name;
    private String specialization;
     private String email;


}
