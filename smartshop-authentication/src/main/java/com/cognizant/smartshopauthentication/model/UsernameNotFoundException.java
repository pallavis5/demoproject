package com.cognizant.smartshopauthentication.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Username Not Found")
public class UsernameNotFoundException extends Exception {
	public UsernameNotFoundException() {
		// TODO Auto-generated constructor stub
	}

}
