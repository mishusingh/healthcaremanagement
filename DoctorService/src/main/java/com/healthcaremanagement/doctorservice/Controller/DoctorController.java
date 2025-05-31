package com.healthcaremanagement.doctorservice.Controller;

import com.healthcaremanagement.doctorservice.DTO.DoctorResponseDTO;
import com.healthcaremanagement.doctorservice.Service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    private final DoctorService doctorService;;


    @GetMapping
    public List<DoctorResponseDTO> getAllDoctors() {
        return doctorService.getAllDoctor();
    }

    @GetMapping("/{doctorId}")
    public DoctorResponseDTO getDoctorById(@PathVariable Long doctorId) {
        return doctorService.getDoctorById(doctorId);
    }
}
