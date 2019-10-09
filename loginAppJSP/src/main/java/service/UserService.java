package service;

import java.util.List;

import dao.UserDaoImpl;
import model.User;

public class UserService {
	private UserDaoImpl userDaoImpl = new UserDaoImpl();

	public User getUserByLogin(String login) {
		return userDaoImpl.getUserByLogin(login);
	}

	public void saveUser(User user) {

		userDaoImpl.saveUser(user);
	}

	public boolean verifyUser(User user) {

		return userDaoImpl.verifyUser(user);
	}

	public List<User> getUsers() {
		return userDaoImpl.getUsers();
	}

	public void deleteUser(String login) {
		userDaoImpl.deleteUser(login);
	}

	public String verifyRegistration(String login, String password, String confirmPassword) {
		String str = "";
		if (login.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
			str = "please make sure all fields are filled in";
		}
		if (!password.equals(confirmPassword)) {
			str = "wrong password";
		}
		if (userDaoImpl.verifyUser(new User(login, password))) {
			str = "please choose another login";
		}
		return str;
	}
}