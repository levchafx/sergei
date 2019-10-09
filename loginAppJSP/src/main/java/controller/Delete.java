package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

@WebServlet(name = "Delete", urlPatterns = "/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();

	public Delete() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		userService.deleteUser(request.getParameter("login"));
		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}

}