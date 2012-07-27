package sdu.androidlab.isurvey.Data;

import java.sql.ResultSet;
import java.sql.SQLException;

import sdu.androidlab.isurvey.Database.annotation.Column;
import sdu.androidlab.isurvey.Database.annotation.Table;

/**
 * 
 * @author zhenzxie
 * 
 */
@Table(name = "problem")
public class Problem extends BaseData {
	
	@Column(name = "pid")
	public long pid;
	@Column(name = "ptype")
	// TODO:change this to type
	public Integer type;// 问题类型，选择题还是简答题
	@Column(name = "content")
	public String content;
	@Column(name = "choiceSize")
	public Integer choiceSize;
	@Column(name = "image")
	public String image;// 图片的路径
	@Column(name = "audio")
	public String audio;// 音频的路径
	@Column(name = "questionnaire_qid")
	public long questionnaire_qid;

	public Problem() {
	
	}

	public Problem(Integer type, String content, Integer choiceSize,
			String image, String audio, Long questionnaire) {
		this.type = type;
		this.content = content;
		this.choiceSize = choiceSize;
		this.image = image;
		this.audio = audio;
		this.questionnaire_qid = questionnaire;
	}

	/**
	 * @see sdu.androidlab.isurvey.Data.BaseData#fillData(java.sql.ResultSet)
	 */
	@Override
	public boolean fillData(ResultSet resultSet) {
	
		boolean done = true;
		try {
			this.pid = resultSet.getLong("pid");
			this.questionnaire_qid = resultSet.getLong("questionnaire_qid");
			this.content = resultSet.getString("content");
			this.type = resultSet.getInt("ptype");// TODO:change this to type
			this.choiceSize = resultSet.getInt("choiceSize");
			this.image = resultSet.getString("image");
			this.audio = resultSet.getString("audio");
		} catch (SQLException e) {
			e.printStackTrace();
			done = false;
		}
		return done;
	}

}
