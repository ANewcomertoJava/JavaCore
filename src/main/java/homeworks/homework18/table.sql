-- Создание таблицы Покупатель
CREATE TABLE customer (
                          id SERIAL PRIMARY KEY,
                          first_name VARCHAR(100) NOT NULL,
                          last_name VARCHAR(100) NOT NULL
);

-- Создание таблицы Заказ
CREATE TABLE order (
                       id SERIAL PRIMARY KEY,
                       customer_id INTEGER NOT NULL,
                       order_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                       total_orders INTEGER NOT NULL DEFAULT 1,
                       discount DECIMAL(5,2) NOT NULL DEFAULT 0.00,
                       CONSTRAINT fk_customer
                           FOREIGN KEY (customer_id)
                               REFERENCES customer(id)
                               ON DELETE CASCADE
);

-- Создание индекса для ускорения поиска заказов по покупателю
CREATE INDEX idx_order_customer_id ON order(customer_id);