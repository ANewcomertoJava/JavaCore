package jpademo.repository;

import jpademo.model.Orders;
import java.util.Date;
import java.util.List;

public interface CustomOrdersRepository {
    List<Orders> findByOrderDate(Date orderDate);
}