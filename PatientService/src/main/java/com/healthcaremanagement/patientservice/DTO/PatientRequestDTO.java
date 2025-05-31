package com.healthcaremanagement.patientservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientRequestDTO {

    public String name;
    public String email;
    public String phoneNumber;
    public String address;
}
