package com.pakotzy.springhibernate.restcrm.controller;

import com.pakotzy.springhibernate.restcrm.entity.Customer;
import com.pakotzy.springhibernate.restcrm.exception.CustomerNotFoundException;
import com.pakotzy.springhibernate.restcrm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}

	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable Integer customerId) {
		return customerService.getCustomer(customerId);
	}

	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		customer.setId(0);
		customerService.saveCustomer(customer);
		return customer;
	}

	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {
		if (!customerService.isExists(customer.getId())) {
			throw new CustomerNotFoundException();
		}

		customerService.saveCustomer(customer);
		return customer;
	}
}
