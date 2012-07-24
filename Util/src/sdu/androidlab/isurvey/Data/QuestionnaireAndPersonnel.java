/*
 * Util sdu.androidlab.isurvey.Data QuestionnaireAndPersonnel.java
 * 2012 2012-7-24 下午6:36:20
 * @author zhenzxie
 */
package sdu.androidlab.isurvey.Data;

import sdu.androidlab.isurvey.Database.annotation.Column;
import sdu.androidlab.isurvey.Database.annotation.Table;

/**
 * @author zhenzxie
 * 
 */
@Table(name = "questionnaire_has_personnel")
public class QuestionnaireAndPersonnel extends BaseData {
	
	@Column(name = "questionnaire_qid")
	public Integer questionnaire_qid;
	@Column(name = "personnel_id")
	public Integer personnel_id;
	@Column(name = "count")
	public Integer count;
	
	/**
	 * 
	 */
	public QuestionnaireAndPersonnel() {
	
		super();
	}
	
	/**
	 * @param questionnaire_qid
	 * @param personnel_id
	 * @param count
	 */
	public QuestionnaireAndPersonnel(Integer questionnaire_qid,
			Integer personnel_id, Integer count) {
	
		super();
		this.questionnaire_qid = questionnaire_qid;
		this.personnel_id = personnel_id;
		this.count = count;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
	
		return "QuestionnaireAndPersonnel [questionnaire_qid="
				+ questionnaire_qid + ", personnel_id=" + personnel_id
				+ ", count=" + count + "]";
	}

}
