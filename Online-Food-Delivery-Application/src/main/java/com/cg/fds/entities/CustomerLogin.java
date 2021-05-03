package com.cg.fds.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="customer_login")
public class CustomerLogin {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int userid;
	@NotEmpty(message = "Username should not be empty...")
	private String userName;
	@NotEmpty(message = "Password should not be empty...")
	@Size(min = 5,max = 10,message = "Password length should be between 5 and 10")
	private String password;
	
	public CustomerLogin() {
		super();
	}

	
	public CustomerLogin(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}


	public CustomerLogin(int userid, String userName, String password) {
		super();
		this.userid = userid;
		this.userName = userName;
		this.password = password;
	}


	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
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


	@Override
	public String toString() {
		return "CustomerLogin [userid=" + userid + ", userName=" + userName + ", password=" + password + "]";
	}
	
	
	
}
