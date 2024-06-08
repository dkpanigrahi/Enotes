package com.deepak.service;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.deepak.entity.User;

import jakarta.servlet.http.HttpSession;

public interface UserService {

	public User saveuser(User user);
	
	public boolean existEmailCheck(String email);
	
	public void deleteSessionMessage();
}
