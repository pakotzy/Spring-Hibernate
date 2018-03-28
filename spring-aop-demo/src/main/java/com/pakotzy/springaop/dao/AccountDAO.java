package com.pakotzy.springaop.dao;

import com.pakotzy.springaop.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	public void addAccount(Account account) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}

	public void getAccount(Account account) {
		System.out.println(getClass() + ": DOING MY DB WORK: RETRIEVING AN ACCOUNT");
	}

	public void calculateSomething(Account account) {
		System.out.println(getClass() + ": DOING MY DB WORK: CALCULATING SOMETHING");
	}
}
