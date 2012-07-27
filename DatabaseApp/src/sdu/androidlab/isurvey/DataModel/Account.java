/*
 * DatabaseApp sdu.androidlab.isurvey.DataModel
 * 2012 2012-7-27 ÏÂÎç2:04:03
 * @author zhenzxie
 */
package sdu.androidlab.isurvey.DataModel;

import java.io.Serializable;


/**
 * @author zhenzxie
 *
 */
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
	public Integer getAccount() {
	
		return account;
	}
	
	/**
	 * @param account
	 *            the account to set
	 */
	public void setAccount(Integer account) {
	
		this.account = account;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword() {
	
		return password;
	}
	
	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
	
		this.password = password;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
	
		return "Account [account=" + account + ", password=" + password + "]";
	}

}

