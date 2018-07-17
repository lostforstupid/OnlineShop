package com.epam.onlineshop.services;

import com.epam.onlineshop.entities.Order;
import com.epam.onlineshop.entities.ProductInOrder;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();
    Order addOrder(Order order);
    Order findById(Long id);
}
