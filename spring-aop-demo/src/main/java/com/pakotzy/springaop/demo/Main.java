package com.pakotzy.springaop.demo;

import com.pakotzy.springaop.dao.AccountDAO;
import com.pakotzy.springaop.dao.ProductDAO;
import com.pakotzy.springaop.entity.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

		Account account = new Account("boss", "verystrongpasswords123");
		System.out.println();
		accountDAO.addAccount(account);
		System.out.println();
		accountDAO.getAccount(account);
		System.out.println();
		accountDAO.calculateSomething(account);

		System.out.println();
		ProductDAO productDAO = context.getBean("productDAO", ProductDAO.class);
		productDAO.calculateProduct();
		productDAO.getProduct();

		context.close();
	}
}
