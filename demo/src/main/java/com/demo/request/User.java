package com.demo.request;

public class User {

	private String name;
	private String IC;
	private String phoneNumber;
	private String gender;

	public User() {
	}

	public User(String name, String iC) {
		super();
		this.name = name;
		IC = iC;
	}

	public User(String name, String iC, String phoneNumber, String gender) {
		super();
		this.name = name;
		IC = iC;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIC() {
		return IC;
	}

	public void setIC(String iC) {
		IC = iC;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", IC=" + IC + ", phoneNumber=" + phoneNumber + ", gender=" + gender + "]";
	}

}