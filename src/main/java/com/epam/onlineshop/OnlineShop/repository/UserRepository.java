package com.epam.onlineshop.OnlineShop.repository;

import com.epam.onlineshop.OnlineShop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(@Param("username") String userName);
}