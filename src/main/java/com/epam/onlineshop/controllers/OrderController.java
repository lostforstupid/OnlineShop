package com.epam.onlineshop.controllers;

import com.epam.onlineshop.entities.Order;
import com.epam.onlineshop.entities.ProductInOrder;
import com.epam.onlineshop.services.OrderService;
import com.epam.onlineshop.services.ProductInOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    private final ProductInOrderService productInOrderService;

    @GetMapping("/orders")
    public ModelAndView getAllProducts(ModelAndView model) {
        model.setViewName("main_admin_orders");
        model.addObject(orderService.getAllOrders());

        for (Order order : orderService.getAllOrders()) {
            System.out.println("id: " + order.getId());
            for (ProductInOrder productInOrder : order.getProductsInOrder()) {
                System.out.println(productInOrder.getProduct().getName());
            }
        }

        return model;
    }

    @GetMapping("/orders/{id}")
    public ModelAndView showOrder(ModelAndView model, @PathVariable("id") Long orderId) {
        model.setViewName("show_order");
        Order order = orderService.findById(orderId);
        model.addObject("order", order);
        model.addObject("productsInOrder", productInOrderService.getProductsFromThisOrder(orderId));
        return model;
    }

    @GetMapping("/orders/{id}/edit")
    public ModelAndView editOrder(ModelAndView model, @PathVariable("id") Long orderId) {
        model.setViewName("edit_order");
        Order order = orderService.findById(orderId);
        model.addObject("order", order);
        model.addObject("productsInOrder", productInOrderService.getProductsFromThisOrder(orderId));
        System.out.println(productInOrderService.getProductsFromThisOrder(orderId));
        return model;
    }

    @PostMapping("/orders/save")
    public ModelAndView saveOrder(ModelAndView model, @ModelAttribute("order") Order order) {
        orderService.saveOrder(order);
        return model;
    }
}
