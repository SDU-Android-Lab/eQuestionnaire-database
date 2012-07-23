/*
 * Util sdu.androidlab.isurvey.Data BaseData.java
 * 2012 2012-7-23 下午2:51:46
 * @author zhenzxie
 */
package sdu.androidlab.isurvey.Data;

import sdu.androidlab.isurvey.Database.SqlCallback;
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
	
	@Override
	public boolean save(SqlHelper helper, SqlCallback callback) {
	
		return false;
	}
	
}
