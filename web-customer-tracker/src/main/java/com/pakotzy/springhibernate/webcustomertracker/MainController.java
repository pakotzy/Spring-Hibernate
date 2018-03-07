package com.pakotzy.springhibernate.webcustomertracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping()
	public String getAllCustomers(Model model) {
		model.addAttribute("customers", customerRepository.findAll());
		return "index";
	}

	@GetMapping("/addForm")
	public String addFrom(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);

		return "addForm";
	}

	@PostMapping("/save")
	public String addNewCustomer(Customer customer) {
		customerRepository.save(customer);

		return "redirect:/";
	}
}
