package com.epam.onlineshop.controllers;

import com.epam.onlineshop.entities.Product;
import com.epam.onlineshop.entities.Role;
import com.epam.onlineshop.services.ProductService;
import com.epam.onlineshop.utils.ImageWriter;
import com.epam.onlineshop.validator.ProductValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductValidator productValidator;

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
    public ModelAndView addProduct(@ModelAttribute("product") Product product, BindingResult bindingResult, @RequestParam("file") MultipartFile file) {
        ModelAndView catalog = new ModelAndView();
        productValidator.validate(product, bindingResult);

        catalog.setViewName(getViewName(Role.ADMIN));
        if (!bindingResult.hasErrors()) {
            long currentTime = new Date().getTime();
            String name = String.valueOf(currentTime);

            if(file.isEmpty()){
                product.setImageLink("default.jpg");
            }else {
                catalog = ImageWriter.writeImage(catalog, file, name);
                product.setImageLink(name + ".jpg");
            }
            //product.setCount(100); //TEMPORARY
            productService.addNewProduct(product);
            catalog.addObject(productService.getAllProducts());
        }else{
            catalog.addObject(productService.getAllProducts());
        }
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
