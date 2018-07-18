package com.epam.onlineshop;

import com.epam.onlineshop.entities.User;
import com.epam.onlineshop.repository.UserRepository;
import com.epam.onlineshop.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


    @Test
    public void test1() {
        User alex = User.builder()
                .username("alex")
                .address("aaa")
                .firstName("qwertyu")
                .password("123")
                .isBlocked(false)
                .build();

        userService.addUser(alex);
        User found = userRepository.findByUsername("alex");

        boolean nameIsEqual = found.getFirstName()
                .equals(alex.getFirstName());
        boolean addressIsEqual = found.getAddress().equals(alex.getAddress());
        assertThat(nameIsEqual&&addressIsEqual);
    }

}