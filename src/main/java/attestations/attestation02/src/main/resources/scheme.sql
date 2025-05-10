-- Создание таблицы Товар
create table if not exists product (
    id bigserial primary key,
    description varchar,
    price double precision,
    quantity numeric
);


comment on table product is 'Таблица для хранения информации о товарах';

-- Создание таблицы Покупатель
create table if not exists buyer (
     id bigserial primary key not null,
     fio varchar
);

comment on table buyer is 'Таблица для хранения информации о покупателях';

-- Создание таблицы Заказ
create table if not exists orders (
    id bigserial primary key not null,
    product_id numeric references product(id),
    buyer_id numeric references buyer(id),
    order_date date,
    quantity numeric
);

comment on table orders is 'Таблица для хранения информации о заказах';
