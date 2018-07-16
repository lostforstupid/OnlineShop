package com.epam.onlineshop.controllers;

import com.epam.onlineshop.entities.Product;
import com.epam.onlineshop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class HelloController {
    private final ProductService productService;

    //TODO Load right page depending on role

    @GetMapping({"/","/welcome"})
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(productService.getAllProducts());
        modelAndView.addObject("product", new Product());
        modelAndView.setViewName("main");
        return modelAndView;
    }

/*    @PostMapping("/welcome")
    public ModelAndView welcome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(productService.getAllProducts());
        modelAndView.addObject("product", new Product());
        modelAndView.setViewName("main");
        return modelAndView;
    }*/
}

