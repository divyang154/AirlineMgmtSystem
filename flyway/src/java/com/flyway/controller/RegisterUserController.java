package com.flyway.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flyway.pojo.Flight;
import com.flyway.pojo.Places;
import com.flyway.pojo.User;
import com.flyway.service.FlightService;
import com.flyway.service.PlaceServices;
import com.flyway.service.UserService;

@WebServlet("/registerUser")
public class RegisterUserController extends HttpServlet {

	FlightService flightServ = new FlightService();
	UserService userServ = new UserService();

	public RegisterUserController() {
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String error = "";
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		User user = null;
		try {
			user = userServ.userCreateService(username, password, email, "User");
		} catch (Exception e) {
			if (e instanceof UserException) {
				error = "User already exists.Please register using different username";
			}
			System.out.println("Exception" + e);
		}

		if (error.length() > 0) {
			request.setAttribute("error", error);
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			request.setAttribute("email", email);
			request.getRequestDispatcher("RegisterUser.jsp").forward(request, response);
		} else {
			session.setAttribute("loggedInUser", user);
			request.getRequestDispatcher("BookDetails.jsp").forward(request, response);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String queryString = request.getQueryString();
		String queryArr[] = queryString.split("=");
		Flight flight = flightServ.getFlight(queryArr[1]);
		session.setAttribute("flight", flight);
		String userLogged = (String) session.getAttribute("roleLoggedIn");
		if (userLogged.length() > 0) {
			request.getRequestDispatcher("BookDetails.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("RegisterUser.jsp").forward(request, response);

		}
	}
}
