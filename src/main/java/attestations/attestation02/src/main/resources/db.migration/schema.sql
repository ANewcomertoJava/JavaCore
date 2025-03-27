-- Удаление таблиц, если они существуют (для чистого развертывания)
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS buyer;


CREATE TABLE IF NOT EXISTS product (
    id SERIAL PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    quantity INTEGER NOT NULL
    );


CREATE TABLE IF NOT EXISTS buyer (
    id SERIAL PRIMARY KEY,
    fio VARCHAR(255) NOT NULL
    );

CREATE TABLE IF NOT EXISTS orders (
    id SERIAL PRIMARY KEY,
    product_id INTEGER NOT NULL REFERENCES product(id),
    buyer_id INTEGER NOT NULL REFERENCES buyer(id),
    order_date DATE NOT NULL,
    quantity INTEGER NOT NULL
    );