package com.epam.onlineshop.services.impl;

import com.epam.onlineshop.entities.ProductInOrder;
import com.epam.onlineshop.entities.User;
import com.epam.onlineshop.repository.ProductInOrderRepository;
import com.epam.onlineshop.services.ProductInOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductInOrderServiceImpl implements ProductInOrderService {

    private  final ProductInOrderRepository productInOrderRepository;
    @Override
    public List<ProductInOrder> findAllNewOrderByUser(User user) {
        return productInOrderRepository.findAllNewOrderByUser(user);
    }

    @Override
    public void deleteById(Long id) {
        productInOrderRepository.deleteById(id);
    }

    @Override
    public void incrementCount(Long id) {
        Optional<ProductInOrder> optionalProduct = productInOrderRepository.findById(id);
        if (optionalProduct.isPresent()) {
            ProductInOrder product = optionalProduct.get();
            product.setQuantity(product.getQuantity() + 1);
            productInOrderRepository.save(product);
        } else{
            System.out.println("Product didn't find!"); // Waiting for log4j
        }

    }

    @Override
    public void decrementCount(Long id) {
        Optional<ProductInOrder> optionalProduct = productInOrderRepository.findById(id);
        if (optionalProduct.isPresent()) {
            ProductInOrder product = optionalProduct.get();
            product.setQuantity(product.getQuantity() - 1);
            productInOrderRepository.save(product);
        } else{
            System.out.println("Product didn't find!"); // Waiting for log4j
        }
    }

    @Override
    public Integer getQuantityById(Long id) {
        Optional<ProductInOrder> optionalProduct = productInOrderRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get().getQuantity();
        } else{
            return 0;
        }
    }
}
