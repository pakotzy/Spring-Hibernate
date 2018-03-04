package com.pakotzy.springhibernate.webcustomertracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/customers")
public class ListController {
	@Autowired
	private CustomerRepository customerRepository;

	@RequestMapping()
	public String getHelpPage() {
		return "customers";
	}

	@GetMapping("/add")
	public @ResponseBody String addNewCustomer(@RequestParam String name, @RequestParam String lastName,
	                                           @RequestParam String email) {
		Customer customer = new Customer();
		customer.setFirstName(name);
		customer.setLastName(lastName);
		customer.setEmail(email);

		customerRepository.save(customer);
		return "Saved";
	}

	@GetMapping("/all")
	public @ResponseBody Iterable<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}
}
