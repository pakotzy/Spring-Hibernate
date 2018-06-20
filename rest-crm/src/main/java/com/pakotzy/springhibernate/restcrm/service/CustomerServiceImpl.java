package com.pakotzy.springhibernate.restcrm.service;

import com.pakotzy.springhibernate.restcrm.entity.Customer;
import com.pakotzy.springhibernate.restcrm.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository repository;

	@Override
	public List<Customer> getCustomers() {
		return repository.findAll();
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		repository.save(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		return repository.findById(theId).orElse(null);
	}

	@Override
	public void deleteCustomer(int theId) {
		repository.deleteById(theId);
	}
}





