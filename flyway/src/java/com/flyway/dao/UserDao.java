package com.flyway.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.query.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;

import com.flyway.pojo.User;
import com.flyway.util.HibernateUtil;

public class UserDao {

	public void create(User user) {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();

		} 
		catch(Exception e) {
			System.out.println("Exception" + e);
		}
		finally {
			HibernateUtil.closeSession(session);
		}
	}

	public User getUser(String name) {
		Session session = HibernateUtil.getSession();
		User user;
		try {
			session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<User> query = builder.createQuery(User.class);
			Root<User> root = query.from(User.class);
			query.select(root).where(builder.equal(root.get("username"), name));
			Query<User> q = session.createQuery(query);
			user = q.getSingleResult();
		} finally {
			HibernateUtil.closeSession(session);
		}

		return user;
	}

	public void updateUser(User user) {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.update(user);
			session.getTransaction().commit();
		} finally {
			HibernateUtil.closeSession(session);
		}

	}
}
