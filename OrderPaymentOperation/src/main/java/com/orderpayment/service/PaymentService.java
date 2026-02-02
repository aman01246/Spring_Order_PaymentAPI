package com.orderpayment.service;

import com.orderpayment.dto.PaymentRequestDTO;
import com.orderpayment.entity.Payment;

public interface PaymentService {

	Payment processPayment(PaymentRequestDTO req);
}
