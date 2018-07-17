package com.epam.onlineshop.repository;

import com.epam.onlineshop.entities.ProductInOrder;
import com.epam.onlineshop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductInOrderRepository extends JpaRepository<ProductInOrder, Long> {

 @Query("select orderInCart " +
         "from ProductInOrder as orderInCart " +
         "where orderInCart.order.user = :user " +
         "and orderInCart.order.status = 'NEW'")
    List<ProductInOrder> findAllNewOrderByUser(@Param("user") User user);
}
