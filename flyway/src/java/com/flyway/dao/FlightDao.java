package com.flyway.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.flyway.pojo.Flight;
import com.flyway.pojo.Places;
import com.flyway.pojo.User;
import com.flyway.util.HibernateUtil;

public class FlightDao {

	public void createFlight(Flight flight) {

		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.save(flight);
			session.getTransaction().commit();
		} finally {
			HibernateUtil.closeSession(session);
		}

	}

	public List<Flight> getAllFlights() {
		Session session = null;
		List<Flight> flightList = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			flightList = session.createQuery("from Flight").getResultList();
		} finally {
			HibernateUtil.closeSession(session);
		}
		return flightList;
	}

	public void deleteFlight(String flightId) {
		Session session = HibernateUtil.getSession();
		Flight flight;
		try {
			session.beginTransaction();
			flight = session.get(Flight.class, Integer.parseInt(flightId));
			session.delete(flight);
			session.getTransaction().commit();
		} finally {
			HibernateUtil.closeSession(session);
		}

	}

	public Flight getFlight(String flightId) {
		Session session = HibernateUtil.getSession();
		Flight flight;
		try {
			session.beginTransaction();
			flight = session.get(Flight.class, Integer.parseInt(flightId));
			session.getTransaction().commit();
		} finally {
			HibernateUtil.closeSession(session);
		}
		return flight;
	}

	public void updateFlight(Flight flight) {
		Session session = HibernateUtil.getSession();

		try {
			session.beginTransaction();
//			Flight flight = session.get(Flight.class, Integer.parseInt(flightId));
//			flight.setPrice(price);
			session.update(flight);
			session.getTransaction().commit();
		} finally {
			HibernateUtil.closeSession(session);
		}

	}

	public List<Flight> searchFlight(Places placeSource, Places destinationPlace, Date dateOfTravel) {
		Session session = HibernateUtil.getSession();
		List<Flight> flightList;
		Predicate middleNameAndEnablePredicate = null;
		List<Flight> list = null;
		try {
			session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Flight> query = builder.createQuery(Flight.class);
			Root<Flight> root = query.from(Flight.class);

			Path<String> sourcePlacePath = root.get("sourcePlace");
			Path<String> destinationPlacePath = root.get("destinationPlace");
			Path<String> arrivalDatePath = root.get("arrivalDate");

			if (dateOfTravel != null) {
				Predicate sourcePlacePredicate = builder.equal(sourcePlacePath, placeSource);
				Predicate destinationPlacePredicate = builder.equal(destinationPlacePath, destinationPlace);
				Predicate arrivalDatePredicate = builder.equal(arrivalDatePath, dateOfTravel);

				middleNameAndEnablePredicate = builder.and(sourcePlacePredicate, destinationPlacePredicate,
						arrivalDatePredicate);
			} else {
				Predicate sourcePlacePredicate = builder.equal(sourcePlacePath, placeSource);
				Predicate destinationPlacePredicate = builder.equal(destinationPlacePath, destinationPlace);
				middleNameAndEnablePredicate = builder.and(sourcePlacePredicate, destinationPlacePredicate);
			}

			query.select(root).where(middleNameAndEnablePredicate);

			list = session.createQuery(query).getResultList();

		} finally {
			HibernateUtil.closeSession(session);
		}
		return list;
	}

}
