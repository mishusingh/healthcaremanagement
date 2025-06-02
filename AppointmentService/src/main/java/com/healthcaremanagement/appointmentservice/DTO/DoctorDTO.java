package com.healthcaremanagement.appointmentservice.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO {
    private Long doctorId;
    private String name;
    private String specialization;
     private String email;


}
