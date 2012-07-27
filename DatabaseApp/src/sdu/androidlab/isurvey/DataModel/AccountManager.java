/*
 * DatabaseApp sdu.androidlab.isurvey.DataModel
 * 2012 2012-7-26 ÏÂÎç1:26:51
 * @author zhenzxie
 */
package sdu.androidlab.isurvey.DataModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import sdu.androidlab.isurvey.UI.BaseFrame;

/**
 * @author zhenzxie
 *
 */
public class AccountManager extends BaseDataModel {
	
	private ArrayList<Account> list;

	public AccountManager(BaseFrame baseFrame) {
	
		super(baseFrame);
	}
	
	@SuppressWarnings("unchecked")
	public void initAllAccount() {
	
		File file = new File("account.is");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		ArrayList<Account> object = null;
		ObjectInputStream input = null;
		try {
			FileInputStream fiStream = new FileInputStream(file);
			input = new ObjectInputStream(fiStream);
			object = (ArrayList<Account>)input.readObject();
			input.close();
		} catch (Exception e) {
			object = new ArrayList<Account>();
			e.printStackTrace();
			if (input != null) {
				try {
					input.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		list = object;
		super.notifyDataChange();
	}
	
	public ArrayList<Account> getAllAccounts() {
	
		return list;
	}
	
	public int checkAccount(Integer account) {
	
		int len = list.size();
		for (int i = 0; i < len; i++) {
			if (list.get(i).getAccount().equals(account)) {
				return i;
			}
		}
		return -1;
	}

	public void addAccount(Integer account, String password) {

		int i = checkAccount(account);
		if (i >= 0) {
			list.get(i).setPassword(password);
		}
		list.add(new Account(account, password));
	}

	public void saveAllAccount() {
	
		File file = new File("account.is");
		if (file.exists()) {
			file.delete();
		}
		ObjectOutputStream output = null;
		try {
			FileOutputStream fiStream = new FileOutputStream(file);
			output = new ObjectOutputStream(fiStream);
			output.writeObject(list);
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
			if (output != null) {
				try {
					output.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	public String getPassword(int position) {
	
		if (position >= list.size()) {
			System.out.println("AccountManager: return a null password");
			return null;
		} else {
			Account account = list.get(position);
			return account.getPassword();
		}
	}

}
