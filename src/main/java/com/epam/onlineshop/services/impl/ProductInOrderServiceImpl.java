package com.epam.onlineshop.services.impl;

import com.epam.onlineshop.entities.ProductInOrder;
import com.epam.onlineshop.repository.ProductInOrderRepository;
import com.epam.onlineshop.services.ProductInOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductInOrderServiceImpl implements ProductInOrderService {

    private final ProductInOrderRepository productInOrderRepository;

    @Override
    public List<ProductInOrder> getProductsFromThisOrder(Long id) {
        return productInOrderRepository.findByOrderId(id);
    }
}
