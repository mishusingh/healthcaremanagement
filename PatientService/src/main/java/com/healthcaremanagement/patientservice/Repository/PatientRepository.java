package com.healthcaremanagement.patientservice.Repository;

import com.healthcaremanagement.patientservice.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, Long> {


}
