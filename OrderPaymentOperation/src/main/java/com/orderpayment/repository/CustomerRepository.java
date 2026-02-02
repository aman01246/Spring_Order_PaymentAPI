package com.orderpayment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderpayment.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
