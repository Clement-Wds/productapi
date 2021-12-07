package com.ynovb3.productapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
public class PublicController {
		
	@GetMapping("/securitynone")
	public String securityNone() {
		return "open";
	}
	

}
