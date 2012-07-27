/*
 * Util sdu.androidlab.isurvey.Database
 * 2012 2012-7-25 下午2:48:02
 * @author zhenzxie
 */
package sdu.androidlab.isurvey.Database;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;

import sdu.androidlab.isurvey.Data.Data;


/**
 * @author zhenzxie
 *
 */
public class SqlCallbackAdapter implements SqlCallback {
	
	/**
	 * @see sdu.androidlab.isurvey.Database.SqlCallback#onInsertComplete()
	 */
	@Override
	public void onInsertComplete() {
	
	}
	
	/**
	 * @see sdu.androidlab.isurvey.Database.SqlCallback#onUpdataComplete()
	 */
	@Override
	public void onUpdataComplete() {
	
	}
	
	/**
	 * @see sdu.androidlab.isurvey.Database.SqlCallback#onQueryComplete(java.util.List)
	 */
	@Override
	public void onQueryComplete(List<Data> dataList) {
	
	}
	
	/**
	 * @see sdu.androidlab.isurvey.Database.SqlCallback#onQueryMultiTableComplete(java.util.List)
	 */
	@Override
	public void onQueryMultiTableComplete(List<HashMap<String, Object>> dataList) {
	
	}
	
	/**
	 * @see sdu.androidlab.isurvey.Database.SqlCallback#onDeleteComplete()
	 */
	@Override
	public void onDeleteComplete() {
	
	}
	
	/**
	 * @see sdu.androidlab.isurvey.Database.SqlCallback#onSqlExecuteComplete(java.sql.ResultSet)
	 */
	@Override
	public void onSqlExecuteComplete(ResultSet resultSet) {
	
	}
	
	/**
	 * @see sdu.androidlab.isurvey.Database.SqlCallback#onError(sdu.androidlab.isurvey.Database.SqlError)
	 */
	@Override
	public void onError(SqlError error) {
	
		error.exception.printStackTrace();
	}
	
}
