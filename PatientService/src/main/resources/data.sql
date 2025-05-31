-- Inserting sample data into the patients table
CREATE TABLE patients (
                          patient_id BIGINT AUTO_INCREMENT PRIMARY KEY,  -- auto-generated primary key
                          name VARCHAR(255) NOT NULL,                     -- name of the patient
                          email VARCHAR(255) NOT NULL UNIQUE,             -- email with unique constraint
                          phone_number VARCHAR(20) NOT NULL UNIQUE,       -- phone number with unique constraint
                          address VARCHAR(255) NOT NULL                   -- address of the patient
);


INSERT INTO patients (name, email, phone_number, address)
VALUES
    ('John Doe', 'john.doe@example.com', '555-1234', '123 Main St, Springfield, IL'),
    ('Jane Smith', 'jane.smith@example.com', '555-5678', '456 Elm St, Springfield, IL'),
    ('Tom Brown', 'tom.brown@example.com', '555-8765', '789 Pine St, Springfield, IL'),
    ('Lisa White', 'lisa.white@example.com', '555-4321', '321 Oak St, Springfield, IL');
