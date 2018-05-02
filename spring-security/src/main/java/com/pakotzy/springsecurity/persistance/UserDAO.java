package com.pakotzy.springsecurity.persistance;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDAO {
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String userName;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String password;

	public UserDAO() {
	}

	public UserDAO(@NotNull(message = "is required") @Size(min = 1, message = "is required") String userName, @NotNull
			(message = "is required") @Size(min = 1, message = "is required") String password) {
		this.userName = userName;
		this.password = password;
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
}
