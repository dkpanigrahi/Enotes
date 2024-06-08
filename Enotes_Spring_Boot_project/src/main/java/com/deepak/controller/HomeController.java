package com.deepak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.deepak.entity.User;
import com.deepak.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String index()
	{
		return "index";
	}
	
	@GetMapping("/register")
	public String register()
	{
		return "register";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute User user,HttpSession session)
	{
		boolean f = userService.existEmailCheck(user.getEmail());
		
		if(f) {
			session.setAttribute("msg", "Email id allready exist");
		}else {
			User newUser = userService.saveuser(user);
			if(newUser != null) {
				session.setAttribute("msg", "Register Successfully");
			}else {
				session.setAttribute("msg", "Something Wrong on Server!!!!");
			}
		}
		
		return "redirect:/register";
	}
	
	@GetMapping("/signin")
	public String login()
	{
		return "login";
	}
	
	
}
