package com.flyway.dao;

import java.util.List;

import org.hibernate.Session;

import com.flyway.pojo.Airlines;
import com.flyway.util.HibernateUtil;

public class AirlinesDao {

	public void create(Airlines airlines) {
		Session session = HibernateUtil.getSession();

		try {
			session.beginTransaction();
			session.save(airlines);
			session.getTransaction().commit();
		} finally {
			HibernateUtil.closeSession(session);
		}
	}

	public List<Airlines> getAllAirlines() {
		Session theSession = HibernateUtil.getSession();
		List<Airlines> airlinesList;
		try {
			theSession.beginTransaction();
			airlinesList = theSession.createQuery("from Airlines").getResultList();
		} finally {
			HibernateUtil.closeSession(theSession);
		}
		return airlinesList;
	}

	public void deleteAirline(String id) {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.createQuery("delete from Airlines where airlineId=" + id).executeUpdate();
			session.getTransaction().commit();
		} finally {
			HibernateUtil.closeSession(session);
		}

	}

	public Airlines getAirline(Integer id) {
		Session session = HibernateUtil.getSession();
		Airlines airlines;
		try {
			session.beginTransaction();
			airlines=session.get(Airlines.class, id);
		} finally {

		}
        return airlines; 
	}
	
	public void updateAirline(Airlines airline) {
		Session session=HibernateUtil.getSession();
		Airlines airlines;
		try {
			session.beginTransaction();
			airlines=session.get(Airlines.class, airline.getAirlineId());
			airlines.setName(airline.getName());
			airlines.setUpdatedOn(airline.getUpdatedOn());
			session.getTransaction().commit();
		}finally {
			HibernateUtil.closeSession(session);
		}
		
	}
}
