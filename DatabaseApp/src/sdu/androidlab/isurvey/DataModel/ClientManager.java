/*
 * DatabaseApp sdu.androidlab.isurvey.DataModel
 * 2012 2012-7-26 ÏÂÎç10:11:09
 * @author zhenzxie
 */
package sdu.androidlab.isurvey.DataModel;

import java.util.List;

import sdu.androidlab.isurvey.Data.Client;
import sdu.androidlab.isurvey.Data.Data;
import sdu.androidlab.isurvey.Database.SqlCallbackAdapter;
import sdu.androidlab.isurvey.Database.SqlHelper;
import sdu.androidlab.isurvey.UI.BaseFrame;

/**
 * @author zhenzxie
 *
 */
public class ClientManager extends BaseDataModel {
	
	private List<Data> client;

	public ClientManager(BaseFrame baseFrame) {
	
		super(baseFrame);
	}
	
	public void initManager() {
	
		SqlHelper helper = new SqlHelper();
		helper.query(new Client(), new SqlCallbackAdapter() {
			
			/**
			 * @see sdu.androidlab.isurvey.Database.SqlCallbackAdapter#onQueryComplete(java.util.List)
			 */
			@Override
			public void onQueryComplete(List<Data> dataList) {
			
				if (dataList == null) {
					System.out.println("ClientManager: datalist is null");
				}
				client = dataList;
				notifyDataChange();
			}
			
		});
	}
	
	/**
	 * @return the client
	 */
	public List<Data> getClient() {
	
		return client;
	}
	
	/**
	 * @param client
	 *            the client to set
	 */
	public void setClient(List<Data> client) {
	
		this.client = client;
	}

}
