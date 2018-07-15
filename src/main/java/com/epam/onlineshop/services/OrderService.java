package com.epam.onlineshop.services;

import com.epam.onlineshop.entities.Order;
import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();
    boolean addNewOrder(Order order);
}
