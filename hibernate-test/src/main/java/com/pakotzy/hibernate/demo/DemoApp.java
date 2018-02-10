package com.pakotzy.hibernate.demo;

import com.pakotzy.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DemoApp {
	public static void main(String[] args) {
		try (SessionFactory sessionFactory = new Configuration()
				.configure()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory()) {

			Session session = sessionFactory.openSession();
			session.beginTransaction();

//			Create
			Student student = new Student("Pasha", "Kotelnytskyi", "pakotzy@gmail.com");
			session.save(student);
			System.out.println("Saved: " + student);
//			Read
			Student retStudent = session.get(Student.class, student.getId());
			System.out.println("Retrieved: " + retStudent);
//			Read query
			String hql = "FROM Student s where s.email like '%gmail.com'";
			List<Student> students = session.createQuery(hql, Student.class).getResultList();
			for (Student s : students) {
				System.out.println("Got: " + s);
			}
//			Update
			Student upStudent = session.get(Student.class, 1);
			upStudent.setEmail("pakotzy@god.earth");
//			Update query
			session.createQuery("UPDATE Student set email = 'nothing@worm.earth' where email like '%gmail.com'").executeUpdate();
//			Delete
			Student delStudent = session.get(Student.class, 1);
			session.delete(delStudent);
//			Delete query
			session.createQuery("delete Student where email like '%worm.earth'").executeUpdate();

			session.getTransaction().commit();
		}
		System.out.println("Done!");
	}
}
