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
 * Servlet implementation class Update
 */
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Update() {
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
		if (request.getSession().getAttribute("role") == Role.USER) {
			int id = (int) request.getSession().getAttribute("user_id");
			User u = userService.getUserById(id);
			request.setAttribute("user", u);
			request.getRequestDispatcher("update.jsp").forward(request, response);
			return;
		}
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("user", userService.getUserById(id));
		request.getRequestDispatcher("update.jsp").forward(request, response);

	}

}
