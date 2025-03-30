package jpademo.repository;

import jpademo.model.Orders;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface OrdersRepository {
    List<Orders> findAll();
    Optional<Orders> findById(Long id);
    List<Orders> findByOrderDate(Date orderDate); // Этот метод нужно реализовать
    void deleteAll();
    Orders save(Orders order);
}