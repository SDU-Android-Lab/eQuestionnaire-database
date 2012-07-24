/*
 * Util sdu.androidlab.isurvey.Data Data.java
 * 2012 2012-7-22 下午3:13:52
 * @author zhenzxie
 */
package sdu.androidlab.isurvey.Data;

import java.sql.ResultSet;

import sdu.androidlab.isurvey.Database.SqlCallback;
import sdu.androidlab.isurvey.Database.SqlHelper;

/**
 * @author zhenzxie
 * 
 */
public interface Data {
	
	/**
	 * get the value of this data
	 * 
	 * @param key
	 *            must be a field name of data
	 * @return value
	 */
	public Object valueOfKey(SqlHelper helper, String key);
	
	/**
	 * get the values of this data
	 * 
	 * @param keys
	 * @return
	 */
	public Object[] valuesOfkeys(SqlHelper helper, String[] keys);

	/**
	 * get the value from ResultSet to fill this data
	 * 
	 * @param resultSet
	 * @return true if this operation done,false otherwise;
	 */
	public boolean fillData(final ResultSet resultSet);

	/**
	 * save this data,write it to database;
	 * 
	 * @param helper
	 * @return
	 */
	public void save(SqlHelper helper, SqlCallback callback);
	
	public void updata(SqlHelper helper, SqlCallback callback);
	
	public void delete(SqlHelper helper, SqlCallback callback);
	
	public void query(SqlHelper helper, SqlCallback callback);
	
	public boolean save(SqlHelper helper);
	
	public boolean updata(SqlHelper helper);
	
	public boolean delete(SqlHelper helper);

	public boolean isExist(SqlHelper helper);

}
