package dao;

import java.util.List;

import model.User;

public class UserDaoImpl implements UserDao {

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int saveUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean verifyUser(String login, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verifyEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verifyLogin(String login) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	 * private static List<User> users = new ArrayList<User>();
	 * 
	 * public User getUserByLogin(String login) { for (User user : users) { if
	 * (user.getLogin().equalsIgnoreCase(login)) { return user;
	 * 
	 * } } return null; }
	 * 
	 * public int saveUser(User user) { users.add(user); return 1; }
	 * 
	 * public void deleteUser(String login) { users.remove(getUserByLogin(login));
	 * 
	 * }
	 * 
	 * public boolean verifyUser(User user) { for (User verify : users) { if
	 * (verify.getLogin().equalsIgnoreCase(user.getLogin()) &&
	 * verify.getPassword().equals(user.getPassword())) { return true; } } return
	 * false; }
	 * 
	 * public List<User> getAll() { return users; }
	 * 
	 * public User getUserById(int id) { // TODO Auto-generated method stub return
	 * null; }
	 * 
	 * @Override public void deleteUser(int id) { // TODO Auto-generated method stub
	 * 
	 * }
	 */

	@Override
	public User getUserByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

}