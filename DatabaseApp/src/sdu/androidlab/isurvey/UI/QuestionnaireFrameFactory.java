/*
 * DatabaseApp sdu.androidlab.isurvey.UI
 * 2012 2012-7-27 ионГ12:27:29
 * @author zhenzxie
 */
package sdu.androidlab.isurvey.UI;


/**
 * @author zhenzxie
 *
 */
public class QuestionnaireFrameFactory {
	
	public static QuestionnaireFrame createQuestionnaireFrame(Long qid) {
	
		QuestionnaireFrame questionnaireFrame = new QuestionnaireFrame(qid);
		questionnaireFrame.setVisible(true);
		questionnaireFrame.setBounds(10, 197, 732, 147);
		return questionnaireFrame;
	}
}
