/*
 * Util sdu.androidlab.isurvey.Data User.java
 * 2012 2012-7-23 下午2:52:12
 * @author zhenzxie
 */
package sdu.androidlab.isurvey.Data;

import java.sql.ResultSet;

import sdu.androidlab.isurvey.Database.SqlCallback;
import sdu.androidlab.isurvey.Database.SqlError;
import sdu.androidlab.isurvey.Database.SqlHelper;
import sdu.androidlab.isurvey.Database.annotation.Column;
import sdu.androidlab.isurvey.Database.annotation.Table;



/**
 * @author zhenzxie
 *
 */
@Table(name = "user")
public class User extends BaseData {
	
	@Column(name = "uid")
	int uid;
	@Column(name = "uname")
	String uname;
	@Column(name = "upassword")
	String upassword;
	@Column(name = "uemail")
	String uemail;
	@Column(name = "uprovince")
	String uprovince;
	@Column(name = "ucity")
	String ucity;
	@Column(name = "ustreet")
	String ustreet;
	@Column(name = "utell")
	String utell;
	@Column(name = "upoint")
	int point;
	
	public User() {
	
	}

	/**
	 * @param uid
	 * @param uname
	 * @param upassword
	 * @param uemail
	 * @param uprovince
	 * @param ucity
	 * @param ustreet
	 * @param utell
	 * @param point
	 */
	public User(int uid, String uname, String upassword, String uemail,
			String uprovince, String ucity, String ustreet, String utell,
			int point) {
	
		this.uid = uid;
		this.uname = uname;
		this.upassword = upassword;
		this.uemail = uemail;
		this.uprovince = uprovince;
		this.ucity = ucity;
		this.ustreet = ustreet;
		this.utell = utell;
		this.point = point;
	}

	/**
	 * @see sdu.androidlab.isurvey.Data.BaseData#save(sdu.androidlab.isurvey.Database.SqlHelper)
	 */
	@Override
	public boolean save(SqlHelper helper) {
	
		helper.insert(this, new usercall());
		return true;
	}
	
	/**
	 * @return the uid
	 */
	public int getUid() {
	
		return uid;
	}
	
	/**
	 * @param uid
	 *            the uid to set
	 */
	public void setUid(int uid) {
	
		this.uid = uid;
	}
	
	/**
	 * @return the uname
	 */
	public String getUname() {
	
		return uname;
	}
	
	/**
	 * @param uname
	 *            the uname to set
	 */
	public void setUname(String uname) {
	
		this.uname = uname;
	}
	
	/**
	 * @return the upassword
	 */
	public String getUpassword() {
	
		return upassword;
	}
	
	/**
	 * @param upassword
	 *            the upassword to set
	 */
	public void setUpassword(String upassword) {
	
		this.upassword = upassword;
	}
	
	/**
	 * @return the uemail
	 */
	public String getUemail() {
	
		return uemail;
	}
	
	/**
	 * @param uemail
	 *            the uemail to set
	 */
	public void setUemail(String uemail) {
	
		this.uemail = uemail;
	}
	
	/**
	 * @return the uprovince
	 */
	public String getUprovince() {
	
		return uprovince;
	}
	
	/**
	 * @param uprovince
	 *            the uprovince to set
	 */
	public void setUprovince(String uprovince) {
	
		this.uprovince = uprovince;
	}
	
	/**
	 * @return the ucity
	 */
	public String getUcity() {
	
		return ucity;
	}
	
	/**
	 * @param ucity
	 *            the ucity to set
	 */
	public void setUcity(String ucity) {
	
		this.ucity = ucity;
	}
	
	/**
	 * @return the ustreet
	 */
	public String getUstreet() {
	
		return ustreet;
	}
	
	/**
	 * @param ustreet
	 *            the ustreet to set
	 */
	public void setUstreet(String ustreet) {
	
		this.ustreet = ustreet;
	}
	
	/**
	 * @return the utell
	 */
	public String getUtell() {
	
		return utell;
	}
	
	/**
	 * @param utell
	 *            the utell to set
	 */
	public void setUtell(String utell) {
	
		this.utell = utell;
	}
	
	/**
	 * @return the point
	 */
	public int getPoint() {
	
		return point;
	}
	
	/**
	 * @param point
	 *            the point to set
	 */
	public void setPoint(int point) {
	
		this.point = point;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
	
		return "User [uid=" + uid + ", uname=" + uname + ", upassword="
				+ upassword + ", uemail=" + uemail + ", uprovince=" + uprovince
				+ ", ucity=" + ucity + ", ustreet=" + ustreet + ", utell="
				+ utell + ", point=" + point + "]";
	}

	class usercall implements SqlCallback {
		
		@Override
		public void onInsertComplete() {
		
			System.out.println("success");
		}
		
		@Override
		public void onUpdataComplete() {
		
		}
		
		@Override
		public void onQueryComplete() {
		
		}
		
		@Override
		public void onDeleteComplete() {
		
		}
		
		@Override
		public void onSqlExecuteComplete(ResultSet resultSet) {
		
		}
		
		@Override
		public void onError(SqlError error) {
		
			error.exception.printStackTrace();
		}
		
	}

}
