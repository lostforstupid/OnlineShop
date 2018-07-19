package com.epam.onlineshop.services;

import com.epam.onlineshop.entities.Category;
import com.epam.onlineshop.entities.Product;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    List<Product> getAllProducts(Pageable page);
    long getCount();
    List<Product> findAllProductsByCategory(Pageable page, Category category);
/*
    void deleteById(Long id);
    void incrementCount(Long id);
    void decrementCount(Long id);
    Integer getCountById(Long id);
    */

    boolean addNewProduct(Product product);
    boolean isProductExist(String name);
    Product getProductById(Long id);
    boolean saveProduct(Product product);
    boolean deleteProductById(Long id);
    Product getById(Long id);
}
