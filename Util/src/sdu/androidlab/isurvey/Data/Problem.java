package sdu.androidlab.isurvey.Data;

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
	public Long pid;
	@Column(name = "type")
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
	public Long questionnaire_qid;

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

}
