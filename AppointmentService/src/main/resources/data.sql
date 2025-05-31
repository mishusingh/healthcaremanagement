CREATE TABLE appointment (
                             appointment_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             patient_id BIGINT NOT NULL,
                             doctor_id BIGINT NOT NULL,
                             appointment_date_time TIMESTAMP NOT NULL,
                             status VARCHAR(255) NOT NULL
);

INSERT INTO appointment (patient_id, doctor_id, appointment_date_time, status)
VALUES
    (1, 2, '2025-06-15 10:00:00', 'Scheduled'),
    (2, 3, '2025-06-16 11:30:00', 'Scheduled');
