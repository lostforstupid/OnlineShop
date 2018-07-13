package com.epam.onlineshop.controllers;

import com.epam.onlineshop.entities.Product;
import com.epam.onlineshop.entities.Role;
import com.epam.onlineshop.services.ProductService;
import com.epam.onlineshop.utils.ImageWriter;
import com.epam.onlineshop.utils.RandomString;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

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
    public ModelAndView addProduct(@ModelAttribute("product") Product product, @RequestParam("file") MultipartFile file) {
        ModelAndView catalog = new ModelAndView();
        RandomString randomString = new RandomString(32);
        String name = randomString.nextString();
        catalog = ImageWriter.writeImage(catalog, file, name);
        product.setImageLink(name + ".jpg");
        productService.addNewProduct(product);
        catalog.addObject(productService.getAllProducts());
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
