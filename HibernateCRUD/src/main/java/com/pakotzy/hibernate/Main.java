package com.pakotzy.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		try (SessionFactory factory = new Configuration()
										.configure()
										.addAnnotatedClass(Employee.class)
										.buildSessionFactory()) {
			Session session = factory.openSession();
			session.beginTransaction();

			Employee employee = new Employee("God", "Highest", "Eternity");
			create(session, employee);
			System.out.println("Created: " + employee);
			System.out.println("Retrieved: " + retrieve(session, 1));
			System.out.println(ifCompany(session, "Eternity"));
			delete(session, 1);

			session.getTransaction().commit();
		}
	}

	private static void delete(Session session, int id) {
		session.createQuery("delete Employee where id=:id").setParameter("id", id).executeUpdate();
	}

	private static List<Employee> ifCompany(Session session, String company) {
		return session.createQuery("from Employee where company=:company", Employee.class).setParameter("company",
				company).getResultList();
	}

	private static Employee retrieve(Session session, int i) {
		return session.get(Employee.class, i);
	}

	private static void create(Session session, Employee employee) {
		session.save(employee);
	}
}
