/*
 * Util sdu.androidlab.isurvey.Database SqlCallback.java
 * 2012 2012-7-22 下午9:47:22
 * @author zhenzxie
 */
package sdu.androidlab.isurvey.Database;

import java.sql.ResultSet;

/**
 * @author zhenzxie
 *
 */
public interface SqlCallback {
	
	public void onInsertComplete();
	
	public void onUpdataComplete();
	
	public void onQueryComplete();
	
	public void onDeleteComplete();
	
	public void onSqlExecuteComplete(ResultSet resultSet);

	public void onError(SqlError error);

}
