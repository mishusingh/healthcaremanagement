package com.healthcaremanagement.appointmentservice.FallBack;

import com.healthcaremanagement.appointmentservice.Client.DoctorClient;
import com.healthcaremanagement.appointmentservice.DTO.DoctorDTO;
import org.springframework.stereotype.Component;

@Component
public class DoctorClientFallBack implements DoctorClient {
    @Override
    public DoctorDTO getDoctorById(Long doctorId) {
        return new DoctorDTO(doctorId, "Fallback Doctor", "N/A", "Unavailable");
    }
}
