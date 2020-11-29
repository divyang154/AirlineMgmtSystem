package com.flyway.service;

import java.util.Date;
import java.util.List;

import com.flyway.dao.BookingDetailDao;
import com.flyway.pojo.BookingDetail;
import com.flyway.pojo.Flight;
import com.flyway.pojo.Places;
import com.flyway.pojo.User;

public class BookingDetailService {

	BookingDetailDao bookDetailDao = new BookingDetailDao();

	public BookingDetail createBookingDetail(User user, String paymentStatus, Flight flight, String noOfPerson) {
		BookingDetail bookDetail = new BookingDetail();
		Integer numberOfPerson = Integer.parseInt(noOfPerson);
		bookDetail.setFlight(flight);
		bookDetail.setPaymentStatus(paymentStatus);
		bookDetail.setNoOfPerson(numberOfPerson);
		bookDetail.setCreatedBy(user.getUserId());
		bookDetail.setUpdatedBy(user.getUserId());
		bookDetail.setUpdatedOn(new Date());
		bookDetail.setCreatedOn(new Date());
		bookDetail.setSourcePlace(flight.getSourcePlace());
		bookDetail.setDestinationPlace(flight.getDestinationPlace());
		bookDetail.setUser(user);
		bookDetailDao.createBooking(bookDetail);
		return bookDetail;
	}

	public List<BookingDetail> getBookingForUser(User user) {
		List<BookingDetail> bookingDetail = bookDetailDao.getBookingForUser(user);
		return bookingDetail;
	}

}
