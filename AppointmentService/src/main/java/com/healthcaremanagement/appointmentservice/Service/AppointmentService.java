package com.healthcaremanagement.appointmentservice.Service;

import com.healthcaremanagement.appointmentservice.Client.DoctorClient;
import com.healthcaremanagement.appointmentservice.Client.PatientClient;
import com.healthcaremanagement.appointmentservice.DTO.*;
import com.healthcaremanagement.appointmentservice.Entity.Appointment;
import com.healthcaremanagement.appointmentservice.Entity.Status;
import com.healthcaremanagement.appointmentservice.Kafka.KafkaEventPublisher;
import com.healthcaremanagement.appointmentservice.Repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final PatientClient patientClient;
    private final DoctorClient doctorClient;
    private final AppointmentRepository appointmentRepository;

    private final KafkaEventPublisher kafkaEventPublisher;

    public AppointmentResponse bookAppointment(AppointmentRequest appointmentRequest){
        PatientDTO patient = patientClient.getPatientById(appointmentRequest.getPatientId());
        DoctorDTO doctor = doctorClient.getDoctorById(appointmentRequest.getDoctorId());

        Appointment appointment = new Appointment();
        appointment.setPatientId(patient.getPatientId());
        appointment.setDoctorId(doctor.getDoctorId());
        appointment.setAppointmentDateTime(appointmentRequest.getAppointmentDateTime());
        appointment.setStatus(appointmentRequest.getStatus());

        appointment = appointmentRepository.save(appointment);
        AppointmentEventListener eventListener = new AppointmentEventListener();
        eventListener.setType("APPOINTMENT_BOOKED");
        eventListener.setPatientEmail(patient.getEmail());
        eventListener.setDoctorName(doctor.getName());
        eventListener.setAppointmentDateTime(appointmentRequest.getAppointmentDateTime());

        kafkaEventPublisher.publishEvent(eventListener);
        return mapToResponse(appointment);


    }


    public AppointmentResponse getAppointmentById(Long appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
        return mapToResponse(appointment);
    }

    public List<AppointmentResponse> getAppointmentsByPatientId(Long patientId) {
        List<Appointment> appointments = appointmentRepository.findByPatientId(patientId);
        return appointments.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public List<AppointmentResponse> getAppointmentsByDoctorId(Long doctorId) {
        List<Appointment> appointments = appointmentRepository.findByDoctorId(doctorId);
        return appointments.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public List<AppointmentResponse> getAllAppointments() {
        List<Appointment> appointments = appointmentRepository.findAll();
        return appointments.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
    private AppointmentResponse mapToResponse(Appointment appointment) {
        AppointmentResponse response = new AppointmentResponse();
        response.setAppointmentId(appointment.getAppointmentId());
        response.setPatientId(appointment.getPatientId());
        response.setDoctorId(appointment.getDoctorId());
        response.setAppointmentDateTime(appointment.getAppointmentDateTime());
        response.setStatus(appointment.getStatus());
        return response;
    }
}
