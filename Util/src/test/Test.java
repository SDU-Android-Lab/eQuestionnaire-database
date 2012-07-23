/*
 * Util test Test.java
 * 2012 2012-7-20 下午3:23:46
 * @author zhenzxie
 */
package test;

import sdu.androidlab.isurvey.Data.Data;
import sdu.androidlab.isurvey.Data.User;
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
		Data data = new User(13, "zhenz", "123456", "1234567", "fujian",
				"quanzhou", "kengzikou", "12345", 100);
		// data.save(helper);
	}
	
}
