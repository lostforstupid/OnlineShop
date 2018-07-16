package com.epam.onlineshop.repository;

import com.epam.onlineshop.entities.ProductInOrder;
import com.epam.onlineshop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductInOrderRepository extends JpaRepository<ProductInOrder, Long> {

    @Query("select a from ProductInOrder as a where a.order.user = :user and a.order.status = 'NEW'")
    List<ProductInOrder> findAllNewOrderByUser(@Param("user") User user);

    @Query("select a from ProductInOrder as a where a.order.user = :user and a.order.status = 'PREPAID' or a.order.status = 'DELIVERED'")
    List<ProductInOrder> findAllOrderedByUser(@Param("user") User user);
}
