package com.epam.onlineshop.controllers;

import com.epam.onlineshop.entities.ProductInOrder;
import com.epam.onlineshop.repository.ProductInOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductInOrderController {

    private final ProductInOrderRepository productInOrderRepository;

    @GetMapping("/temp") //temporary
    public void temporary() {
        List<ProductInOrder> list = productInOrderRepository.findByOrderId(1L);
        for (ProductInOrder productInOrder : list) {
            System.out.println(productInOrder.getProduct().getName());
        }

        List<ProductInOrder> list2 = productInOrderRepository.findByOrderId(2L);
        for (ProductInOrder productInOrder : list2) {
            System.out.println(productInOrder.getProduct().getName());
        }
    }
}
