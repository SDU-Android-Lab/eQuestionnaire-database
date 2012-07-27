/*
 * DatabaseApp sdu.androidlab.isurvey.DataModel
 * 2012 2012-7-26 ÏÂÎç11:40:25
 * @author zhenzxie
 */
package sdu.androidlab.isurvey.DataModel;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import sdu.androidlab.isurvey.Data.Data;
import sdu.androidlab.isurvey.Data.Problem;
import sdu.androidlab.isurvey.Database.SqlCallbackAdapter;
import sdu.androidlab.isurvey.Database.SqlHelper;

/**
 * @author zhenzxie
 *
 */
public class ProblemManager extends Observable {
	
	private List<Data> list;
	
	public ProblemManager(Observer observer) {
	
		addObserver(observer);
	}
	
	public void setValues(Long qid) {
	
		Problem problem = new Problem();
		problem.questionnaire_qid = qid;
		
		SqlHelper helper = new SqlHelper();
		helper.query(problem, new SqlCallbackAdapter() {
			
			/**
			 * @see sdu.androidlab.isurvey.Database.SqlCallbackAdapter#onQueryComplete(java.util.List)
			 */
			@Override
			public void onQueryComplete(List<Data> dataList) {
			
				if (dataList == null) {
					System.out.println("ProblemManager: datalist is null");
				}
				list = dataList;
				notifyDataChange();
			}
			
		});
	}
	
	public void notifyDataChange() {
	
		this.setChanged();
		this.notifyObservers();
		this.clearChanged();
	}
	/**
	 * @return the list
	 */
	public List<Data> getList() {
	
		return list;
	}

	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(List<Data> list) {
	
		this.list = list;
	}
}
