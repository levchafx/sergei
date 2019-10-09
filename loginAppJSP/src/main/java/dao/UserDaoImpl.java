package dao;

import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDaoImpl implements UserDao {
	private static List<User> users = new ArrayList<User>();

	public User getUserByLogin(String login) {
		for (User user : users) {
			if (user.getLogin().equalsIgnoreCase(login)) {
				return user;

			}
		}
		return null;
	}

	public void saveUser(User user) {
		users.add(user);

	}

	public void deleteUser(String login) {
		users.remove(getUserByLogin(login));

	}

	public boolean verifyUser(User user) {
		for (User verify : users) {
			if (verify.getLogin().equalsIgnoreCase(user.getLogin())
					&& verify.getPassword().equals(user.getPassword())) {
				return true;
			}
		}
		return false;
	}

	public List<User> getUsers() {
		return users;
	}

}