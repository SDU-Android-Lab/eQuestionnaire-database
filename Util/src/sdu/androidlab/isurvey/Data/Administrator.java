/*
 * Util sdu.androidlab.isurvey.Data Administor.java
 * 2012 2012-7-24 涓嬪崍6:24:11
 * @author zhenzxie
 */
package sdu.androidlab.isurvey.Data;

import java.sql.ResultSet;
import java.sql.SQLException;

import sdu.androidlab.isurvey.Database.SqlHelper;
import sdu.androidlab.isurvey.Database.annotation.Column;
import sdu.androidlab.isurvey.Database.annotation.Table;


/**
 * @author zhenzxie
 *
 */
@Table(name = "administor")
public class Administrator extends BaseData {
	
	@Column(name = "aid")
	public int aid;

	@Column(name = "aname")
	public String aname;

	@Column(name = "apassword")
	public String apassword;

	@Column(name = "adepartment")
	public String adepartment;// 绠＄悊鍛橀儴闂�

	@Column(name = "apost")
	public String apost;// 绠＄悊鍛樿亴浣�

	@Column(name = "salary")
	public double salary;

	@Column(name = "atell")
	public String atell;
	
	public Administrator() {
	
	}
	
	/**
	 * 
	 * @param aid
	 * @param apassword
	 */
	public Administrator(Integer aid, String apassword) {
	
		this.aid = aid;
		this.apassword = apassword;
	}

	/**
	 * 
	 * @param aid
	 * @param aname
	 * @param apassword
	 */
	public Administrator(Integer aid, String aname, String apassword) {
	
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
	public Administrator(Integer aid, String aname, String apassword,
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
	 * @see sdu.androidlab.isurvey.Data.BaseData#isExist(sdu.androidlab.isurvey.Database.SqlHelper)
	 */
	@Override
	public boolean isExist(SqlHelper helper) {
	
		System.out.println(this);
		return helper.isExist(this);
	}
	
	/**
	 * @see sdu.androidlab.isurvey.Data.BaseData#fillData(java.sql.ResultSet)
	 */
	@Override
	public boolean fillData(final ResultSet resultSet) {
	
		boolean done = true;
		try {
			this.aid = Integer.parseInt(resultSet.getString("aid"));
			this.aname = resultSet.getString("aname");
			this.apassword = resultSet.getString("apassword");
			this.adepartment = resultSet.getString("adepartment");
			this.apost = resultSet.getString("apost");
			this.salary = Double.parseDouble(resultSet.getString("salary"));
			this.atell = resultSet.getString("atell");
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
			done = false;
		}
		System.out.println("Administrator " + this.toString());
		return done;
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
