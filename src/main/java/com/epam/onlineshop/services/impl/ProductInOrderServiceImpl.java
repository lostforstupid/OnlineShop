package com.epam.onlineshop.services.impl;

import com.epam.onlineshop.entities.ProductInOrder;
import com.epam.onlineshop.entities.User;
import com.epam.onlineshop.repository.ProductInOrderRepository;
import com.epam.onlineshop.services.ProductInOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.epam.onlineshop.entities.Status.PREPAID;

@Service
@RequiredArgsConstructor
public class ProductInOrderServiceImpl implements ProductInOrderService {

    private  final ProductInOrderRepository productInOrderRepository;
    @Override
    public List<ProductInOrder> findAllNewByUser(User user) {
        return productInOrderRepository.findAllNewOrderByUser(user);
    }

    @Override
    public List<ProductInOrder> findAllOrderedByUser(User user) {
        return productInOrderRepository.findAllOrderedByUser(user);
    }

    @Override
    public void deleteById(Long id) {
        productInOrderRepository.deleteById(id);
    }

    @Override
    public void incrementCount(Long id) {
        Optional<ProductInOrder> optionalProduct = productInOrderRepository.findById(id);
        if (optionalProduct.isPresent()) {
            ProductInOrder product = optionalProduct.get();
            product.setQuantity(product.getQuantity() + 1);
            productInOrderRepository.save(product);
        } else{
            System.out.println("Product didn't find!");
        }

    }

    @Override
    public void decrementCount(Long id) {
        Optional<ProductInOrder> optionalProduct = productInOrderRepository.findById(id);
        if (optionalProduct.isPresent()) {
            ProductInOrder product = optionalProduct.get();
            product.setQuantity(product.getQuantity() - 1);
            productInOrderRepository.save(product);
        } else{
            System.out.println("Product didn't find!");
        }
    }

    @Override
    public Integer getCountById(Long id) {
        Optional<ProductInOrder> optionalProduct = productInOrderRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get().getQuantity();
        } else{
            System.out.println("Product didn't find!");
            return -1; // or null?
        }
    }

    @Override
    public void makeOrder(User user) {
        List<ProductInOrder> orders = productInOrderRepository.findAllOrderedByUser(user);
        for(ProductInOrder product: orders){
            product.getOrder().setStatus(PREPAID);
        }
    }
}
