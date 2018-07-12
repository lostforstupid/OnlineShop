package com.epam.onlineshop.services.impl;

import com.epam.onlineshop.entities.Product;
import com.epam.onlineshop.repository.ProductRepository;
import com.epam.onlineshop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    // When we created entity for ordering it can be deleted
    @Override
    public void incrementCount(Long id) {
        Product product = productRepository.findById(id).get();
        product.setCount(product.getCount() + 1);
        productRepository.save(product);
    }

    // When we created entity for ordering it can be deleted
    @Override
    public void decrementCount(Long id) {
        Product product = productRepository.findById(id).get();
        product.setCount(product.getCount() - 1);
        productRepository.save(product);
    }

    // When we created entity for ordering it can be deleted
    @Override
    public Integer getCountById(Long id) {
        return productRepository.findById(id).get().getCount();
    }
}