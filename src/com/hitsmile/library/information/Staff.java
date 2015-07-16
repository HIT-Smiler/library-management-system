package com.hitsmile.library.information;

public class Staff extends Person{
	
	private int position;
	private int id;
	private int age;
	private String name;
	private String gender;
	private String birthday;
	private String userName;
	private String password;
	private String location;
	
	public Staff(String userName, String password, int id, int age, String name, String gender, 
			String birthday, String location) {
		this.userName = userName;
		this.password = password;
		this.position = 10;
		this.id = id;
		this.age = age;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", age=" + age + ", name=" + name
				+ ", gender=" + gender + ", birthday=" + birthday
				+ ", userName=" + userName + ", password=" + password
				+ ", location=" + location + "]";
	}
	
	
	

}
