package entity;

import java.io.Serializable;

public class User implements Serializable{
	
	private int userNo;
	private String userName;
	private String pass;
	
	public User() {
		
	}
	
	public User(int userNo, String userName, String pass) {
		this.userNo = userNo;
		this.userName = userName;
		this.pass = pass;
	}
	
	public User(int userNo, String userName) {
		this.userName = userName;
	}
	
	public User(String userName, String pass) {
		this.userName = userName;
		this.pass = pass;
	}
	
	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
