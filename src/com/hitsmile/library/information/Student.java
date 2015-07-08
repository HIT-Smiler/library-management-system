
package com.hitsmile.library.information;

public class Student extends Person{
	
	private int position;
	private int id;
	private int age;
	private String name;
	private String gender;
	private String birthday;
	private String userName;
	private String password;
	private String major;
	private String insitute;
	private String grade;
	
	
	public Student(String userName, String password, 
			int id, int age, String name, String gender, String birthday,
			String userName2, String password2, String major, String insitute,
			String grade) {
		this.userName = userName;
		this.password = password;
		this.position = 11;
		this.id = id;
		this.age = age;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		userName = userName2;
		password = password2;
		this.major = major;
		this.insitute = insitute;
		this.grade = grade;
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
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getInsitute() {
		return insitute;
	}
	public void setInsitute(String insitute) {
		this.insitute = insitute;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", age=" + age + ", name=" + name
				+ ", gender=" + gender + ", birthday=" + birthday
				+ ", userName=" + userName + ", password=" + password
				+ ", major=" + major + ", insitute=" + insitute + ", grade="
				+ grade + "]";
	}
	
	
}
