package com.epam.onlineshop;

import com.epam.onlineshop.entities.*;
import com.epam.onlineshop.repository.OrderRepository;
import com.epam.onlineshop.repository.ProductInOrderRepository;
import com.epam.onlineshop.repository.ProductRepository;
import com.epam.onlineshop.repository.UserRepository;
import com.epam.onlineshop.services.ProductInOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.epam.onlineshop.entities.Status.NEW;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ProductInOrderServiceTest {

    @Autowired
    private ProductInOrderService productInOrderService;

    @Autowired
    private ProductInOrderRepository productInOrderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void test1() {
        User user = userRepository.save(User.builder()
                .username("alex")
                .address("aaa")
                .firstName("qwertyu")
                .password("123")
                .isBlocked(false)
                .role(Role.USER)
                .build());

        Product productFromCatalog = productRepository.save(Product.builder()
                .imageLink("")
                .name("qwerty")
                .price(10)
                .build());

        Order orderInCart = orderRepository.save(Order.builder()
                .status(NEW)
                .user(user)
                .build());

        ProductInOrder expectation = ProductInOrder.builder()
                .id(5L)
                .order(orderInCart)
                .product(productFromCatalog)
                .quantity(1)
                .build();

        ProductInOrder result = productInOrderService.addOrderInCart(productFromCatalog.getId(), user);

        Optional<ProductInOrder> actual = productInOrderRepository.findById(result.getId());

        assertNotNull(actual);
        assertEquals(expectation, actual.get());
    }
}