package com.healthcaremanagement.appointmentservice.Client;

import com.healthcaremanagement.appointmentservice.DTO.DoctorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "DoctorService", url = "http://localhost:8081")
public interface DoctorClient {

    @GetMapping("/api/v1/doctors/{doctorId}")
    DoctorDTO getDoctorById(@PathVariable Long doctorId);
}
