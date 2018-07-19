package com.epam.onlineshop.services.impl;

import com.epam.onlineshop.entities.Category;
import com.epam.onlineshop.entities.Product;
import com.epam.onlineshop.repository.ProductRepository;
import com.epam.onlineshop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getAllProducts(Pageable page) {
        Slice<Product> slice = productRepository.findAll(page);
        return slice.getContent();
    }

    @Override
    public long getCount() {
        return productRepository.count();
    }

    @Override
    public List<Product> findAllProductsByCategory(Pageable page, Category category) {
        Page<Product> allByCategory = productRepository.findAllByCategory(category, page);
        return allByCategory.getContent();
    }

    @Override
    public boolean addNewProduct(Product product) {
        if (!isProductExist(product.getName())) {
            productRepository.save(product);
        }

        return isProductExist(product.getName());
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    public boolean isProductExist(String name) {
        return productRepository.existsByName(name);
    }

    @Override
    public boolean saveProduct(Product product) {
        productRepository.save(product);
        return isProductExist(product.getName());
    }

    @Override
    public boolean deleteProductById(Long id) {
        Product product = getProductById(id);
        productRepository.delete(product);
        return (!isProductExist(product.getName()));
    }

    @Override
    public Product getById(Long id) {
        Optional<Product> result = productRepository.findById(id);
        return (result.isPresent()) ? result.get() : null;
    }
}
