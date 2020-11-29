package com.flyway.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.flyway.pojo.Airlines;
import com.flyway.pojo.Flight;
import com.flyway.pojo.Places;
import com.flyway.pojo.User;
import com.flyway.service.AirlinesService;
import com.flyway.service.FlightService;
import com.flyway.service.PlaceServices;

@WebServlet("/manageFlight")
public class ManageFlightController extends HttpServlet {

	PlaceServices placeServ = new PlaceServices();
	AirlinesService airlinesServ = new AirlinesService();
	FlightService flightService = new FlightService();

	public ManageFlightController() {
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURL = request.getQueryString();
		if (requestURL != null && requestURL.contains("edit")) {
			doPut(request, response);
		} else {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("loggedInUser");

			String placeSelectDestination = request.getParameter("placeSelectDestination");
			String airlinesSelect = request.getParameter("airlinesSelect");
			String placeSelect = request.getParameter("placeSelect");
			String dateTravel = request.getParameter("dateOfTravel");
			String ticketPrice = request.getParameter("ticketPrice");

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date date = null;
			try {
				date = formatter.parse(dateTravel);
			} catch (Exception e) {
			}
			String error = getError(ticketPrice);
			if (error.length() == 0) {
				flightService.createFlightFlight(user, airlinesSelect, placeSelect, placeSelectDestination, ticketPrice,
						date);
				traverseToMainPage(request, response);
			} else {
				request.setAttribute("errors", error);
				traverseToMainPage(request, response);
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURL = request.getQueryString();
		if (requestURL != null && requestURL.contains("edit")) {
			String splitargs[] = requestURL.split("=");
//			String flightId=request.getParameter("ticketPrice");
			Flight flight = flightService.getFlight(splitargs[1]);
			List<Places> placeList = placeServ.getAllPlaces();
			request.setAttribute("placeList", placeList);
			List<Airlines> airlinesList = airlinesServ.getAllAirlines();
			request.setAttribute("placeList", placeList);
			request.setAttribute("airlinesList", airlinesList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ManageListOfFlightsUpdate.jsp");
			request.setAttribute("flight", flight);
			Date date = flight.getArrivalDate();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String dateStr = "";
			try {
				dateStr = formatter.format(date);

			} catch (Exception e) {

			}
			request.setAttribute("date", dateStr);
			dispatcher.forward(request, response);
		} else if (requestURL != null && requestURL.contains("delete")) {
			doDelete(request, response);
		} else {
			traverseToMainPage(request, response);
		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURL = request.getQueryString();
		String splitargs[] = requestURL.split("=");
		String placeSelectDestination = request.getParameter("placeSelectDestination");
		String airlinesSelect = request.getParameter("airlinesSelect");
		String placeSelect = request.getParameter("placeSelect");
		String dateTravel = request.getParameter("dateOfTravel");
		String ticketPrice = request.getParameter("ticketPrice");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loggedInUser");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = formatter.parse(dateTravel);
		} catch (Exception e) {
		}

		String error = getError(ticketPrice);
		if (error.length() == 0) {
			flightService.updateFlight(airlinesSelect, placeSelect, placeSelectDestination, ticketPrice, date, user,
					splitargs[1]);
			traverseToMainPage(request, response);

		} else {
			request.setAttribute("errors", error);
			request.setAttribute("price", ticketPrice);
			traverseToUpdatePageAfterError(request, response);
		}

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		String requestURL = request.getQueryString();
		String splitargs[] = requestURL.split("=");
		flightService.deleteFlight(splitargs[1]);
		traverseToMainPage(request, response);
	}

	private void traverseToMainPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Flight> flightList = null;
		try {
			flightList = flightService.getAllFlight();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Places> placeList = placeServ.getAllPlaces();
		request.setAttribute("placeList", placeList);
		List<Airlines> airlinesList = airlinesServ.getAllAirlines();
		request.setAttribute("placeList", placeList);
		request.setAttribute("airlinesList", airlinesList);
		request.setAttribute("flightList", flightList);
		request.getRequestDispatcher("ManageListOfFlights.jsp").forward(request, response);
	}

	private String getError(String ticketPrice) {
		Flight flight = new Flight();
		flight.setPrice(ticketPrice);
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<Flight>> constraintViolations = validator.validate(flight);
		String errors = "";
		if (!constraintViolations.isEmpty()) {
			errors = "<ul>";
			for (ConstraintViolation<Flight> constraintViolation : constraintViolations) {
				errors += "<li>" + constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage()
						+ "</li>";
			}
			errors += "</ul>";

		}
		return errors;
	}

	private void traverseToUpdatePageAfterError(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURL = request.getQueryString();
		if (requestURL != null && requestURL.contains("edit")) {
			String splitargs[] = requestURL.split("=");
//			String flightId=request.getParameter("ticketPrice");
			Flight flight = flightService.getFlight(splitargs[1]);
			flight.setPrice(request.getParameter("ticketPrice"));
			List<Places> placeList = placeServ.getAllPlaces();
			request.setAttribute("placeList", placeList);
			List<Airlines> airlinesList = airlinesServ.getAllAirlines();
			request.setAttribute("placeList", placeList);
			request.setAttribute("airlinesList", airlinesList);
			flight.setPrice(request.getParameter("ticketPrice"));
			request.setAttribute("flight", flight);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ManageListOfFlightsUpdate.jsp");

			Date date = flight.getArrivalDate();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String dateStr = "";
			try {
				dateStr = formatter.format(date);

			} catch (Exception e) {

			}
			request.setAttribute("date", dateStr);
			dispatcher.forward(request, response);
		}
	}

}