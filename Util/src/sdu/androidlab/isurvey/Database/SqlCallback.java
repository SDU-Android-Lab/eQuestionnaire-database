/*
 * Util sdu.androidlab.isurvey.Database SqlCallback.java
 * 2012 2012-7-22 下午9:47:22
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
public interface SqlCallback {
	
	public void onInsertComplete();
	
	public void onUpdataComplete();
	
	public void onQueryComplete(List<Data> dataList);
	
	public void onQueryMultiTableComplete(List<HashMap<String, Object>> dataList);

	public void onDeleteComplete();
	
	public void onSqlExecuteComplete(final ResultSet resultSet);

	public void onError(SqlError error);

}
