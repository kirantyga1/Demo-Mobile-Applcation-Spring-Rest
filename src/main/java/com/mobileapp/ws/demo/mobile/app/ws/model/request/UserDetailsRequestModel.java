package com.mobileapp.ws.demo.mobile.app.ws.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailsRequestModel {

	@NotNull(message = "firstName must not greater than 20 characters")
	private String firstName;

	@NotNull(message = "lastName must not greater than 20 characters")
	private String lastName;

	@NotNull(message = "email cannot be null")
	@Email
	private String email;

	@NotNull(message = "firstname must not greater than 20 characters")
	@Size(min=8, max=16,message = "password length must between 8 to 16 characters")
	private String password;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
