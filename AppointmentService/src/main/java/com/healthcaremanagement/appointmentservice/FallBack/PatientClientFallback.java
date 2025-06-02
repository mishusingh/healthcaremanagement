package com.healthcaremanagement.appointmentservice.FallBack;

import com.healthcaremanagement.appointmentservice.Client.PatientClient;
import com.healthcaremanagement.appointmentservice.DTO.PatientDTO;
import org.springframework.stereotype.Component;

@Component
public class PatientClientFallback implements PatientClient {
    @Override
    public PatientDTO getPatientById(Long patientId) {
        return new PatientDTO(patientId, "FallBack Doctor", "N/A", "Unavailable");
    }
}
