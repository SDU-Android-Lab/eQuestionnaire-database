/*
 * DatabaseApp sdu.androidlab.isurvey.DataModel
 * 2012 2012-7-26 ÏÂÎç9:37:16
 * @author zhenzxie
 */
package sdu.androidlab.isurvey.DataModel;

import java.util.ArrayList;
import java.util.List;

import sdu.androidlab.isurvey.Data.Data;
import sdu.androidlab.isurvey.Data.Personnel;
import sdu.androidlab.isurvey.Database.SqlCallbackAdapter;
import sdu.androidlab.isurvey.Database.SqlHelper;
import sdu.androidlab.isurvey.UI.BaseFrame;


/**
 * @author zhenzxie
 *
 */
public class PersonnelManager extends BaseDataModel {
	
	private List<Data> personnel;
	private ArrayList<Personnel> add;
	private ArrayList<Personnel> delete;
	
	public PersonnelManager(BaseFrame baseFrame) {
	
		super(baseFrame);
	}
	
	public void initManager() {
	
		SqlHelper helper = new SqlHelper();
		helper.query(new Personnel(), new SqlCallbackAdapter() {
			
			/**
			 * @see sdu.androidlab.isurvey.Database.SqlCallbackAdapter#onQueryComplete(java.util.List)
			 */
			@Override
			public void onQueryComplete(List<Data> dataList) {
			
				if (dataList == null) {
					System.out.println("PersonnelManager: datalist is null");
				}
				personnel = dataList;
				notifyDataChange();
			}
		});
	}

	/**
	 * @return the personnel
	 */
	public List<Data> getPersonnel() {
	
		return personnel;
	}
	
	/**
	 * @param personnel
	 *            the personnel to set
	 */
	public void setPersonnel(List<Data> personnel) {
	
		this.personnel = personnel;
	}
	
	/**
	 * @return the add
	 */
	public ArrayList<Personnel> getAdd() {
	
		return add;
	}
	
	/**
	 * @param add
	 *            the add to set
	 */
	public void setAdd(ArrayList<Personnel> add) {
	
		this.add = add;
	}
	
	/**
	 * @return the delete
	 */
	public ArrayList<Personnel> getDelete() {
	
		return delete;
	}
	
	/**
	 * @param delete
	 *            the delete to set
	 */
	public void setDelete(ArrayList<Personnel> delete) {
	
		this.delete = delete;
	}
	
}
