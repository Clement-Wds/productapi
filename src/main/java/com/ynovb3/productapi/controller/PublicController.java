package com.ynovb3.productapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ynovb3.productapi.configuration.JwtTokenUtil;

@RestController
@RequestMapping("/api/public")
public class PublicController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody com.ynovb3.productapi.model.User user){
        
        
        try {
            Authentication authenticate = 
                    authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    user.getUsername(),
                                    user.getPassword()
                                    )
                            );
            
            User authenticateUser = (User) authenticate.getPrincipal();
            String token = jwtTokenUtil.generateAccessToken(authenticateUser);
            System.out.println("Token is :" + token);
            
            String text = authenticateUser.getUsername()
                    + "Succesfully authenticated";

            ResponseEntity<String> response = ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, token).body(text);
            return response;

        }catch(Exception e) {
            return ResponseEntity.status(
                    HttpStatus.UNAUTHORIZED).build();
        }
        
    }
	
	@GetMapping("/securitynone")
	public String securityNone() {
		return "open";
	}

}
