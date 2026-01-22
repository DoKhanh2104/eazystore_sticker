package com.devithedev.eazystore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devithedev.eazystore.entity.Customer;
import com.devithedev.eazystore.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCustomerOrderByCreatedAtDesc(Customer customer);

    List<Order> findByOrderStatus(String orderStatus);
}
