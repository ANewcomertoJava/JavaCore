CREATE SCHEMA IF NOT EXISTS shop;

CREATE TABLE shop.users (
                            id BIGSERIAL PRIMARY KEY,
                            fio VARCHAR(255) NOT NULL
);

CREATE TABLE shop.orders (
                             id BIGSERIAL PRIMARY KEY,
                             user_id BIGINT NOT NULL,
                             order_date TIMESTAMP NOT NULL,
                             total_number_of BIGINT NOT NULL,
                             buyer_discount BIGINT,
                             CONSTRAINT fk_user FOREIGN KEY(user_id) REFERENCES shop.users(id)
);

INSERT INTO shop.users (fio) VALUES
                             ('Иванов Иван Иванович'),
                             ('Петров Петр Петрович'),
                             ('Сидоров Сергей Сергеевич');

INSERT INTO shop.orders (user_id, order_date, total_number_of, buyer_discount) VALUES
                            (1, '2023-01-15 10:30:00', 5, 10),
                            (1, '2023-01-16 11:45:00', 3, 10),
                            (2, '2023-01-15 14:20:00', 7, 5),
                            (3, '2023-01-17 09:15:00', 2, null);