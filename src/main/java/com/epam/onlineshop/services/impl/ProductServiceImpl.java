package com.epam.onlineshop.services.impl;

import com.epam.onlineshop.entities.Product;
import com.epam.onlineshop.repository.ProductRepository;
import com.epam.onlineshop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

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
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    // When we created entity for ordering it can be deleted
    @Override
    public void incrementCount(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setCount(product.getCount() + 1);
            productRepository.save(product);
        } else{
            System.out.println("Product didn't find!");
        }

    }

    // When we created entity for ordering it can be deleted
    @Override
    public void decrementCount(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setCount(product.getCount() - 1);
            productRepository.save(product);
        } else{
            System.out.println("Product didn't find!");
        }
    }

    // When we created entity for ordering it can be deleted
    @Override
    public Integer getCountById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get().getCount();
        } else{
            System.out.println("Product didn't find!");
            return -1; // or null?
        }
    }

    @Transactional
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

    boolean isProductExist(String name) {
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
}
