package com.epam.onlineshop.controllers;

import com.epam.onlineshop.entities.Product;
import com.epam.onlineshop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class HelloController {
    private final ProductService productService;
    private final static Logger logger = Logger.getLogger(HelloController.class);

    @GetMapping({"/", "/welcome"})
    public ModelAndView main(Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(productService.getAllProducts());
        modelAndView.addObject("product", new Product());
        modelAndView.setViewName("main");
        logger.info("User " + principal.getName() + " entered in system.");
        return modelAndView;
    }
}

