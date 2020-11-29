package com.flyway.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flyway.pojo.BookingDetail;
import com.flyway.pojo.Flight;
import com.flyway.pojo.User;
import com.flyway.service.BookingDetailService;

@WebServlet("/bookingDetail")
public class BookingDetailController extends HttpServlet {

	BookingDetailService bookSevice = new BookingDetailService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("loggedInUser");
		Flight flight = (Flight) httpSession.getAttribute("flight");
		String noOfPerson = (String) httpSession.getAttribute("noOfPerson");
		BookingDetail bookDetail=bookSevice.createBookingDetail(user, "PaymentDone", flight, noOfPerson);
		request.setAttribute("booking", bookDetail);
		request.getRequestDispatcher("Conclusion.jsp").forward(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("loggedInUser");
		List<BookingDetail> bookingDetail = bookSevice.getBookingForUser(user);
		request.setAttribute("bookingDetail", bookingDetail);
		request.getRequestDispatcher("MyBooking.jsp").forward(request, response);
	}

}
