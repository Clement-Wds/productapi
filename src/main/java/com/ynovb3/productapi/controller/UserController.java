package com.ynovb3.productapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ynovb3.productapi.model.User;
import com.ynovb3.productapi.service.UserService;

@RestController
@RequestMapping("/api/private")
public class UserController {

	@Autowired UserService userService;
	
	@GetMapping("/user/{username}")
	public User getUserByUsername(@PathVariable("username") String username){
		return userService.getUserByUsername(username);
	}
	
}
