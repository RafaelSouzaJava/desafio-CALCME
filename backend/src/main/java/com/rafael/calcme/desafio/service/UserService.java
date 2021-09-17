package com.rafael.calcme.desafio.service;

import org.springframework.security.core.context.SecurityContextHolder;

import com.rafael.calcme.desafio.secutity.UserSS;

public class UserService {
	
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}

}
