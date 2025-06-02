package com.healthcaremanagement.appointmentservice.Client;

import com.healthcaremanagement.appointmentservice.DTO.PatientDTO;
import com.healthcaremanagement.appointmentservice.FallBack.PatientClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "PatientService", url = "http://localhost:8080", fallback = PatientClientFallback.class)
public interface PatientClient {
    @GetMapping("/api/v1/patients/{patientId}")
    PatientDTO getPatientById(@PathVariable Long patientId);


}
