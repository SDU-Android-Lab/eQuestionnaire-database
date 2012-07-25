/*
 * Util sdu.androidlab.isurvey.Data Administor.java
 * 2012 2012-7-24 涓嬪崍6:24:11
 * @author zhenzxie
 */
package sdu.androidlab.isurvey.Data;

import sdu.androidlab.isurvey.Database.annotation.Column;
import sdu.androidlab.isurvey.Database.annotation.Table;


/**
 * @author zhenzxie
 *
 */
@Table(name = "administor")
public class Administor extends BaseData {
	
	@Column(name = "aid")
	public Integer aid;
	@Column(name = "aname")
	public String aname;
	@Column(name = "apassword")
	public String apassword;
	@Column(name = "adepartment")
	public String adepartment;// 绠＄悊鍛橀儴闂�
	@Column(name = "apost")
	public String apost;// 绠＄悊鍛樿亴浣�
	@Column(name = "salary")
	public Double salary;
	@Column(name = "atell")
	public String atell;
	
	public Administor() {
	
	}
	
	/**
	 * 
	 * @param aid
	 * @param apassword
	 */
	public Administor(Integer aid, String apassword) {
	
		this.aid = aid;
		this.apassword = apassword;
	}

	/**
	 * 
	 * @param aid
	 * @param aname
	 * @param apassword
	 */
	public Administor(Integer aid, String aname, String apassword) {
	
		this.aid = aid;
		this.aname = aname;
		this.apassword = apassword;
	}

	/**
	 * @param aid
	 * @param aname
	 * @param apassword
	 * @param adepartment
	 * @param apost
	 * @param salary
	 * @param atell
	 */
	public Administor(Integer aid, String aname, String apassword,
			String adepartment, String apost, Double salary, String atell) {
	
		this.aid = aid;
		this.aname = aname;
		this.apassword = apassword;
		this.adepartment = adepartment;
		this.apost = apost;
		this.salary = salary;
		this.atell = atell;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
	
		return "Administor [aid=" + aid + ", aname=" + aname + ", apassword="
				+ apassword + ", adepartment=" + adepartment + ", apost="
				+ apost + ", salary=" + salary + ", atell=" + atell + "]";
	}

}
