package com.pakotzy.springhibernate.restcrm.service;

import com.pakotzy.springhibernate.restcrm.entity.Customer;

import java.util.List;

public interface CustomerService {

	public List<Customer> getCustomers();

	public Customer saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);

	public boolean isExists(int id);
	
}
