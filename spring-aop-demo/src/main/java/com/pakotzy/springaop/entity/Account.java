package com.pakotzy.springaop.entity;

public class Account {
	private String login;
	private String pass;

	public Account(String login, String pass) {
		this.login = login;
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "Account{" +
				"login='" + login + '\'' +
				", pass='" + pass + '\'' +
				'}';
	}
}