package com.healthcaremanagement.patientservice.Service;

import com.healthcaremanagement.patientservice.DTO.PatientRequestDTO;
import com.healthcaremanagement.patientservice.DTO.PatientResponseDTO;
import com.healthcaremanagement.patientservice.Entity.Patient;
import com.healthcaremanagement.patientservice.Repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;

    public PatientResponseDTO createPatient(PatientRequestDTO DTO) {

        Patient patient = modelMapper.map(DTO, Patient.class);
        patient.setName(DTO.getName());
        patient.setEmail(DTO.getEmail());
        patient.setPhoneNumber(DTO.getPhoneNumber());
        patient.setAddress(DTO.getAddress());

        Patient savedPatient = patientRepository.save(patient);
        return modelMapper.map(savedPatient, PatientResponseDTO.class);
    }

    public PatientResponseDTO getPatientByID(Long patientId){
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found with ID: " + patientId));

        return modelMapper.map(patient, PatientResponseDTO.class);
    }


    public List<PatientResponseDTO> getAllPatient(){
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(patient -> modelMapper.map(patient, PatientResponseDTO.class))
                .toList();
    }

}
