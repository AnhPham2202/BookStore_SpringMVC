package com.bookstore.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityUtils {
	public String hashPassword(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
		return encoder.encode(password);
	}
	
	public boolean checkMatch(String password, String encodedPassword) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
		return encoder.matches(password, encodedPassword);
	}
}
