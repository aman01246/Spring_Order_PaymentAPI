package com.orderpayment.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderpayment.apiwrapper.PaymentGatewayClient;
import com.orderpayment.dto.PaymentRequestDTO;
import com.orderpayment.entity.Payment;
import com.orderpayment.repository.OrderRepository;
import com.orderpayment.repository.PaymentRepository;
import com.orderpayment.service.PaymentService;

@Service
public class PaymentServiceImp implements PaymentService {

	@Autowired
	private PaymentRepository repo;

	@Autowired
	private PaymentGatewayClient gateway;

	@Autowired
	private OrderRepository orderRepo;

	@Override
	public Payment processPayment(PaymentRequestDTO dto) {

		String status = gateway.pay(dto);
		orderRepo.findById(dto.getOrderId()).orElseThrow(() -> new RuntimeException("Order not found"));
		Payment payment = new Payment();
		payment.setOrderId(dto.getOrderId());
		payment.setPaidAmount(dto.getPaidAmount());
		payment.setPaymentStatus(status);

		return repo.save(payment);
	}

}
