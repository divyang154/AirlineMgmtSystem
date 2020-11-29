package com.flyway.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.flyway.pojo.Airlines;
import com.flyway.pojo.Places;
import com.flyway.pojo.User;
import com.flyway.util.HibernateUtil;

public class PlacesDao {

	public PlacesDao() {
		// TODO Auto-generated constructor stub
	}

	public void createPlaces(Places places) {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.save(places);
			session.getTransaction().commit();
		} finally {
			HibernateUtil.closeSession(session);
		}
	}

	public List<Places> getAllPlaces() {
		Session theSession = HibernateUtil.getSession();
		List<Places> placesList;
		try {
			theSession.beginTransaction();
			placesList = theSession.createQuery("from Places").getResultList();
		} finally {
			HibernateUtil.closeSession(theSession);
		}
		return placesList;
	}

	public Places getPlace(String placeId) {
		Session session=HibernateUtil.getSession();
		Places place;
		try {
			session.beginTransaction();
			place=session.get(Places.class, Integer.parseInt(placeId));
			
		}finally {
			HibernateUtil.closeSession(session);
		}
		
		return place;
	}
	
	public void updatePlace(Places place) {
		Session session=HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.update(place);
			session.getTransaction().commit();
		}finally {
			HibernateUtil.closeSession(session);
		}
			
	}
	
	public void deletePlace(String placeId) {
		Session session=HibernateUtil.getSession();
		Places place;
		try {
			session.beginTransaction();
			place=session.get(Places.class, Integer.parseInt(placeId));
			session.delete(place);
			session.getTransaction().commit();
		}finally {
			HibernateUtil.closeSession(session);
		}
		
	}
	
	public Places searchByName(String searchString) {
		Session session = HibernateUtil.getSession();
		Places place;
		try {
			session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Places> query = builder.createQuery(Places.class);
			Root<Places> root = query.from(Places.class);
			query.select(root).where(builder.equal(root.get("placeName"), searchString));
			Query<Places> q = session.createQuery(query);
			place = q.getSingleResult();
		} finally {
			HibernateUtil.closeSession(session);
		}

		return place;
		
		
	}

}
