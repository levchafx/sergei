package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Role;
import model.User;
import service.UserService;

@WebServlet(name = "Login", urlPatterns = "/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();

	public Login() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = new User();
		user.setLogin(request.getParameter("login"));
		user.setPassword(request.getParameter("password"));
		HttpSession session = request.getSession();

		if (userService.verifyUser(user.getLogin(), user.getPassword())) {
			user = userService.getUserByLogin(user.getLogin());
			session.setAttribute("user", user.getLogin());
			session.setAttribute("role", user.getRole());
			session.setAttribute("user_id", user.getId());

			if (user.getRole() == Role.ADMIN) {
				session.setAttribute("users", userService.getUsers());
			}

			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} else {
			request.setAttribute("notfound", "user not found");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}

	}

}
