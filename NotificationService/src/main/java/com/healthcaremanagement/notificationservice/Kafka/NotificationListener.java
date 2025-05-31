package com.healthcaremanagement.notificationservice.Kafka;

import com.healthcaremanagement.notificationservice.DTO.AppointmentEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {

    @KafkaListener(topics = "appointment-events", groupId = "notification-group", containerFactory = "kafkaListenerContainerFactory")
    public void listen(AppointmentEvent event) {
        System.out.println("📧 Sending notification to: " + event.getPatientEmail());

    }
}