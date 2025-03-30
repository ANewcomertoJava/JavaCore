-- Заполнение таблицы Товар (10 записей)
insert into product (description, price, quantity) VALUES
    ('Ноутбук', 999.99, 10),
    ('Смартфон', 499.99, 20),
    ('Наушники', 99.99, 30),
    ('Планшет', 299.99, 15),
    ('Монитор', 199.99, 8),
    ('Клавиатура', 49.99, 25),
    ('Мышь', 29.99, 40),
    ('Колонки', 79.99, 12),
    ('Флешка 32GB', 19.99, 50),
    ('Внешний HDD 1TB', 89.99, 7);

-- Заполнение таблицы Покупатель (10 записей)
insert into buyer name VALUES
    ('Иванов Иван'),
    ('Петров Петр'),
    ('Сидорова Мария'),
    ('Кузнецов Алексей'),
    ('Смирнова Анна'),
    ('Васильев Дмитрий'),
    ('Попова Елена'),
    ('Соколов Артем'),
    ('Лебедева Ольга'),
    ('Козлов Игорь');

-- Заполнение таблицы Заказ (10 записей)
INSERT INTO  orders (product_id, buyer_id, order_date, quantity) VALUES
    (1, 1, '2023-01-15', 1),
    (2, 2, '2023-01-16', 2),
    (3, 3, '2023-01-17', 1),
    (4, 4, '2023-01-18', 1),
    (5, 5, '2023-01-19', 1),
    (6, 6, '2023-01-20', 2),
    (7, 7, '2023-01-21', 3),
    (8, 8, '2023-01-22', 1),
    (9, 9, '2023-01-23', 5),
    (10, 10, '2023-01-24', 1);