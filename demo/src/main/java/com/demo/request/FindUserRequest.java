package com.demo.request;

import com.demo.constant.FindUserType;

public class FindUserRequest {

	private FindUserType type;
	private String value;

	public FindUserRequest() {
	}

	public FindUserRequest(FindUserType type, String value) {
		this.type = type;
		this.value = value;
	}

	public FindUserType getType() {
		return type;
	}

	public void setType(FindUserType type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "FindUserRequest [type=" + type + ", value=" + value + "]";
	}

}