/*
 * DatabaseApp sdu.androidlab.isurvey.DataModel
 * 2012 2012-7-25 обнГ7:34:51
 * @author zhenzxie
 */
package sdu.androidlab.isurvey.DataModel;

import java.util.Observable;

import sdu.androidlab.isurvey.UI.BaseFrame;

/**
 * @author zhenzxie
 *
 */
public class BaseDataModel extends Observable {
	
	public BaseDataModel(BaseFrame baseFrame) {
	
		addObserver(baseFrame);
	}
	
	public void notifyDataChange() {
	
		this.setChanged();
		this.notifyObservers();
		this.clearChanged();
	}
	
	public void notifyDataChange(Object obj) {
	
		this.setChanged();
		this.notifyObservers(obj);
		this.clearChanged();
	}

}
