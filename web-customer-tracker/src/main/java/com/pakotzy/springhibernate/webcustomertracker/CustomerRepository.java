package com.pakotzy.springhibernate.webcustomertracker;

import org.springframework.data.repository.CrudRepository;

// This will be implemented by Spring into a Bean called userRepository

public interface CustomerRepository extends CrudRepository<Customer, Long> {}
