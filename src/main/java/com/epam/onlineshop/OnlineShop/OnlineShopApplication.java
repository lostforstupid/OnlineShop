package com.epam.onlineshop.OnlineShop;

import com.epam.onlineshop.OnlineShop.entities.User;
import com.epam.onlineshop.OnlineShop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Arrays;
import java.util.List;

import static org.springframework.boot.SpringApplication.run;


@SpringBootApplication
public class OnlineShopApplication {

	@Autowired
	private static UserRepository userRepository;
	public static void main(String[] args) {
//		List<User> initialUsers = Arrays.asList(
//				new User("user", "user", false),
//				new User("admin", "admin", false)
//		);
//		userRepository.save(initialUsers.get(0));
//        userRepository.save(initialUsers.get(1));
		run(OnlineShopApplication.class, args);
	}

}
