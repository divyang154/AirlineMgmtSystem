package com.flyway.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.flyway.pojo.Places;
import com.flyway.pojo.User;
import com.flyway.service.AirlinesService;
import com.flyway.service.PlaceServices;

@WebServlet("/sourceDestinationPlace")
public class SourceDestinationPlaceController extends HttpServlet {

	PlaceServices placesServ = new PlaceServices();

	public SourceDestinationPlaceController() {
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURL = request.getQueryString();
		if (requestURL != null && requestURL.contains("edit")) {
			doPut(request, response);
		} else {
			try {

				PrintWriter printWriter = response.getWriter();
				String placeName = request.getParameter("place");
				ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
				Validator validator = validatorFactory.getValidator();
				Places places = new Places();
				places.setPlaceName(placeName);
				Set<ConstraintViolation<Places>> constraintViolations = validator.validate(places);
				String errors = "<ul>";
				if (!constraintViolations.isEmpty()) {
					
					for (ConstraintViolation<Places> constraintViolation : constraintViolations) {
						errors += "<li>" + constraintViolation.getPropertyPath() + " "
								+ constraintViolation.getMessage() + "</li>";
					}
					errors += "</ul>";
					request.setAttribute("errors", errors);

				} else {
					placesServ.createPlacesServices(places);
				}
				List<Places> placesList = placesServ.getAllPlaces();
				request.setAttribute("listPlaces", placesList);
				request.setAttribute("errros", errors);
				request.getRequestDispatcher("SourceDestinationMaster.jsp").forward(request, response);

			} catch (Exception e) {
				request.setAttribute("errors", e.getMessage());
				request.getRequestDispatcher("SourceDestinationMaster.jsp").forward(request, response);
			}
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String requestURL = request.getQueryString();
		if (requestURL != null && requestURL.contains("edit")) {
			String splitargs[] = requestURL.split("=");
			Places place = placesServ.getPlace(splitargs[1]);
			RequestDispatcher dispatcher = request.getRequestDispatcher("SourceDestinationUpdate.jsp");
			request.setAttribute("place", place);
			dispatcher.forward(request, response);
		} else if (requestURL != null && requestURL.contains("delete")) {
			doDelete(request, response);
		} else {
			List<Places> placesList = placesServ.getAllPlaces();
			request.setAttribute("listPlaces", placesList);
			request.getRequestDispatcher("SourceDestinationMaster.jsp").forward(request, response);
		
		}
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("loggedInUser");
		Places place=null;
		try {
		PrintWriter printWriter = response.getWriter();
		String requestURL = request.getQueryString();
		String splitargs[] = requestURL.split("=");
		place = placesServ.getPlace(splitargs[1]);
		String placeName = request.getParameter("placeName");
		place.setPlaceName(placeName);
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<Places>> constraintViolations = validator.validate(place);
		if (!constraintViolations.isEmpty()) {
			String errors = "<ul>";
			for (ConstraintViolation<Places> constraintViolation : constraintViolations) {
				errors += "<li>" + constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage()
						+ "</li>";
			}
			errors += "</ul>";
			request.setAttribute("errors", errors);
			request.setAttribute("place", place);
			request.getRequestDispatcher("SourceDestinationUpdate.jsp").forward(request, response);

		} else {
			placesServ.updatePlaces(place, user);
			List<Places> placesList = placesServ.getAllPlaces();
			request.setAttribute("listPlaces", placesList);
			request.getRequestDispatcher("SourceDestinationMaster.jsp").forward(request, response);
		}
		}catch(Exception e) {
			request.setAttribute("errors", e.getMessage());
			request.setAttribute("place", place);
			request.getRequestDispatcher("SourceDestinationUpdate.jsp?edit="+place.getPlaceId()).forward(request, response);
		}
		
		
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		PrintWriter printWriter = response.getWriter();
		String requestURL = request.getQueryString();
		String splitargs[] = requestURL.split("=");
		placesServ.deletePlaces(splitargs[1]);
		List<Places> placesList = placesServ.getAllPlaces();
		printWriter.println("Airlines Name");
		request.setAttribute("listPlaces", placesList);
		request.getRequestDispatcher("SourceDestinationMaster.jsp").forward(request, response);
	}
}
