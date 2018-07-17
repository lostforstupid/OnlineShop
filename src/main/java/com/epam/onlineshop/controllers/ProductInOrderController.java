package com.epam.onlineshop.controllers;

import com.epam.onlineshop.entities.ProductInOrder;
import com.epam.onlineshop.repository.ProductInOrderRepository;
import com.epam.onlineshop.services.ProductInOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductInOrderController {

    private final ProductInOrderService productInOrderService;

    @PostMapping("/products_in_order/{orderId}/save")
    public boolean saveProductsInOrder(@PathVariable Long orderId, @ModelAttribute("productsInOrder") List<ProductInOrder> productsInOrder) {
        return productInOrderService.saveProductsInOrder(productsInOrder) != null;
    }
}
