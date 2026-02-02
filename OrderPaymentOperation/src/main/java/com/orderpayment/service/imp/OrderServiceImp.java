package com.orderpayment.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderpayment.entity.Order;
import com.orderpayment.repository.OrderRepository;
import com.orderpayment.service.OrderService;

@Service
public class OrderServiceImp implements OrderService {

	@Autowired
	private OrderRepository repo;

	@Override
	public Order getOrders(Long id) {
		Order order = repo.findById(id).orElseThrow(() -> new RuntimeException("Data No found..."));
		return order;
	}

	@Override
	public List<Order> getAllOrders() {
		List<Order> list = repo.findAll();
		if (list.isEmpty()) {
			throw new RuntimeException("Data Not Found...");
		}

		return list;
	}

}
