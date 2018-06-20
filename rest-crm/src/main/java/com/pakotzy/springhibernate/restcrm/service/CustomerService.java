package com.pakotzy.springhibernate.restcrm.service;

import com.pakotzy.springhibernate.restcrm.entity.Customer;

import java.util.List;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}
