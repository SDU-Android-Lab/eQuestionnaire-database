/*
 * Util sdu.androidlab.isurvey.Database SqlHelper.java
 * 2012 2012-7-22 下午4:03:40
 * @author zhenzxie
 */
package sdu.androidlab.isurvey.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import sdu.androidlab.isurvey.Data.Data;

/**
 * @author zhenzxie
 * 
 */
public class SqlHelper {
	
	static Executor executor = Executors.newFixedThreadPool(10);
	
	public void insert(final Data data, final SqlCallback callback) {
	
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
			
				String tableName = null;
				String sql = "insert into " + tableName + " values(" + ");";
				Connection connection = ConnectionManager.getConnection();
				PreparedStatement statement = null;
				try {
					statement = connection.prepareStatement(sql);
					statement.execute();
				} catch (SQLException e) {
					callback.onError(new SqlError(e));
				} finally {
					ConnectionManager.close(connection, statement);
				}

			}
		};
		execute(runnable);
	}

	public void execute(final String sql, final SqlCallback callback) {
	
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
			
				Connection connection = ConnectionManager.getConnection();
				Statement statement = null;
				ResultSet resultSet = null;
				try {
					statement = connection.createStatement();
					statement.executeQuery(sql);
					resultSet = statement.getResultSet();
					callback.onSqlExecuteComplete(resultSet);
				} catch (SQLException e) {
					callback.onError(new SqlError(e));
				} finally {
					ConnectionManager.close(connection, statement, resultSet);
				}
			}
		};
		
		execute(runnable);
	}
	
	private void execute(Runnable runnable) {
	
		executor.execute(runnable);
	}

}