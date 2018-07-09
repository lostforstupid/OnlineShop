package com.epam.onlineshop.controllers;

import com.epam.onlineshop.entities.Product;
import com.epam.onlineshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/catalog")
    public ModelAndView showProducts() {
        ModelAndView catalog = new ModelAndView();
        catalog.addObject("productList", productService.getAllProducts());
        catalog.setViewName("products");
        return catalog;
    }
}
