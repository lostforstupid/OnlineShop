package com.epam.onlineshop.services;

import com.epam.onlineshop.entities.Product;

import java.util.List;

public interface ProductService {

    Product addNewProduct(Product product);
    List<Product> getAllProducts();
    Product findByName(String name);
}
