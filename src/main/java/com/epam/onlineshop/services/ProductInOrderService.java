package com.epam.onlineshop.services;

import com.epam.onlineshop.entities.ProductInOrder;

import java.util.List;

public interface ProductInOrderService {

    List<ProductInOrder> getProductsFromThisOrder(Long id);
}
