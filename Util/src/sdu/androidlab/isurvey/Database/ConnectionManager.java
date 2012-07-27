/*
 * Util sdu.androidlab.isurvey.Database ConnectionManager.java
 * 2012 2012-7-22 下午9:11:01
 * @author zhenzxie
 */
package sdu.androidlab.isurvey.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author zhenzxie
 * 
 */
public class ConnectionManager {
	
	static Connection connection = null;

	private ConnectionManager() {
	
	}
	
	public static Connection getConnection() {
	
		if (connection != null)
			return connection;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = "jdbc:mysql://localhost/eQuestionnaire?user=sduxzz&password=9jmoj8&useUnicode=true&characterEncoding=8859_1";

		try {
			connection = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

	public static void close(Connection connection, Statement statement) {
	
		try {
			statement.close();
			// connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void close(Connection connection, Statement statement,
			ResultSet resultSet) {
	
		try {
			resultSet.close();
			statement.close();
			// connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}