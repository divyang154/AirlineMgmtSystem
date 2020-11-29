package com.flyway.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.flyway.pojo.Airlines;
import com.flyway.pojo.BookingDetail;
import com.flyway.pojo.Flight;
import com.flyway.pojo.Places;
import com.flyway.pojo.User;

public class HibernateUtil {

	private static SessionFactory sessionFactory = null;

	public static Session getSession() {

		sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Airlines.class)
				.addAnnotatedClass(User.class).addAnnotatedClass(Places.class).addAnnotatedClass(BookingDetail.class)
				.addAnnotatedClass(Flight.class).buildSessionFactory();
		Session session = null;
		if (sessionFactory != null) {
			session = sessionFactory.getCurrentSession();
		}
		return session;
	}

	public static void closeSession(Session session) {
		System.out.println("close session");
//		session.close();
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}
}
