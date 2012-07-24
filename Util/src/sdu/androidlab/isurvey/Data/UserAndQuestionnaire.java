/*
 * Util sdu.androidlab.isurvey.Data UserAndQuestionnaire.java
 * 2012 2012-7-24 下午6:39:02
 * @author zhenzxie
 */
package sdu.androidlab.isurvey.Data;

import sdu.androidlab.isurvey.Database.annotation.Column;
import sdu.androidlab.isurvey.Database.annotation.Table;

/**
 * @author zhenzxie
 *
 */
@Table(name = "user_has_questionnaire")
public class UserAndQuestionnaire extends BaseData {
	
	@Column(name = "user_uname")
	public String user_uname;
	@Column(name = "questionnaire_qid")
	public String questionnaire_qid;
	@Column(name = "count")
	public Integer count;
	
	/**
	 * 
	 */
	public UserAndQuestionnaire() {
	
		super();
	}
	
	/**
	 * @param user_uname
	 * @param questionnaire_qid
	 * @param count
	 */
	public UserAndQuestionnaire(String user_uname, String questionnaire_qid,
			Integer count) {
	
		super();
		this.user_uname = user_uname;
		this.questionnaire_qid = questionnaire_qid;
		this.count = count;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
	
		return "UserAndQuestionnaire [user_uname=" + user_uname
				+ ", questionnaire_qid=" + questionnaire_qid + ", count="
				+ count + "]";
	}
}
