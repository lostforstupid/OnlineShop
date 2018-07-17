package com.epam.onlineshop.services.impl;

import com.epam.onlineshop.entities.Order;
import com.epam.onlineshop.entities.Product;
import com.epam.onlineshop.entities.ProductInOrder;
import com.epam.onlineshop.entities.Status;
import com.epam.onlineshop.repository.OrderRepository;
import com.epam.onlineshop.repository.ProductInOrderRepository;
import com.epam.onlineshop.services.ProductInOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductInOrderServiceImpl implements ProductInOrderService {

    private final ProductInOrderRepository productInOrderRepository;

    @Override
    public List<ProductInOrder> getProductsFromThisOrder(Long id) {
        return productInOrderRepository.findByOrderId(id);
    }
}
