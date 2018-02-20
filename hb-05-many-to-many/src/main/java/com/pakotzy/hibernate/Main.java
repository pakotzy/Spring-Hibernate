package com.pakotzy.hibernate;

import com.pakotzy.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
    	try (SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class)
			    .addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
			    .addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();
	         Session session = factory.openSession()) {

//		    create(session);
		    read(session);
//		    delete(session);
	    }
    }

	private static void create(Session session) {
		Course course = new Course("How to be awesome");
		Course course1 = new Course("How to find a job as a Java developer");
		Course course2 = new Course("Machine Learning for Awesome people");

		Student student = new Student("John", "Doe", "joh@notawesome.com");
		Student student1 = new Student("Pavlo", "Kotelnytskyi", "pakotzy@awesombutjobless.com");

		course.addStudent(student);
		student1.addCourse(course1, course2);

		session.save(course);
		session.save(course1);
		session.save(course2);
		session.save(student);
		session.save(student1);

		session.beginTransaction();

		session.getTransaction().commit();
	}

	private static void read(Session session) {
    	session.beginTransaction();

		Course course = session.get(Course.class, 15);
		course.getStudents().get(0);

		System.out.println(course.getStudents().get(0));

        session.getTransaction().commit();
    }

	private static void delete(Session session) {
    	session.beginTransaction();

    	Course course = session.get(Course.class, 13);
    	session.delete(course);

    	session.getTransaction().commit();
	}
}
