package com.epam.onlineshop.services;

import com.epam.onlineshop.entities.ProductInOrder;
import com.epam.onlineshop.entities.User;

import java.util.List;

public interface ProductInOrderService {

    List<ProductInOrder> findAllNewByUser(User user);

    List<ProductInOrder> findAllOrderedByUser(User user);

    void addOrderInCart(Long product_id, User user);

    void deleteById(Long id);

    void incrementCount(Long id);

    void decrementCount(Long id);

    Integer getCountById(Long id);

    void makeOrder(User user);
}
