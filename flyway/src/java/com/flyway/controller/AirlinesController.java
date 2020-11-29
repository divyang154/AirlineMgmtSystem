package com.flyway.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import com.flyway.pojo.Airlines;
import com.flyway.service.AirlinesService;

@WebServlet("/airlinesMaster")
public class AirlinesController extends HttpServlet {

	AirlinesService airlinesService = new AirlinesService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURL = request.getQueryString();
		if (requestURL != null && requestURL.contains("edit")) {
			doPut(request, response);
		} else {
			try {
				
				PrintWriter printWriter = response.getWriter();
				String airlinesName = request.getParameter("airlinesName");
				ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
				Validator validator = validatorFactory.getValidator();
				Airlines airlines = new Airlines();
				airlines.setName(airlinesName);
				Set<ConstraintViolation<Airlines>> constraintViolations = validator.validate(airlines);
				if (!constraintViolations.isEmpty()) {
					String errors = "<ul>";
					for (ConstraintViolation<Airlines> constraintViolation : constraintViolations) {
						errors += "<li>" + constraintViolation.getPropertyPath() + " "
								+ constraintViolation.getMessage() + "</li>";
					}
					errors += "</ul>";
					request.setAttribute("errors", errors);

				} else {
					airlinesService.createAirlinesService(airlinesName);
					printWriter.println("Airlines Name");
				}
				List<Airlines> listAirlines = airlinesService.getAllAirlines();
				request.setAttribute("listAir", listAirlines);
				request.getRequestDispatcher("AirlinesMaster.jsp").forward(request, response);

			} catch (Exception e) {
				request.setAttribute("errors", e.getMessage());
				request.getRequestDispatcher("AirlinesMaster.jsp").forward(request, response);
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		String requestURL = request.getQueryString();
		if (requestURL != null && requestURL.contains("edit")) {
			String splitargs[] = requestURL.split("=");
			Airlines airline = airlinesService.getAirlines(splitargs[1]);
			RequestDispatcher dispatcher = request.getRequestDispatcher("updateAirlines.jsp");
			request.setAttribute("airline", airline);
			dispatcher.forward(request, response);
		} else if (requestURL != null && requestURL.contains("delete")) {
			doDelete(request, response);
		} else {
			String airlinesName = request.getParameter("airlinesName");
			List<Airlines> listAirlines = airlinesService.getAllAirlines();
			printWriter.println("Airlines Name");
			request.setAttribute("listAir", listAirlines);
			request.getRequestDispatcher("AirlinesMaster.jsp").forward(request, response);
		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
		PrintWriter printWriter = response.getWriter();
		String requestURL = request.getQueryString();
		String splitargs[] = requestURL.split("=");
		Airlines airline = airlinesService.getAirlines(splitargs[1]);
		String newName = request.getParameter("airlineName");
		airline.setName(newName);
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<Airlines>> constraintViolations = validator.validate(airline);
		if (!constraintViolations.isEmpty()) {
			String errors = "<ul>";
			for (ConstraintViolation<Airlines> constraintViolation : constraintViolations) {
				errors += "<li>" + constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage()
						+ "</li>";
			}
			errors += "</ul>";
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("updateAirlines.jsp?"+requestURL).forward(request, response);

		} else {
			airline.setName(newName);
			airlinesService.updateAirlines(airline);
			printWriter.println("Airlines Name");
			List<Airlines> listAirlines = airlinesService.getAllAirlines();
			request.setAttribute("listAir", listAirlines);
			request.getRequestDispatcher("AirlinesMaster.jsp").forward(request, response);
		}
		}catch(Exception e) {
			request.setAttribute("errors", e.getMessage());
			request.getRequestDispatcher("updateAirlines.jsp").forward(request, response);
		}
		
		
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		String requestURL = request.getQueryString();
		String splitargs[] = requestURL.split("=");
		airlinesService.deleteAirlineService(splitargs[1]);
		List<Airlines> listAirlines = airlinesService.getAllAirlines();
		printWriter.println("Airlines Name");
		request.setAttribute("listAir", listAirlines);
		request.getRequestDispatcher("AirlinesMaster.jsp").forward(request, response);
	}

}
