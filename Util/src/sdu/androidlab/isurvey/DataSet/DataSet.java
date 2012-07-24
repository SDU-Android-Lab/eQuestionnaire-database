/*
 * Util sdu.androidlab.isurvey.DataSet DataSet.java
 * 2012 2012-7-22 下午4:04:43
 * @author zhenzxie
 */
package sdu.androidlab.isurvey.DataSet;

import java.util.List;

import sdu.androidlab.isurvey.Data.Data;
import sdu.androidlab.isurvey.Database.SqlHelper;


/**
 * @author zhenzxie 这个接口好像不太需要。。。
 */
public interface DataSet {
	
	public boolean save(SqlHelper helper);

	public void add(Data data);
	
	public void add(List<Data> dataList);

	public Data get(int position);
	
	public List<Data> get();
}
