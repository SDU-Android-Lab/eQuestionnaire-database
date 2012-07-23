/*
 * Util test Test.java
 * 2012 2012-7-20 下午3:23:46
 * @author zhenzxie
 */
package test;

import java.sql.ResultSet;

import sdu.androidlab.isurvey.Data.Data;
import sdu.androidlab.isurvey.Data.User;
import sdu.androidlab.isurvey.Database.SqlCallback;
import sdu.androidlab.isurvey.Database.SqlError;
import sdu.androidlab.isurvey.Database.SqlHelper;


/**
 * @author zhenzxie
 * 
 */
public class Test {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		SqlHelper helper = new SqlHelper();
		Data data = new User("zhenzddd", "123456", "1234567", "fujian",
				"quanzhou", "kengzikou", "12345", 100);
		data.save(helper, new SqlCallback() {
			
			@Override
			public void onUpdataComplete() {
			
			}
			
			@Override
			public void onSqlExecuteComplete(ResultSet resultSet) {
			
			}
			
			@Override
			public void onQueryComplete() {
			
			}
			
			@Override
			public void onInsertComplete() {
			
				System.out.println("fadfa");
			}
			
			@Override
			public void onError(SqlError error) {
			
				error.exception.printStackTrace();
			}
			
			@Override
			public void onDeleteComplete() {
			
			}
		});
	}
	
}
