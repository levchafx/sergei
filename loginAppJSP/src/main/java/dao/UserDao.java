package dao;

import java.util.List;

import model.User;

public interface UserDao {
	User getUserByLogin(String login);

	User getUserById(int id);

	int saveUser(User user);

	void deleteUser(int id);

	boolean verifyUser(String login, String password);

	boolean verifyEmail(String email);

	boolean verifyLogin(String login);

	List<User> getAll();

	void updateUser(User user);
}