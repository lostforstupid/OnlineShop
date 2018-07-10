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

    private final ProductRepository productRepository;

    @Override
    public boolean addNewProduct(Product product) {
        return (findByName(product.getName())) ? true : productRepository.saveAndFlush(product) != null;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public boolean findByName(String name) {
        return productRepository.findByName(name) != null;
    }
}
