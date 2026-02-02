package com.orderpayment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderpayment.apiwrapper.ApiResponse;
import com.orderpayment.dto.CustomerDTO;
import com.orderpayment.entity.Customer;
import com.orderpayment.helper.APIStatus;
import com.orderpayment.service.CustomerService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/customer")

@Tag(name = "CustomerRegisterController",description = "SaveAPI,GetCustomerById,GetAllCustomer and UserDeleteAPI")


public class CustomerController {

	@Autowired
	private CustomerService service;

	@PostMapping("/save")
	public ResponseEntity<ApiResponse<?>> save(@RequestBody CustomerDTO dto) {

		try {
		service.saveCustomerData(dto);
		return ResponseEntity.ok(
				new ApiResponse<>(HttpStatus.OK.value(), APIStatus.SUCCESS.name(), "Customer Data Saved Successfully."));
		}
		catch(Exception e) {
			return ResponseEntity.ok(
					new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), APIStatus.FAILED.name(), "Something went wrong."));
		}

	}

	@GetMapping("/getCustomer/{id}")
	public ResponseEntity<ApiResponse<?>> getCustomerData(@PathVariable Long id) {
		try {
		Customer customer = service.getCustomer(id);
		return ResponseEntity
				.ok(new ApiResponse<>(HttpStatus.OK.value(), APIStatus.SUCCESS.name(), "Customer Data ", customer));
		}
		catch(Exception e) {
			return ResponseEntity.ok(
					new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), APIStatus.FAILED.name(), "Something went wrong."));
			}

	}

	@GetMapping("/getAllCustomerData")
	public ResponseEntity<ApiResponse<?>> getAllCustomerData() {
		try {
		List<Customer> list = service.getAllCustomer();
		System.out.println(list);
		return ResponseEntity
				.ok(new ApiResponse<>(HttpStatus.OK.value(), APIStatus.SUCCESS.name(), "Customer Data ", list));
		}
		catch (Exception e) {
			return ResponseEntity.ok(
					new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), APIStatus.FAILED.name(), "Something went wrong."));
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse<?>> deleteCustomer(@PathVariable Long id) {
		try {
		service.deleteCustomer(id);
		return ResponseEntity
				.ok(new ApiResponse<>(HttpStatus.OK.value(), APIStatus.SUCCESS.name(), "Customer Data Deleted"));
		}
		catch (Exception e) {
			return ResponseEntity.ok(
					new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), APIStatus.FAILED.name(), "Something went wrong."));
		}
	}

}
