package com.healthcaremanagement.patientservice.Controller;

import com.healthcaremanagement.patientservice.DTO.PatientRequestDTO;
import com.healthcaremanagement.patientservice.DTO.PatientResponseDTO;
import com.healthcaremanagement.patientservice.Service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    public PatientResponseDTO createPatient(@RequestBody PatientRequestDTO patientRequestDTO) {
        return patientService.createPatient(patientRequestDTO);
    }

    @GetMapping("/{patientId}")
    public PatientResponseDTO getPatientById(@PathVariable Long patientId) {
        return patientService.getPatientByID(patientId);
    }

    @GetMapping
    public List<PatientResponseDTO> getAllPatients() {
        return patientService.getAllPatient();
    }
}
