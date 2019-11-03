package service;

import java.util.List;

import dao.JdbcDaoImpl;
import dao.UserDao;
import model.User;

public class UserService {
	private UserDao userDaoImpl = new JdbcDaoImpl();

	public User getUserByLogin(String login) {
		return userDaoImpl.getUserByLogin(login);
	}

	public User getUserById(int id) {
		return userDaoImpl.getUserById(id);
	}

	public void saveUser(User user) {

		userDaoImpl.saveUser(user);
	}

	public boolean verifyUser(String login, String password) {

		return userDaoImpl.verifyUser(login, password);
	}

	public List<User> getUsers() {
		return userDaoImpl.getAll();
	}

	public void deleteUser(int id) {
		userDaoImpl.deleteUser(id);
	}

	public String verifyRegistration(String login, String password, String confirmPassword, String email) {
		String str = "";
		if (login.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
			str = "please make sure all fields are filled in";
		}
		if (!password.equals(confirmPassword)) {
			str = "wrong password";
		}
		if (userDaoImpl.verifyEmail(email)) {
			str = "provide another email";
		}
		if (userDaoImpl.verifyLogin(login)) {
			str = "please choose another login";
		}
		return str;
	}

	public void updateUser(User user) {
		userDaoImpl.updateUser(user);
	}
}