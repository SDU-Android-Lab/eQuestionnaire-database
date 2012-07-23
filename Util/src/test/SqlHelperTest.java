/*
 * Util test SqlHelperTest.java
 * 2012 2012-7-23 下午2:43:33
 * @author zhenzxie
 */
package test;


import junit.framework.TestCase;

import org.junit.Test;

import sdu.androidlab.isurvey.Data.Data;
import sdu.androidlab.isurvey.Data.User;
import sdu.androidlab.isurvey.Database.SqlHelper;

/**
 * @author zhenzxie
 *
 */
public class SqlHelperTest extends TestCase {
	
	/**
	 * Test method for {@link sdu.androidlab.isurvey.Database.SqlHelper#insert(sdu.androidlab.isurvey.Data.Data, sdu.androidlab.isurvey.Database.SqlCallback)}.
	 */
	@Test
	public final void testInsert() {
	
		SqlHelper helper = new SqlHelper();
		Data data = new User(1, "zhenz", "123456", "1234567", "fujian",
				"quanzhou", "kengzikou", "12345", 100);
		data.save(helper);
	}
	
	/**
	 * Test method for {@link sdu.androidlab.isurvey.Database.SqlHelper#execute(java.lang.String, sdu.androidlab.isurvey.Database.SqlCallback)}.
	 */
	@Test
	public final void testExecute() {
	
		// fail("Not yet implemented"); // TODO
	}
	
}
