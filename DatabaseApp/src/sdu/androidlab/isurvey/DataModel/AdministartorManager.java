/*
 * DatabaseApp sdu.androidlab.isurvey.DataModel
 * 2012 2012-7-25 ÏÂÎç9:55:42
 * @author zhenzxie
 */
package sdu.androidlab.isurvey.DataModel;

import java.util.List;

import sdu.androidlab.isurvey.Data.Administrator;
import sdu.androidlab.isurvey.Data.Data;
import sdu.androidlab.isurvey.Database.SqlCallbackAdapter;
import sdu.androidlab.isurvey.Database.SqlHelper;
import sdu.androidlab.isurvey.UI.BaseFrame;

/**
 * @author zhenzxie
 *
 */
public class AdministartorManager extends BaseDataModel {
	
	private Administrator self;
	private Integer id;
	private List<Data> other;

	public AdministartorManager(BaseFrame baseFrame, Integer id) {
	
		super(baseFrame);
		this.id = id;
	}
	
	public void initAdminitors() {
		
		Administrator administor = new Administrator();
		administor.aid = id;
		System.out.println(administor.toString());
		
		SqlHelper helper = new SqlHelper();
		helper.query(administor, new SqlCallbackAdapter() {
			
			/**
			 * @see sdu.androidlab.isurvey.Database.SqlCallbackAdapter#onQueryComplete(java.util.List)
			 */
			@Override
			public void onQueryComplete(List<Data> dataList) {
			
				if (dataList == null) {
					System.out.println("AdminitorManager: datalist is null");
					return;
				}
				if (dataList.get(0) == null) {
					System.out
					        .println("AdminitorManager: datalist's adminitor is null");
					return;
				}
				self = (Administrator) dataList.get(0);
				notifyDataChange();
			}
		});
		
		helper.query(Administrator.class, new SqlCallbackAdapter() {
			
			/**
			 * @see sdu.androidlab.isurvey.Database.SqlCallbackAdapter#onQueryComplete(java.util.List)
			 */
			@Override
			public void onQueryComplete(List<Data> dataList) {
			
				if (dataList == null) {
					System.out.println("AdminitorManager: datalist is null");
				}
				other = dataList;
				notifyDataChange();
			}
		});
	}

	
	/**
	 * @return the self
	 */
	public Administrator getSelf() {
	
		return self;
	}
	
    /**
	 * @param self
	 *            the self to set
	 */
	public void setSelf(Administrator self) {
	
		this.self = self;
	}

	
    /**
	 * @return the id
	 */
	public Integer getId() {
	
		return id;
	}
	
	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
	
		this.id = id;
	}
	
    /**
	 * @return the other
	 */
	public List<Data> getOther() {
	
		return other;
	}
	
    /**
	 * @param other
	 *            the other to set
	 */
	public void setOther(List<Data> other) {
	
		this.other = other;
	}
	

}
