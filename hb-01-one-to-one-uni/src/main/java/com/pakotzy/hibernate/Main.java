package com.pakotzy.hibernate;

import com.pakotzy.hibernate.entity.Instructor;
import com.pakotzy.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
    	try (SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class)
			    .addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
			    Session session = factory.openSession()) {

    		Instructor instructor = new Instructor("God", "Highest", "god@earth.com");
		    InstructorDetail instructorDetail = new InstructorDetail("bible.com/youtube", "Create humans");
		    instructor.setInstructorDetail(instructorDetail);

		    session.beginTransaction();

//		    saveUni(session, instructor);
//		    System.out.println(getUni(session, 1));
//		    deleteUni(session, instructor);

//		    saveBi(session, instructorDetail);
//		    System.out.println(getBi(session, 1).getInstructor());
		    deleteBiSingle(session, 3);

		    session.getTransaction().commit();
	    }
    }

//    Saves Entity and all connected using Uni-directional mapping
    private static void saveUni(Session session, Instructor instructor) {
	    session.save(instructor);
    }
//    Deletes Entity and all connected using Uni-directional mapping
    private static void deleteUni(Session session, Instructor instructor) {
    	session.delete(instructor);
    }
//    Get Entity and all connected to it using Uni-directional mapping
    private static InstructorDetail getUni(Session session, int id) {
	    Instructor instructor = session.get(Instructor.class, id);
	    return instructor.getInstructorDetail();
    }
//    Saves Entity and all connected using Bi-directional mapping
	private static void saveBi(Session session, InstructorDetail detail) {
		session.save(detail);
	}
//    Deletes Entity leaving all that connect to it using Bi-directional mapping
	private static void deleteBiSingle(Session session, int id) {
		InstructorDetail temp = getBi(session, id);
		temp.getInstructor().setInstructorDetail(null);
		session.delete(temp);
	}
//    Deletes Entity and all connected using Bi-directional mapping
	private static void deleteBi(Session session, int id) {
		session.delete(getBi(session, id));
	}
//    Get Entity and all connected to it using Bi-directional mapping
	private static InstructorDetail getBi(Session session, int id) {
		return session.get(InstructorDetail.class, id);
	}
}
