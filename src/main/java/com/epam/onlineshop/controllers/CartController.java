package com.epam.onlineshop.controllers;

import com.epam.onlineshop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
public class CartController {

    private final ProductService productService;

    @GetMapping(value = "/cart")
    public ModelAndView cart(ModelAndView model) {
        model.addObject("products", productService.getAllProducts());
        model.addObject("productService", productService);
        model.setViewName("cart");
        return model;
    }

    @RequestMapping(value = "/cart/{id}/delete", method = RequestMethod.POST)
    public ModelAndView deleteProduct(@PathVariable("id") Long id, ModelAndView model) {
        productService.deleteById(id);
        model.setViewName("redirect:/cart");
        return model;
    }
}
