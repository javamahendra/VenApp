package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cust_tab")
public class Customer {
	@Id
	@GeneratedValue
	@Column(name="c_id")
	private int custId;
	@Column(name="c_name")
	private String custName;
	@Column(name="c_mail")
	private String custEmail;
	@Column(name="c_type")
	private String custType;
	@Column(name="c_addr")
	private String custAddr;
	@Column(name="c_pwd")
	private String password;
	@Column(name="c_tock")
	private String accTock;
	
	public Customer() {
		super();
	}
	public Customer(int custId) {
		super();
		this.custId = custId;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public String getCustType() {
		return custType;
	}
	public void setCustType(String custType) {
		this.custType = custType;
	}
	public String getCustAddr() {
		return custAddr;
	}
	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccTock() {
		return accTock;
	}
	public void setAccTock(String accTock) {
		this.accTock = accTock;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName
				+ ", custEmail=" + custEmail + ", custType=" + custType
				+ ", custAddr=" + custAddr + ", password=" + password
				+ ", accTock=" + accTock + "]";
	}
	
	
	
}
