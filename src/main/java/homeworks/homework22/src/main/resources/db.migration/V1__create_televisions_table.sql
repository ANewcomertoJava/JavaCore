CREATE TABLE IF NOT EXISTS televisions (
    id SERIAL PRIMARY KEY,
    brand VARCHAR(100) NOT NULL,
    model VARCHAR(100) NOT NULL,
    price DECIMAL(10, 2),
    screen_size INTEGER
    );