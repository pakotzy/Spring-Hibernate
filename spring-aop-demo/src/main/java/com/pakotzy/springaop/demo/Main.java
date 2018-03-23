package com.pakotzy.springaop.demo;

import com.pakotzy.springaop.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

		accountDAO.addAccount();

		context.close();
	}
}
