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

	@Override
	public Object valueOfKey(SqlHelper helper, String key) {
	
		return null;
	}

	@Override
	public Object[] valuesOfkeys(SqlHelper helper, String[] keys) {
	
		return null;
	}

	@Override
	public void save(SqlHelper helper, SqlCallback callback) {
	
	}

	@Override
	public void updata(SqlHelper helper, SqlCallback callback) {
	
	}

	@Override
	public void delete(SqlHelper helper, SqlCallback callback) {
	
	}

	@Override
	public void query(SqlHelper helper, SqlCallback callback) {
	
	}
	
	@Override
	public void save(SqlHelper helper) {
	
	}
	
	@Override
	public void updata(SqlHelper helper) {
	
	}
	
	@Override
	public void delete(SqlHelper helper) {
	
	}
	
	@Override
	public void query(SqlHelper helper) {
	
	}
	
	@Override
	public boolean isExist(SqlHelper helper) {
	
		return false;
	}
	

}
