package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Role;
import model.User;

public class JdbcDaoImpl implements UserDao {

	public User getUserById(int id) {
		String sql = "select users.id,name,surname,age,email,login,password,role from users join authenticate a on users.id = a.id join users_roles ur on users.id = ur.user_id  left join roles r on ur.role_id = r.id where users.id="
				+ id;
		User user = null;
		try (Connection cn = DatabaseConnection.getInstance().getConnection();
				Statement st = cn.createStatement();
				ResultSet rs = st.executeQuery(sql)) {
			if (rs.next()) {
				user = new User(rs.getString("name"), rs.getString("surname"), rs.getInt("age"), rs.getString("email"),
						rs.getString("login"), rs.getString("password"), model.Role.valueOf(rs.getString("role")));
				user.setId(rs.getInt("id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	public int saveUser(User user) {
		int i = 0;
		int k = 2;
		if (user.getRole() == Role.ADMIN) {
			k = 1;
		}
		String sql1 = "insert into users (name,surname,age,email) values(?,?,?,?)";
		String sql2 = "insert into authenticate (id,login,password,profile_enable) values (?,?,?,?)";
		String sql3 = "select*from users where email =(?)";
		String sql4 = "insert into users_roles (user_id,role_id) values (?,?)";
		try (Connection cn = DatabaseConnection.getInstance().getConnection();
				PreparedStatement st = cn.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
				PreparedStatement st1 = cn.prepareStatement(sql2);
				PreparedStatement st2 = cn.prepareStatement(sql3);
				PreparedStatement st3 = cn.prepareStatement(sql4)) {
			try {
				cn.setAutoCommit(false);
				st.setString(1, user.getName());
				st.setString(2, user.getSurname());
				st.setInt(3, user.getAge());
				st.setString(4, user.getEmail());
				i = st.executeUpdate();
				if (i != 0) {
					ResultSet rs = st.getGeneratedKeys();
					if (rs.next()) {
						user.setId(rs.getInt(1));
						System.out.println(user.getId());
					}
				}
				/*
				 * st2.setString(1, user.getEmail()); ResultSet rs = st2.executeQuery(); if
				 * (rs.next()) { rs.getInt("id"); user.setId(rs.getInt("id")); }
				 */
				st1.setInt(1, user.getId());
				st1.setString(2, user.getLogin());
				st1.setString(3, user.getPassword());
				st1.setBoolean(4, user.isProfile_enable());
				i = st1.executeUpdate();

				st3.setInt(1, user.getId());
				st3.setInt(2, k);
				st3.executeUpdate();
				cn.commit();
			} catch (Exception e) {
				cn.rollback();
			}
		} catch (Exception e)

		{
			e.printStackTrace();
		}
		return i;
	}

	public void deleteUser(int id) {
		String sql = "delete from users where id=" + id;
		String sql1 = "delete from authenticate where id=" + id;
		String sql2 = "delete from users_roles where user_id=" + id;
		try (Connection cn = DatabaseConnection.getInstance().getConnection(); Statement st = cn.createStatement();) {
			cn.setAutoCommit(false);
			st.addBatch(sql);
			st.addBatch(sql1);
			st.addBatch(sql2);
			st.executeBatch();
			cn.commit();
		} catch (Exception e)

		{
			e.printStackTrace();
		}

	}

	public boolean verifyUser(String login, String password) {

		String pass;
		String sql = "select login, password from authenticate where login=(?)";
		try (Connection cn = DatabaseConnection.getInstance().getConnection();
				PreparedStatement st = cn.prepareStatement(sql)) {

			st.setString(1, login);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				pass = rs.getString("password");
				if (pass.equals(password)) {
					return true;
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<User> getAll() {
		List<User> users = new ArrayList<User>();
		String sql = "select users.id,name,surname,age,email,login,password,profile_enable,role from users join authenticate a on users.id = a.id join users_roles ur on users.id = ur.user_id  left join roles r on ur.role_id = r.id";
		try (Connection cn = DatabaseConnection.getInstance().getConnection();
				Statement st = cn.createStatement();
				ResultSet rs = st.executeQuery(sql)) {
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setSurname(rs.getString("surname"));
				user.setAge(rs.getInt("age"));
				user.setEmail(rs.getString("email"));
				user.setLogin(rs.getString("login"));
				user.setPassword(rs.getString("password"));
				user.setRole(Role.valueOf(rs.getString("role")));
				user.setProfile_enable(rs.getBoolean("profile_enable"));
				users.add(user);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return users;
	}

	public boolean verifyEmail(String email) {
		String sql = "Select * from users where email='" + email + "'";
		try (Connection cn = DatabaseConnection.getInstance().getConnection();
				Statement st = cn.createStatement();
				ResultSet rs = st.executeQuery(sql)) {
			if (rs.next()) {
				if (rs.getString("email").equals(email))
					return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	public boolean verifyLogin(String login) {
		String sql = "Select * from authenticate where login='" + login + "'";
		try (Connection cn = DatabaseConnection.getInstance().getConnection();
				Statement st = cn.createStatement();
				ResultSet rs = st.executeQuery(sql)) {
			if (rs.next()) {
				if (rs.getString("login").equalsIgnoreCase(login))
					return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	public void updateUser(User user) {
		int k = 2;
		if (user.getRole() == Role.ADMIN) {
			k = 1;
		}
		String sql1 = "update  users set name=(?),surname=(?),age=(?),email=(?) where id=(?)";
		String sql2 = "update  authenticate set login=(?),password=(?),profile_enable=(?) where id=(?)";
		String sql3 = "update  users_roles set role_id=(?) where user_id=(?)";
		try (Connection cn = DatabaseConnection.getInstance().getConnection();
				PreparedStatement st = cn.prepareStatement(sql1);
				PreparedStatement st1 = cn.prepareStatement(sql2);
				PreparedStatement st2 = cn.prepareStatement(sql3);) {
			st.setString(1, user.getName());
			st.setString(2, user.getSurname());
			st.setInt(3, user.getAge());
			st.setString(4, user.getEmail());
			st.setInt(5, user.getId());
			st.executeUpdate();
			st1.setString(1, user.getLogin());
			st1.setString(2, user.getPassword());
			st1.setBoolean(3, user.isProfile_enable());
			st1.setInt(4, user.getId());
			st1.executeUpdate();
			st2.setInt(1, k);
			st2.setInt(2, user.getId());
			st2.executeUpdate();
		} catch (Exception e)

		{
			e.printStackTrace();
		}

	}

	@Override
	public User getUserByLogin(String login) {
		String sql = "select users.id,name,surname,age,email,login,password,profile_enable,role from users join authenticate a on users.id = a.id join users_roles ur on users.id = ur.user_id  left join roles r on ur.role_id = r.id where login='"
				+ login + "'";
		User user = new User();
		try (Connection cn = DatabaseConnection.getInstance().getConnection();
				Statement st = cn.createStatement();
				ResultSet rs = st.executeQuery(sql)) {
			if (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setSurname(rs.getString("surname"));
				user.setAge(rs.getInt("age"));
				user.setEmail(rs.getString("email"));
				user.setLogin(rs.getString("login"));
				user.setPassword(rs.getString("password"));
				user.setRole(Role.valueOf(rs.getString("role")));
				user.setProfile_enable(rs.getBoolean("profile_enable"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
