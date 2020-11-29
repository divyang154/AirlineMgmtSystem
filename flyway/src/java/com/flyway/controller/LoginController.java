package com.flyway.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flyway.pojo.User;
import com.flyway.service.UserService;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	UserService userService = new UserService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();
		HttpSession session=request.getSession();
		User user;
		String error = "";
		if (username == null || username.length() <= 0) {
			error = "Username cannot be blank";
			request.setAttribute("error", error);
			request.getRequestDispatcher("login.jsp").forward(request, response);

		} else if (password == null || password.length() <= 0) {
			error = "Password cannot be blank";
			request.setAttribute("error", error);
			request.getRequestDispatcher("login.jsp").forward(request, response);

		} else {

			try {
				user = userService.getUserService(username);
				if(!user.getPassword().equals(password)) {
					error = "Password is incorrect.Please enter correct password";
					request.setAttribute("error", error);
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
				else {
					session.setAttribute("loggedInUser", user);
					if(user.getUserRole().equals("Administrator")) {
						request.getRequestDispatcher("AdminPanel.jsp").forward(request, response);
						session.setAttribute("roleLoggedIn", "Admin");
					}
					
					if(user.getUserRole().equals("User")) {
						request.getRequestDispatcher("UserPanel.jsp").forward(request, response);
						session.setAttribute("roleLoggedIn", "User");
					}
					
					
				}

			} catch (Exception e) {
				error = "User does not exists.Please enter appropriate username";
				request.setAttribute("error", error);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
	}
}
