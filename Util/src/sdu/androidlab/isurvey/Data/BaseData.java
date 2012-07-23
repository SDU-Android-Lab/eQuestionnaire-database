/*
 * Util sdu.androidlab.isurvey.Data BaseData.java
 * 2012 2012-7-23 下午12:21:15
 * @author zhenzxie
 */
package sdu.androidlab.isurvey.Data;

import sdu.androidlab.isurvey.Database.SqlHelper;


/**
 * @author zhenzxie
 *
 */
public class BaseData implements Data {
	
	/**
	 * @see sdu.androidlab.isurvey.Data.Data#valueOfKey(sdu.androidlab.isurvey.Database.SqlHelper, java.lang.String)
	 */
	@Override
	public Object valueOfKey(SqlHelper helper, String key) {
	
		return null;
	}
	
	/**
	 * @see sdu.androidlab.isurvey.Data.Data#valuesOfkeys(sdu.androidlab.isurvey.Database.SqlHelper, java.lang.String[])
	 */
	@Override
	public Object[] valuesOfkeys(SqlHelper helper, String[] keys) {
	
		return null;
	}
	
	/**
	 * @see sdu.androidlab.isurvey.Data.Data#save(sdu.androidlab.isurvey.Database.SqlHelper)
	 */
	@Override
	public boolean save(SqlHelper helper) {
	
		return false;
	}
	
}
