package com.epam.onlineshop.controllers;

import com.epam.onlineshop.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/orders")
    public ModelAndView getAllProducts(ModelAndView model) {
        model.setViewName("main_admin_orders");
        model.addObject(orderService.getAllOrders());
        return model;
    }
}
