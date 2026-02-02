package com.orderpayment.service;

import java.util.List;

import com.orderpayment.dto.CustomerDTO;
import com.orderpayment.entity.Customer;

public interface CustomerService {

	void saveCustomerData(CustomerDTO dto);
	Customer getCustomer(Long id);
	List<Customer> getAllCustomer();
	void deleteCustomer(Long id);
	
}
