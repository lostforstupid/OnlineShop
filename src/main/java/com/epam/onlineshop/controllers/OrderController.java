package com.epam.onlineshop.controllers;

import com.epam.onlineshop.entities.Order;
import com.epam.onlineshop.services.OrderService;
import com.epam.onlineshop.services.ProductInOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    private final ProductInOrderService productInOrderService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/orders")
    public ModelAndView getAllProducts(ModelAndView model) {
        model.setViewName("main_admin_orders");
        model.addObject(orderService.getAllOrders());
        return model;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/orders/{id}")
    public ModelAndView showOrder(ModelAndView model, @PathVariable("id") Long orderId) {
        model.setViewName("show_order");
        Order order = orderService.findById(orderId);
        model.addObject("order", order);
        model.addObject("productsInOrder", productInOrderService.getProductsFromThisOrder(order.getId()));
        return model;
    }
}
