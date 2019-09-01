package com.arya.spring.model;

public class User {

	private String userName;
	
	private String password;
	
	private String adminRights;
	
	private boolean flag;

	
	public User() {}

	public User(String userName, String password, String adminRights, boolean flag) {
		super();
		this.userName = userName;
		this.password = password;
		this.adminRights = adminRights;
		this.flag = flag;
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

	public String getAdminRights() {
		return adminRights;
	}

	public void setAdminRights(String adminRights) {
		this.adminRights = adminRights;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", adminRights=" + adminRights + ", flag="
				+ flag + "]";
	}

}
