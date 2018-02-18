package com.pakotzy.hibernate;

import com.pakotzy.hibernate.entity.Course;
import com.pakotzy.hibernate.entity.Instructor;
import com.pakotzy.hibernate.entity.InstructorDetail;
import com.pakotzy.hibernate.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
    	try (SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class)
			    .addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
			    .addAnnotatedClass(Review.class).buildSessionFactory();
	         Session session = factory.openSession()) {

//		    create(session);
//		    read(session);
//		    delete(session);
	    }
    }

	private static void create(Session session) {
		Instructor instructor = new Instructor("God", "Highest", "god@earth.com");
		InstructorDetail instructorDetail = new InstructorDetail("bible.com/youtube", "Create humans");
		instructor.setInstructorDetail(instructorDetail);
		Course course1 = new Course("How to create a Human 101");
		Course course2 = new Course("Earth in 7 Days for Dummies");
		course1.setInstructor(instructor);
		course2.setInstructor(instructor);
		Review review1 = new Review("Not so useful in real life");
		Review review2 = new Review("Are you for real?");
		course1.addReview(review1, review2);
		Review review3 = new Review("God, is this really you?");
		course2.addReview(review3);

		session.beginTransaction();

		session.save(instructor);
		session.save(course1);
		session.save(course2);

		session.getTransaction().commit();
	}

	private static void read(Session session) {
    	session.beginTransaction();

		Instructor instructor = session.get(Instructor.class, 1);
		Course course1 = instructor.getCourse(0);
		Course course2 = instructor.getCourse(1);

		System.out.println(course2);
		System.out.println(course1);
//		System.out.println(instructor);

        session.getTransaction().commit();
    }

	private static void delete(Session session) {
    	session.beginTransaction();

    	Course course = session.get(Course.class, 10);
    	session.delete(course);

    	session.getTransaction().commit();
	}
}
