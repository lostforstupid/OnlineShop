package com.epam.onlineshop;

import com.epam.onlineshop.entities.Role;
import com.epam.onlineshop.entities.User;
import com.epam.onlineshop.repository.UserRepository;
import com.epam.onlineshop.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test1() {
        User expectation = User.builder().id(4L)
                .username("alex")
                .address("aaa")
                .firstName("qwertyu")
                .password("123")
                .isBlocked(false)
                .role(Role.USER)
                .build();

        userService.addUser(expectation);
        User actual = userRepository.findByUsername("alex");

        assertEquals(expectation.getUsername(), actual.getUsername());
        assertEquals(expectation.getAddress(), actual.getAddress());
        assertEquals(expectation.getFirstName(), actual.getFirstName());
        assertEquals(expectation.getRole(), actual.getRole());
        assertEquals(expectation.getId(), actual.getId());
        assertEquals(expectation.getIsBlocked(), actual.getIsBlocked());
    }
}