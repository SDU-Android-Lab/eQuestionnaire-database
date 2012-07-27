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
import java.io.Serializable;
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
		try {
			FileInputStream fiStream = new FileInputStream(file);
			ObjectInputStream input = new ObjectInputStream(fiStream);
			object = (ArrayList<Account>)input.readObject();
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
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
		try {
			FileOutputStream fiStream = new FileOutputStream(file);
			ObjectOutputStream output = new ObjectOutputStream(fiStream);
			output.writeObject(list);
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
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

	public class Account implements Serializable {
		
		/**
         * 
         */
		private static final long serialVersionUID = -401403377357376864L;
		Integer account;
		String password;
		
		public Account() {
		
			super();
		}
		
		public Account(Integer account, String password) {
		
			super();
			this.account = account;
			this.password = password;
		}
		
		/**
		 * @return the account
		 */
		public synchronized final Integer getAccount() {
		
			return account;
		}
		
		/**
		 * @param account
		 *            the account to set
		 */
		public synchronized final void setAccount(Integer account) {
		
			this.account = account;
		}
		
		/**
		 * @return the password
		 */
		public synchronized final String getPassword() {
		
			return password;
		}
		
		/**
		 * @param password
		 *            the password to set
		 */
		public synchronized final void setPassword(String password) {
		
			this.password = password;
		}
		
		/**
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
		
			return "Account [account=" + account + ", password=" + password
			        + "]";
		}

	}

}
