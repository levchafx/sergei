package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Role;
import model.User;
import service.UserService;

/**
 * Servlet implementation class Save
 */
public class Save extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Save() {
		super();
		// TODO Auto-generated constructor stub
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
		UserService userService = new UserService();
		User user = new User();
		user.setId(Integer.parseInt(request.getParameter("id")));
		user.setName(request.getParameter("name"));
		user.setSurname(request.getParameter("surname"));
		user.setAge(Integer.parseInt(request.getParameter("age")));
		user.setEmail(request.getParameter("email"));
		user.setLogin(request.getParameter("login"));
		user.setPassword(request.getParameter("password"));
		user.setRole(Role.valueOf(request.getParameter("role")));
		user.setProfile_enable(Boolean.valueOf(request.getParameter("profile_enable")));
		userService.updateUser(user);
		if (request.getSession().getAttribute("role") == Role.ADMIN) {
			request.getSession().removeAttribute("users");
			request.getSession().setAttribute("users", userService.getUsers());
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

}
