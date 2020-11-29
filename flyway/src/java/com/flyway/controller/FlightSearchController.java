package com.flyway.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flyway.pojo.Flight;
import com.flyway.pojo.Places;
import com.flyway.service.FlightService;
import com.flyway.service.PlaceServices;

@WebServlet("/flightSearch")

public class FlightSearchController extends HttpServlet {

	PlaceServices placeServ = new PlaceServices();
	FlightService flightServ = new FlightService();

	public FlightSearchController() {
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String source = request.getParameter("placeSelect");
		String destination = request.getParameter("placeSelectDestination");
		String dateOfTravel = request.getParameter("dateOfTravel");
		String noOfPerson = request.getParameter("noOfPerson");
		List<Flight> flightList = flightServ.searchFlight(source, destination, dateOfTravel);
		request.setAttribute("flightList", flightList);
		session.setAttribute("noOfPerson", noOfPerson);
		RequestDispatcher dispatcher = request.getRequestDispatcher("FlightSearchResult.jsp");
		dispatcher.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String queryStr = request.getQueryString();
		if (queryStr != null && queryStr.equals("loggedInUser=No")) {
			session.setAttribute("roleLoggedIn", "");
		}
		List<Places> placeList = placeServ.getAllPlaces();
		request.setAttribute("placeList", placeList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("FlightSearch.jsp");
		dispatcher.forward(request, response);
	}
}
