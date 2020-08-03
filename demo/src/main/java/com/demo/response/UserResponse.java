package com.demo.response;

public class UserResponse {

	private String name;
	private String IC;
	private String phoneNumber;
	//TODO use enum for gender.
	private String gender;

	public UserResponse() {
		super();
	}

	public UserResponse(String name, String iC, String phoneNumber, String gender) {
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
		return "NewUserResponse [name=" + name + ", IC=" + IC + ", phoneNumber=" + phoneNumber + ", gender=" + gender
				+ "]";
	}
}