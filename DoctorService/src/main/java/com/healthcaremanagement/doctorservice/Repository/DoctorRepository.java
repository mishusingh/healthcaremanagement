package com.healthcaremanagement.doctorservice.Repository;

import com.healthcaremanagement.doctorservice.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
