package com.pakotzy.springhibernate.restcrm.repository;

import com.pakotzy.springhibernate.restcrm.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
