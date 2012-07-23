/*
 * Util sdu.androidlab.isurvey.Database ConnectionManager.java
 * 2012 2012-7-22 下午9:11:01
 * @author zhenzxie
 */
package sdu.androidlab.isurvey.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * @author zhenzxie
 *
 */
public class ConnectionManager {
	
	private ConnectionManager() {
	
	}
	
	public static Connection getConnection() {
	
		return null;
	}

	public static void close(Connection connection, Statement statement) {
	
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void close(Connection connection, Statement statement,
			ResultSet resultSet) {
	
		try {
			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}