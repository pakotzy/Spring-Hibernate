package com.pakotzy.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
	private static final String jdbcUrl = "jdbc:mysql://localhost:3306/hb-03-one-to-many?useSSL=false";
	private static final String user = "hbstudent";
	private static final String pass = "hbstudent";

	public static void main(String[] args) {
		try {
			System.out.println("Connecting to: " + jdbcUrl);
			Connection conn = DriverManager.getConnection(jdbcUrl, user, pass);
			conn.close();
			System.out.println("Connection success!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
