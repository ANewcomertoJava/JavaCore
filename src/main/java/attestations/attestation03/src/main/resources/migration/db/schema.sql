CREATE TABLE IF NOT EXISTS apartment (
             id SERIAL PRIMARY KEY,
             address VARCHAR(255) NOT NULL,
             apartment_number INT NOT NULL,
             area DECIMAL(10, 2) NOT NULL,
             deleted BOOLEAN DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS utility_measurement (
             id SERIAL PRIMARY KEY,
             apartment_id INT NOT NULL,
             measurement_date DATE NOT NULL,
             cold_water DECIMAL(10, 2) NOT NULL,
             hot_water DECIMAL(10, 2) NOT NULL,
             electricity DECIMAL(10, 2) NOT NULL,
             deleted BOOLEAN DEFAULT FALSE,
             FOREIGN KEY (apartment_id) REFERENCES apartment(id)
);