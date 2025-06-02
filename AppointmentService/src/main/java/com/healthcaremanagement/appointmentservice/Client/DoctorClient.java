package com.healthcaremanagement.appointmentservice.Client;

import com.healthcaremanagement.appointmentservice.DTO.DoctorDTO;
import com.healthcaremanagement.appointmentservice.FallBack.DoctorClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "DoctorService", url = "http://localhost:8081", fallback = DoctorClientFallBack.class)
public interface DoctorClient {

    @GetMapping("/api/v1/doctors/{doctorId}")
    DoctorDTO getDoctorById(@PathVariable Long doctorId);
}
