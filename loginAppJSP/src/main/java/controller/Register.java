package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.UserService;

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();

	public Register() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/register.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (userService.verifyRegistration(request.getParameter("login"), request.getParameter("password"),
				request.getParameter("confirmpassword")).isEmpty()) {
			userService.saveUser(new User(request.getParameter("name"), request.getParameter("surname"),
					Integer.parseInt(request.getParameter("age")), request.getParameter("email"),
					request.getParameter("login"), request.getParameter("password")));
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} else {
			request.setAttribute("error", userService.verifyRegistration(request.getParameter("login"),
					request.getParameter("password"), request.getParameter("confirmpassword")));
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}

	}

}