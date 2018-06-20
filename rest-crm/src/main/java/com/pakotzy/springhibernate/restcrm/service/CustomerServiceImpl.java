package com.pakotzy.springhibernate.restcrm.service;

import com.pakotzy.springhibernate.restcrm.entity.Customer;
import com.pakotzy.springhibernate.restcrm.exception.CustomerNotFoundException;
import com.pakotzy.springhibernate.restcrm.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
		Customer customer = repository.findById(theId).orElse(null);
		if (Objects.isNull(customer)) {
			throw new CustomerNotFoundException("No such customer");
		}

		return customer;
	}

	@Override
	public void deleteCustomer(int theId) {
		repository.deleteById(theId);
	}
}





