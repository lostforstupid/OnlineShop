package com.epam.onlineshop.services;

import com.epam.onlineshop.entities.ProductInOrder;
import com.epam.onlineshop.entities.User;

import java.util.List;

public interface ProductInOrderService {

    List<ProductInOrder> findAllByOrderId(User user);

    void deleteById(Long id);

    void incrementCount(Long id);

    void decrementCount(Long id);

    Integer getCountById(Long id);
}
