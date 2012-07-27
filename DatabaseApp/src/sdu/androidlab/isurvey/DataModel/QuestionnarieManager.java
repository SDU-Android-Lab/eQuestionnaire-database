/*
 * DatabaseApp sdu.androidlab.isurvey.DataModel
 * 2012 2012-7-26 ÏÂÎç10:03:38
 * @author zhenzxie
 */
package sdu.androidlab.isurvey.DataModel;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import sdu.androidlab.isurvey.Data.Data;
import sdu.androidlab.isurvey.Data.Questionnaire;
import sdu.androidlab.isurvey.Database.SqlCallbackAdapter;
import sdu.androidlab.isurvey.Database.SqlHelper;
import sdu.androidlab.isurvey.UI.BaseFrame;

/**
 * @author zhenzxie
 *
 */
public class QuestionnarieManager extends BaseDataModel implements Observer {
	
	private Long cid;
	private List<Data> list;
	private ProblemManager pManager;

	public QuestionnarieManager(BaseFrame baseFrame) {
	
		super(baseFrame);
		pManager = new ProblemManager(this);
	}
	
	public void initManager(Long cid) {
	
		this.cid = cid;
		Questionnaire questionnaire = new Questionnaire();
		questionnaire.client = cid;
		
		Class<Questionnaire> cl = Questionnaire.class;
		Field[] fields = new Field[1];
		try {
			fields[0] = cl.getDeclaredField("client");
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		
		SqlHelper helper = new SqlHelper();
		helper.query(questionnaire, fields, new SqlCallbackAdapter() {

			/**
			 * @see sdu.androidlab.isurvey.Database.SqlCallbackAdapter#onQueryComplete(java.util.List)
			 */
			@Override
			public void onQueryComplete(List<Data> dataList) {
			
				if (dataList == null) {
					System.out
					        .println("QuestionnaireManager: datalist is null");
				}
				list = dataList;
				notifyDataChange();
			}
		});
	}
	
	public void showProblem(Long qid) {
	
		pManager.setValues(qid);
	}

	/**
	 * @return the cid
	 */
	public Long getCid() {
	
		return cid;
	}
	
	/**
	 * @param cid
	 *            the cid to set
	 */
	public void setCid(Long cid) {
	
		this.cid = cid;
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

	/**
     * @return the pManager
     */
    public ProblemManager getpManager() {
    
	    return pManager;
    }

	/**
     * @param pManager the pManager to set
     */
    public void setpManager(ProblemManager pManager) {
    
	    this.pManager = pManager;
    }
	
	@Override
	public void update(Observable o, Object arg) {
	
		notifyDataChange();
	}
}
