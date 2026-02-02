package com.orderpayment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderpayment.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
