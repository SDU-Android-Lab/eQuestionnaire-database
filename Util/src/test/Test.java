/*
 * Util test Test.java
 * 2012 2012-7-20 下午3:23:46
 * @author zhenzxie
 */
package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author zhenzxie
 * 
 */
public class Test {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost/eQuestionnaire?user=sduxzz&password=9jmoj8&useUnicode=true&characterEncoding=8859_1";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			Statement s = conn.createStatement();
			boolean is = s.execute("select * from client");
			if (is) {
				ResultSet set = s.getResultSet();
				if (set.first()) {
					do {
						System.out.println(set.getObject("cname"));
					} while (set.next());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
