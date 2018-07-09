package com.epam.onlineshop.controllers;

import com.epam.onlineshop.entities.Product;
import com.epam.onlineshop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    final ProductService productService;

    @GetMapping("/catalog")
    public ModelAndView showProducts() {
        ModelAndView catalog = new ModelAndView();
        catalog.addObject("productList", getDemoProducts()); //productService.getAllProducts());
        catalog.setViewName("products");
        return catalog;
    }

    private List<Product> getDemoProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(0L, "Black hat", 100));
        productList.add(new Product(1L, "Red notebook", 45));
        return productList;
    }
}
