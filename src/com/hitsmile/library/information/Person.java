package com.hitsmile.library.information;

public class Person {
	
	private String userName;
	private String password;
	private int position;

	public Person(String userName, String password, int position) {
		super();
		this.userName = userName;
		this.password = password;
		this.position = position;
	}
	
	public Person(){
		
	}

	public int getPosition() {
		return position;
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
		return "Person [userName=" + userName + ", password=" + password
				+ ", position=" + position + "]";
	}
	
	
}
