package com.healthcaremanagement.appointmentservice.Controller;

import com.healthcaremanagement.appointmentservice.DTO.AppointmentRequest;
import com.healthcaremanagement.appointmentservice.DTO.AppointmentResponse;
import com.healthcaremanagement.appointmentservice.Service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
("/api/v1/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping
    public AppointmentResponse bookAppointment(@RequestBody AppointmentRequest appointmentRequest) {
        return appointmentService.bookAppointment(appointmentRequest);
    }

    @GetMapping("/{appointmentId}")
    public AppointmentResponse getAppointmentById(@PathVariable Long appointmentId) {
        return appointmentService.getAppointmentById(appointmentId);
    }

    @GetMapping("/api/v1/doctors/{patientId}/patient")
    public List<AppointmentResponse> getAppointmentsByPatientId(@PathVariable Long patientId) {
        return appointmentService.getAppointmentsByPatientId(patientId);
    }

    @GetMapping("/api/v1/doctors/{doctorId}/doctor")
    public List<AppointmentResponse> getAppointmentsByDoctorId(@PathVariable Long doctorId) {
        return appointmentService.getAppointmentsByDoctorId(doctorId);
    }

    @GetMapping
    public List<AppointmentResponse> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }
}
