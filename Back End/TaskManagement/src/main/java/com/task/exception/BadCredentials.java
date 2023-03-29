package com.task.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BadCredentials extends RuntimeException {

	String username;
	String password;
	
	public BadCredentials(String username, String password) {
		super(String.format("%s not found with %s", username, password));
		this.username = username;
		this.password = password;
	}
}