package com.mobileapp.ws.demo.mobile.app.ws.model;

import javax.validation.constraints.NotNull;

public class UpdateUserDetails {

	@NotNull(message = "firstName must not greater than 20 characters")
	private String firstName;

	@NotNull(message = "lastName must not greater than 20 characters")
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
