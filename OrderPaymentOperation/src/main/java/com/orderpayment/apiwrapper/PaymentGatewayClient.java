package com.orderpayment.apiwrapper;

import org.springframework.stereotype.Component;

import com.orderpayment.dto.PaymentRequestDTO;

@Component
public class PaymentGatewayClient {

	public String pay(PaymentRequestDTO dto) {
		return "SUCCESS";
	}
}
