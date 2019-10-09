package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Role;
import model.User;
import service.UserService;

@WebServlet(name = "AddAdmin", urlPatterns = "AddAdmin")
public class AddAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();

	public AddAdmin() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User(request.getParameter("login"), request.getParameter("password"),
				Role.valueOf(request.getParameter("role")));
		if (!userService.verifyUser(user)) {
			userService.saveUser(user);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			request.setAttribute("error", "please choose another login");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
}
