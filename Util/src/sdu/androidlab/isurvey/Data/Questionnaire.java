package sdu.androidlab.isurvey.Data;

import java.util.Date;

import sdu.androidlab.isurvey.Database.annotation.Column;
import sdu.androidlab.isurvey.Database.annotation.Table;

/**
 * 
 * @author zhenzxie
 * 
 */
@Table(name = "questionnaire")
public class Questionnaire extends BaseData {
	
	@Column(name = "qid")
	public Long qid;
	@Column(name = "client_cid")
	public Long client;
	@Column(name = "name")
	public String name;
	@Column(name = "createData")
	public Date createDate;// 创建日期
	@Column(name = "finishData")
	public Date finishDate;// 完成调查任务日期
	@Column(name = "template")
	public Integer template;// 使用的模版
	@Column(name = "sampleSize")
	public Integer sampleSize;// 调查样本数量
	@Column(name = "cost")
	public Double cost;// 价格
	@Column(name = "not")
	public String note;// 备注

	public Questionnaire() {
	
	}
	
	public Questionnaire(Long client, String name, Date finishDate,
			Integer template, Integer sampleSize, Double cost, String note) {
		this.client = client;
		this.name = name;
		this.createDate = new Date();
		this.finishDate = finishDate;
		this.template = template;
		this.sampleSize = sampleSize;
		this.cost = cost;
		this.note = note;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
	
		return "Questionnaire [qid=" + qid + ", client=" + client + ", name="
				+ name + ", createDate=" + createDate + ", finishDate="
				+ finishDate + ", template=" + template + ", sampleSize="
				+ sampleSize + ", cost=" + cost + ", note=" + note + "]";
	}

}
