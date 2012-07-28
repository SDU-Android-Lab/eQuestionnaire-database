/*
 * DatabaseApp sdu.androidlab.isurvey.UI
 * 2012 2012-7-25 ÏÂÎç4:25:17
 * @author zhenzxie
 */
package sdu.androidlab.isurvey.UI;

/**
 * @author zhenzxie
 * 
 */
public final class UIFactory {
	
	private static AccountFrame accountFrame;
	
	private static AdministartorFrame adminitorFrame;
	
	private static ClientFrame clientFrame;
	
	private static PersonnelFrame personnelFrame;
	
	private static QuestionnaireFrame questionnaireFrame;

	private UIFactory() {
	
	}
	
	/**
	 * @return the accountFrame
	 */
	public static synchronized final AccountFrame getAccountFrame() {
	
		if (accountFrame == null) {
			accountFrame = new AccountFrame();
		}
		return accountFrame;
	}
	
	/**
	 * @return the adminitorFrame
	 */
	public static synchronized final AdministartorFrame getAdminitorFrame() {
	
		if (adminitorFrame == null) {
			adminitorFrame = new AdministartorFrame();
		}
		return adminitorFrame;
	}
	
	/**
	 * @return the clientFrame
	 */
	public static synchronized final ClientFrame getClientFrame() {
	
		if (clientFrame == null) {
			clientFrame = new ClientFrame();
		}
		return clientFrame;
	}
	
	/**
	 * @return the personnelFrame
	 */
	public static synchronized final PersonnelFrame getPersonnelFrame() {
	
		if (personnelFrame == null) {
			personnelFrame = new PersonnelFrame();
		}
		return personnelFrame;
	}

	public static QuestionnaireFrame getQuestionnaireFrame() {
	
		if (questionnaireFrame == null) {
			questionnaireFrame = new QuestionnaireFrame();
		}
		return questionnaireFrame;
	}

}