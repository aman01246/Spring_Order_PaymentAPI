package com.orderpayment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderpayment.apiwrapper.ApiResponse;
import com.orderpayment.dto.PaymentRequestDTO;
import com.orderpayment.entity.Payment;
import com.orderpayment.helper.APIStatus;
import com.orderpayment.service.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/payment")
public class PaymentCotroller {

	@Autowired
	private PaymentService service;
	 
	@PostMapping("/pay")
	public ResponseEntity<ApiResponse<?>> postMethodName(@RequestBody PaymentRequestDTO dto) {
		try {
		Payment processPayment = service.processPayment(dto);
		return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), APIStatus.SUCCESS.name(), "Payment Data",processPayment));
		}
		catch (Exception e) {
			return ResponseEntity.ok(new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), APIStatus.FAILURE.name(), "Something went wrong"));

		}
	}
	
}

