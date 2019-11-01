package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.User;

public class JdbcDaoImpl implements UserDao {
	public Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:h2:/Users/sergeilevchenko/Downloads/database", "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public Statement createStatement() {
		Statement statement = null;
		try {
			statement = getConnection().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return statement;
	}

	public void closeConnection(Connection connection, Statement statement, ResultSet rs) {
		try {
			rs.close();
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public User getUserByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveUser(User user) {
		try {
			createStatement().executeUpdate("Insert into users (name,surname,age,email) values (" + user.getName() + ","
					+ user.getSurname() + "," + user.getAge() + "," + user.getEmail() + ")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteUser(String login) {
		// TODO Auto-generated method stub

	}

	public boolean verifyUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
