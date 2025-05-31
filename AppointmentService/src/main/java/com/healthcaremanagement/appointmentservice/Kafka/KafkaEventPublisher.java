package com.healthcaremanagement.appointmentservice.Kafka;

import com.healthcaremanagement.appointmentservice.DTO.AppointmentEventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaEventPublisher {

    private KafkaTemplate<String, AppointmentEventListener> kafkaTemplate;

    public void publishEvent(AppointmentEventListener event) {
        kafkaTemplate.send("appointment-events", event);
    }
}
