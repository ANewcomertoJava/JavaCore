CREATE TABLE IF NOT EXISTS users (
   id BIGSERIAL PRIMARY KEY,
   fio VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS orders (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    order_date TIMESTAMP NOT NULL,
    total_number_of BIGINT NOT NULL,
    buyer_discount BIGINT,
    CONSTRAINT fk_user FOREIGN KEY(user_id) REFERENCES users(id)
);