package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Role;
import model.User;
import service.UserService;

@WebServlet(name = "InitialServlet", urlPatterns = "/InitialServlet", loadOnStartup = 1, initParams = {
		@WebInitParam(description = "admin1", name = "admin1", value = "admin1"),
		@WebInitParam(description = "password1", name = "password1", value = "1234"),
		@WebInitParam(description = "admin2", name = "admin2", value = "admin2"),
		@WebInitParam(description = "password2", name = "password2", value = "1234") })
public class InitialServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InitialServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService userService = new UserService();
		User admin = new User(getInitParameter("admin1"), getInitParameter("password1"), Role.ADMIN);
		User admin1 = new User(getInitParameter("admin2"), getInitParameter("password2"), Role.ADMIN);
		userService.saveUser(admin);
		userService.saveUser(admin1);
		System.out.println(userService.getUsers());
		request.getSession().setMaxInactiveInterval(600);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}