package com.epam.onlineshop.repository;

import com.epam.onlineshop.entities.ProductInOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductInOrderRepository extends JpaRepository<ProductInOrder, Long> {

    //@Query("SELECT productInOrder FROM product_in_order WHERE product_in_order.order_id = order_table.id")
    List<ProductInOrder> findByOrderId (Long order_id);
}
