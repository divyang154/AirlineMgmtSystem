package com.flyway.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.flyway.pojo.BookingDetail;
import com.flyway.pojo.Flight;
import com.flyway.pojo.User;
import com.flyway.util.HibernateUtil;

public class BookingDetailDao {

	public void createBooking(BookingDetail bookingDetail) {
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.save(bookingDetail);
			session.getTransaction().commit();
		} finally {
			HibernateUtil.closeSession(session);
		}

	}

	public List<BookingDetail> getBookingForUser(User user) {
		Session session = null;
		List<BookingDetail> bookingList = null;
		List<BookingDetail> list = null;
		if (user != null) {

		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<BookingDetail> query = builder.createQuery(BookingDetail.class);
			Root<BookingDetail> root = query.from(BookingDetail.class);

			Path<String> userPath = root.get("user");
			Predicate sourcePlacePredicate = builder.equal(userPath, user);
			query.select(root).where(sourcePlacePredicate);

			list = session.createQuery(query).getResultList();

		} finally {
			HibernateUtil.closeSession(session);
		}
		}
		return list;
		
	}

}
