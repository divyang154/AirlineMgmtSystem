package com.flyway.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flyway.pojo.User;
import com.flyway.service.UserService;

@WebServlet("/userChangePassword")
public class UserChangePasswordController extends HttpServlet {

	// TODO Auto-generated constructor stub
	UserService userService=new UserService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession httpSession = request.getSession();

		User user = (User) httpSession.getAttribute("loggedInUser");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		String reNewPassword = request.getParameter("reNewPassword");
		String error = "";
		if (oldPassword == null || oldPassword.length() == 0) {
			error = "Old Password is blank";
			request.setAttribute("error", error);
			request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
		} else if (newPassword == null || newPassword.length() == 0 || reNewPassword == null
				|| reNewPassword.length() == 0) {
			error = "New Password is blank";
			request.setAttribute("error", error);
			request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
		} else if (!user.getPassword().equals(oldPassword)) {
			error = "Old Password is in incorrect";
			request.setAttribute("error", error);
			request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
		} else if (newPassword.equals(oldPassword)) {
			error = "New Password is same as Old Password";
			request.setAttribute("error", error);
			request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
		} else {

			if (newPassword.equals(reNewPassword)) {
				userService.updateUser(user.getUserId(),user.getUsername(), reNewPassword, user.getUserEmail(), user.getUserRole());
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
				error = "New Password and reNewPassword do not match.Please check";
				request.setAttribute("error", error);
				request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
			}
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
		
	}
}
