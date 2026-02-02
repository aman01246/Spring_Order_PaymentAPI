package com.orderpayment.service;

import java.util.List;

import com.orderpayment.entity.Order;

public interface OrderService {

	Order getOrders(Long id);
	List<Order> getAllOrders();
	
}
