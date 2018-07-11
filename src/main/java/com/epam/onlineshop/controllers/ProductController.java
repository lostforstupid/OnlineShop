package com.epam.onlineshop.controllers;

import com.epam.onlineshop.entities.Product;
import com.epam.onlineshop.entities.Role;
import com.epam.onlineshop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/catalog")
    public ModelAndView showProducts() {
        ModelAndView catalog = new ModelAndView();
        catalog.addObject(productService.getAllProducts());
        catalog.addObject("product", new Product());
        catalog.setViewName(getViewName(Role.ADMIN)); //access to admin page is open for all users for now
                                                        // (will be changed after the addition of sessions)
        return catalog;
    }

    @Transactional
    @PostMapping("/catalog")
    public ModelAndView addProduct(@ModelAttribute("product") Product product) {
        ModelAndView catalog = new ModelAndView();
        productService.addNewProduct(product);
        catalog.addObject(productService.getAllProducts());
        catalog.setViewName(getViewName(Role.ADMIN));
        return catalog;
    }

    private String getViewName(Role role) {
        switch (role) {
            case ADMIN:
                return "main_admin";
            default:
                return "main";
        }
    }
}
