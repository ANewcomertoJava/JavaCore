-- 1. Выбрать все товары с ценой выше 100 рублей
SELECT * FROM product WHERE price > 100.00;

-- 2. Показать всех покупателей, чьи фамилии начинаются на "С"
SELECT * FROM buyer WHERE fio LIKE 'С%';

-- 3. Обновить количество товара "Флешка 32GB" на складе (уменьшить на 5)
UPDATE product SET quantity = quantity - 5 WHERE description = 'Флешка 32GB';

-- 4. Удалить заказ, сделанный 2023-01-24
DELETE FROM orders WHERE order_date = '2023-01-24';

-- 5. Вывести список всех заказов с информацией о покупателе и товаре.
SELECT o.id, b.fio AS buyer, p.description AS product, o.order_date, o.quantity, p.price, (o.quantity * p.price) AS total
FROM orders o
         JOIN buyer b ON o.buyer_id = b.id
         JOIN product p ON o.product_id = p.id;

-- 6. Найти самый популярный товар (по количеству заказанных единиц)
SELECT p.description, SUM(o.quantity) AS total_ordered
FROM orders o
         JOIN product p ON o.product_id = p.id
GROUP BY p.description
ORDER BY total_ordered DESC
LIMIT 1;

-- 7. Увеличить цену всех товаров на 10%
UPDATE product SET price = price * 1.10 WHERE id > 0;;

-- 8. Показать покупателей, которые сделали более 1 заказа
SELECT b.fio, COUNT(o.id) AS order_count
FROM buyer b
         JOIN orders o ON b.id = o.buyer_id
GROUP BY b.fio
HAVING COUNT(o.id) > 1;

-- 9. Вывести товары, которых на складе меньше 10 штук
SELECT description, quantity FROM product WHERE quantity < 10;

-- 10. Добавить нового покупателя
INSERT INTO buyer (fio) VALUES ('Новиков Александр');