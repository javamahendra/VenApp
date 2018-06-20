package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="u_tab")
public class User {
	@Id
	@Column(name="u_id")
	@GeneratedValue(generator="u_seq",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="u_seq",sequenceName="user_seq")
	private int userId;
	@Column(name="u_name")
	private String userName;
	@Column(name="pwd")
	private String password;
	@Column(name="u_addr")
	private String address;
	@Column(name="u_email")
	private String emailId;
	@Column(name="u_contact")
	private String mobile;
	
	public User() {
	}
	
	public User(int userId) {
		this.userId = userId;
	}


	public User(int userId, String userName, String password, String address,
			String emailId, String mobile) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.emailId = emailId;
		this.mobile = mobile;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", password=" + password + ", address=" + address
				+ ", emailId=" + emailId + ", mobile=" + mobile + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
