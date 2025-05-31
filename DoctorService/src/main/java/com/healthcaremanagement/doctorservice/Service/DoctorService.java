package com.healthcaremanagement.doctorservice.Service;

import com.healthcaremanagement.doctorservice.DTO.DoctorRequestDTO;
import com.healthcaremanagement.doctorservice.DTO.DoctorResponseDTO;
import com.healthcaremanagement.doctorservice.Repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final ModelMapper modelMapper;

    public List<DoctorResponseDTO> getAllDoctor(){
        List<DoctorResponseDTO> doctorResponseDTOList = doctorRepository.findAll()
                .stream()
                .map(doctor -> modelMapper.map(doctor, DoctorResponseDTO.class))
                .toList();
        return doctorResponseDTOList;

    }

    public DoctorResponseDTO getDoctorById(Long doctorId) {
        return doctorRepository.findById(doctorId)
                .map(doctor -> modelMapper.map(doctor, DoctorResponseDTO.class))
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + doctorId));
    }
}
