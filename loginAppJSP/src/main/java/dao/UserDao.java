package dao;

import model.User;

public interface UserDao {
	User getUserByLogin(String login);

	void saveUser(User user);

	void deleteUser(String login);

	boolean verifyUser(User user);
}