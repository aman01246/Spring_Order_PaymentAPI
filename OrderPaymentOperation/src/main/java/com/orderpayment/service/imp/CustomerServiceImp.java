package com.orderpayment.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderpayment.dto.CustomerDTO;
import com.orderpayment.entity.Customer;
import com.orderpayment.entity.Order;
import com.orderpayment.exception.ResourceNotFoundException;
import com.orderpayment.repository.CustomerRepository;
import com.orderpayment.service.CustomerService;

@Service
public class CustomerServiceImp implements CustomerService {

	@Autowired
	private CustomerRepository repo;

	@Override
	public void saveCustomerData(CustomerDTO dto) {

		Customer cust = new Customer();
		cust.setName(dto.getName());
		cust.setEmail(dto.getEmail());

		List<Order> orders = dto.getOrders().stream().map(o -> {
			Order order = new Order();
			order.setProductName(o.getProductName());
			order.setAmount(o.getAmount());
			order.setCustomer(cust);
			return order;
		}).toList();
		cust.setOrders(orders);

		repo.save(cust);
	}

	@Override
	public Customer getCustomer(Long id) {
		Customer customer = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Data not found"));
		return customer;
	}

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> list = repo.findAll();
		if (list.isEmpty()) {
			throw new ResourceNotFoundException("Data Not found ..");
		}
		return list;
	}

	@Override
	public void deleteCustomer(Long id) {

		repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Data not found"));
		repo.deleteById(id);

	}

}
