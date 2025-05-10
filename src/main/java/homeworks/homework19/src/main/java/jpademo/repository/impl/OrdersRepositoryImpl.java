package jpademo.repository.impl;

import jpademo.model.Orders;
import jpademo.repository.CustomOrdersRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

public class OrdersRepositoryImpl implements CustomOrdersRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Orders> findByOrderDate(Date orderDate) {
        return entityManager.createQuery(
                        "SELECT o FROM Orders o WHERE DATE(o.orderDate) = DATE(:orderDate)", Orders.class)
                .setParameter("orderDate", orderDate)
                .getResultList();
    }
}