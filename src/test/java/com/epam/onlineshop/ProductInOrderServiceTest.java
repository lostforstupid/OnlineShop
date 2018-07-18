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

    private static String usernameAlex = "usernameAlex";
    private static String passwordAlex = "123";
    private static String firstnameAlex = "Alex";
    private static String secondnameAlex = "Petrov";
    private static String phonenumberAlex = "+ 7 999 021 06 14";
    private static String addressAlex = "aaa";

    private static String productImgLink = "";
    private static String productName = "Qwerty";
    private static Integer productPrice = 10;

    private static Integer productInOrderQuantity = 1;

    @Test
    public void shouldReturnAddedProductInOrderInCart() {
        User user = userRepository.save(createUser());
        Product productFromCatalog = productRepository.save(createProduct());
        Order orderInCart = orderRepository.save(createOrder(user));
        ProductInOrder expectation = createProductInOrder(productFromCatalog, orderInCart);

        ProductInOrder result = productInOrderService.addOrderInCart(productFromCatalog.getId(), user);

        Optional<ProductInOrder> actual = productInOrderRepository.findById(result.getId());

        assertNotNull(actual);
        assertEquals(expectation, actual.get());
    }

    private static ProductInOrder createProductInOrder(Product productFromCatalog, Order orderInCart) {
        return ProductInOrder.builder()
                .id(5L)
                .order(orderInCart)
                .product(productFromCatalog)
                .quantity(productInOrderQuantity)
                .build();
    }

    private static Order createOrder(User user) {
        return Order.builder()
                .status(NEW)
                .user(user)
                .build();
    }

    private static Product createProduct() {
        return Product.builder()
                .imageLink(productImgLink)
                .name(productName)
                .price(productPrice)
                .build();
    }

    private static User createUser() {
        return User.builder()
                .username(usernameAlex)
                .password(passwordAlex)
                .role(Role.USER)
                .firstName(firstnameAlex)
                .secondName(secondnameAlex)
                .phoneNumber(phonenumberAlex)
                .address(addressAlex)
                .isBlocked(false)
                .build();
    }
}