package com.epam.onlineshop.controllers;

import com.epam.onlineshop.entities.Product;
import com.epam.onlineshop.entities.Role;
import com.epam.onlineshop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/catalog")
    public ModelAndView addProduct(@ModelAttribute("product") Product product) {
        ModelAndView catalog = new ModelAndView();
        productService.addNewProduct(product);
        catalog.addObject(productService.getAllProducts());
        catalog.setViewName(getViewName(Role.ADMIN));
        return catalog;
    }

    @GetMapping("/admin/products")
    public ModelAndView getAllUsers(ModelAndView model) {
        model.setViewName("main_admin_products");
        model.addObject(productService.getAllProducts());
        return model;
    }

    @GetMapping("/admin/products/{id}/edit")
    public ModelAndView getAllUsers(@PathVariable Long id,  ModelAndView model) {
        model.setViewName("edit_product");
        model.addObject(productService.getProductById(id));
        return model;
    }

    @PostMapping("/admin/products/{id}/save")
    public ModelAndView saveProduct(@PathVariable Long id, @ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return new ModelAndView("redirect:/admin/products");
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
