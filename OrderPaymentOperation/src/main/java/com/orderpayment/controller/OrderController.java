package com.orderpayment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderpayment.apiwrapper.ApiResponse;
import com.orderpayment.entity.Order;
import com.orderpayment.helper.APIStatus;
import com.orderpayment.service.OrderService;



@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<?>> getOrder(@PathVariable Long id) {
		try {
		Order orders = service.getOrders(id);
		return ResponseEntity.ok(
				new ApiResponse<>(HttpStatus.OK.value(), APIStatus.SUCCESS.name(), "Order Data Fetch Successfully",orders));
		}
		catch (Exception e) {
			return ResponseEntity.ok(
					new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), APIStatus.FAILED.name(), "Something went wrong."));
		}
	}
	
	@GetMapping("/getAllOrders")
	public ResponseEntity<ApiResponse<?>> getAllOrders() {
		try {
			List<Order> list = service.getAllOrders();
			return ResponseEntity.ok(
					new ApiResponse<>(HttpStatus.OK.value(), APIStatus.SUCCESS.name(), "Order Data fetched",list));
			
		}
		catch (Exception e) {
			return ResponseEntity.ok(
					new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), APIStatus.FAILED.name(), "Something went wrong."));
		}
	}
	
	
	
}
