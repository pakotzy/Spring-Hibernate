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
	public Customer saveCustomer(Customer customer) {
		return repository.save(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		Customer customer = repository.findById(id).orElse(null);
		if (Objects.isNull(customer)) {
			throw new CustomerNotFoundException();
		}

		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			throw new CustomerNotFoundException();
		}
	}

	@Override
	public boolean isExists(int id) {
		return repository.existsById(id);
	}
}





