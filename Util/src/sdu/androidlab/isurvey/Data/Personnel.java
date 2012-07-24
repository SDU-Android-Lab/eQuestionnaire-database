/*
 * Util sdu.androidlab.isurvey.Data Personnel.java
 * 2012 2012-7-24 下午6:30:15
 * @author zhenzxie
 */
package sdu.androidlab.isurvey.Data;

import sdu.androidlab.isurvey.Database.annotation.Column;
import sdu.androidlab.isurvey.Database.annotation.Table;


/**
 * @author zhenzxie
 *
 */
@Table(name = "personnel")
public class Personnel extends BaseData {
	
	@Column(name = "id")
	public Integer id;
	@Column(name = "name")
	public String name;
	@Column(name = "password")
	public String password;
	@Column(name = "email")
	public String email;
	@Column(name = "province")
	public String province;
	@Column(name = "city")
	public String city;
	@Column(name = "street")
	public String street;
	@Column(name = "tell")
	public String tell;
	@Column(name = "salay")
	public Double salay;
	@Column(name = "administor_aid")
	public Integer administor_aid;
	
	public Personnel() {
	
	}

	public Personnel(Integer id, String password) {
	
		this.id = id;
		this.password = password;
	}
	
	public Personnel(Integer id, String name, String password) {
	
		this.id = id;
		this.name = name;
		this.password = password;
	}

	/**
	 * @param id
	 * @param name
	 * @param password
	 * @param email
	 * @param province
	 * @param city
	 * @param street
	 * @param tell
	 * @param salay
	 * @param administor_aid
	 */
	public Personnel(Integer id, String name, String password, String email,
			String province, String city, String street, String tell,
			Double salay, Integer administor_aid) {
	
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.province = province;
		this.city = city;
		this.street = street;
		this.tell = tell;
		this.salay = salay;
		this.administor_aid = administor_aid;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
	
		return "Personnel [id=" + id + ", name=" + name + ", password="
				+ password + ", email=" + email + ", province=" + province
				+ ", city=" + city + ", street=" + street + ", tell=" + tell
				+ ", salay=" + salay + ", administor_aid=" + administor_aid
				+ "]";
	}

}
