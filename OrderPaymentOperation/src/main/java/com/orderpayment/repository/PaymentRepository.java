package com.orderpayment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderpayment.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
