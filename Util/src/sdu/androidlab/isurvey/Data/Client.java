package sdu.androidlab.isurvey.Data;

import java.sql.ResultSet;
import java.sql.SQLException;

import sdu.androidlab.isurvey.Database.annotation.Column;
import sdu.androidlab.isurvey.Database.annotation.Table;

/**
 * 
 * @author zhenzxie
 * 
 */
@Table(name = "client")
public class Client extends BaseData {
	
	@Column(name = "cid")
	public long cid;
	@Column(name = "email")
	public String email;
	@Column(name = "password")
	public String password;
	@Column(name = "companyName")
	public String companyName;// 公司名
	@Column(name = "province")
	public String province;// 所在省份
	@Column(name = "city")
	public String city;// 城市
	@Column(name = "street")
	public String street;// 街道
	@Column(name = "phone")
	public String phone;// 联系电话
	@Column(name = "field")
	public String field;// 业务领域

	public Client() {
	
	}

	public Client(String email, String password, String companyName,
			String province, String city, String street, String phone,
			String field) {
		this.email = email;
		this.password = password;
		this.companyName = companyName;
		this.province = province;
		this.city = city;
		this.street = street;
		this.phone = phone;
		this.field = field;
	}

	/**
	 * @see sdu.androidlab.isurvey.Data.BaseData#fillData(java.sql.ResultSet)
	 */
	@Override
	public boolean fillData(ResultSet resultSet) {
	
		boolean done = true;
		
		try {
			this.cid = resultSet.getLong("cid");
			this.email = resultSet.getString("email");
			this.password = resultSet.getString("password");
			this.companyName = resultSet.getString("companyName");
			this.province = resultSet.getString("province");
			this.city = resultSet.getString("city");
			this.street = resultSet.getString("street");
			this.phone = resultSet.getString("phone");
			this.field = resultSet.getString("field");
		} catch (SQLException e) {
			e.printStackTrace();
			done = false;
		}
		System.out.println(this.toString());
		return done;
	}

	@Override
	public String toString() {
		return "Client [cid=" + cid + ", email=" + email + ", password="
				+ password + ", companyName=" + companyName + ", province="
				+ province + ", city=" + city + ", street=" + street
				+ ", phone=" + phone + ", field=" + field + "]";
	}

}
