package com.pakotzy.springaop.dao;

import org.springframework.stereotype.Component;

@Component
public class ProductDAO {
	public void calculateProduct() {
		System.out.println(getClass() + ": DOING MY PRODUCT WORK");
	}

	public void getProduct() {
		System.out.println(getClass() + ": GETTING MY PRODUCT");
	}
}
