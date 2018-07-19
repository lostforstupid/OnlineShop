package com.epam.onlineshop;

import com.epam.onlineshop.entities.*;
import com.epam.onlineshop.repository.OrderRepository;
import com.epam.onlineshop.repository.ProductInOrderRepository;
import com.epam.onlineshop.repository.ProductRepository;
import com.epam.onlineshop.repository.UserRepository;
import com.epam.onlineshop.services.OrderService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceTest {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductInOrderRepository productInOrderRepository;

    @Autowired
    OrderService orderService;

    private Order order;
    private User user;
    private ProductInOrder productInOrder;
    private Product product;

    private static Long USER_ID = 4L;
    private static Role ROLE = Role.USER;
    private static String USERNAME = "user";
    private static String PASSWORD = "pass";
    private static Boolean IS_BLOCKED = false;
    private static String ADDRESS = "address";

    private static Long PRODUCT_ID = 5L;
    private static String PRODUCT_NAME = "product";
    private static Integer PRICE = 200;
    private static String IMAGE_URL = "url.jpg";

    private static Long ORDER_ID = 3L;
    private static Status STATUS = Status.NEW;

    private static Long PRODUCT_IN_ORDER_ID = 5L;
    private static Integer QUANTITY = 12;

    public User getUser() {
        return User.builder()
                .id(USER_ID)
                .username(USERNAME)
                .password(PASSWORD)
                .role(ROLE)
                .address(ADDRESS)
                .isBlocked(IS_BLOCKED)
                .build();
    }

    public Product getProduct() {
        return Product.builder()
                .id(PRODUCT_ID)
                .name(PRODUCT_NAME)
                .price(PRICE)
                .imageLink(IMAGE_URL)
                .build();
    }

    public Order getOrder() {
        return Order.builder()
                .id(ORDER_ID)
                .status(STATUS)
                .build();
    }

    public ProductInOrder getProductInOrder() {
        return ProductInOrder.builder()
                .id(PRODUCT_IN_ORDER_ID)
                .quantity(QUANTITY)
                .build();
    }

    @Before
    public void setUp() {
        order = getOrder();
        user = getUser();
        product = getProduct();
        productInOrder = getProductInOrder();

        productInOrder.setOrder(order);
        productInOrder.setProduct(product);

        order.setUser(user);
    }

    @Test
    public void testSettingStatusById() {
        productRepository.save(product);
        userRepository.save(user);
        orderRepository.save(order);
        productInOrderRepository.save(productInOrder);

        Order orderReceived = getOrder();
        orderReceived.setUser(user);
        Status expected = Status.PREPAID;
        orderReceived.setStatus(expected);

        orderService.setStatusById(orderReceived, order.getId());
        Status actual = orderRepository.findById(ORDER_ID).get().getStatus();

        assertEquals(expected, actual);
    }
}
