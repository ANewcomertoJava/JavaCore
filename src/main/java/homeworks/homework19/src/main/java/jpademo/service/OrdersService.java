package jpademo.service;

import jpademo.model.Orders;
import jpademo.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersService {
    private final OrdersRepository ordersRepository;

    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    public Orders getById(Long id) {
        return ordersRepository.findById(id).orElse(null);
    }

    public List<Orders> getByDate(Date date) {
        return ordersRepository.findByOrderDate(date);
    }

    public void deleteAll() {
        ordersRepository.deleteAll();
    }

    public Orders saveOrder(Orders order) {
        return ordersRepository.save(order);
    }


}