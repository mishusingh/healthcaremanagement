CREATE TABLE doctor (
                        doctor_id BIGINT AUTO_INCREMENT PRIMARY KEY,  -- auto-generated primary key
                        name VARCHAR(255) NOT NULL,                    -- doctor's name
                        specialization VARCHAR(255),                   -- doctor's specialization
                        contact_number VARCHAR(20),                    -- doctor's contact number
                        email VARCHAR(255) UNIQUE                      -- doctor's email with unique constraint
);
-- Inserting sample data into the doctor table
INSERT INTO doctor (name, specialization, contact_number, email)
VALUES
    ('Dr. Sarah Lee', 'Cardiology', '555-1234', 'sarah.lee@example.com'),
    ('Dr. Mark Johnson', 'Neurology', '555-5678', 'mark.johnson@example.com'),
    ('Dr. Emily Davis', 'Pediatrics', '555-8765', 'emily.davis@example.com'),
    ('Dr. James Smith', 'Orthopedics', '555-4321', 'james.smith@example.com');
