package com.ynovb3.productapi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
//	@Autowired
//	private CustomUserDetailsService userDetailsService;
	
	protected void configure(HttpSecurity http) throws Exception {
		
		http = http.cors().and().csrf().disable();
		
		http.authorizeRequests().antMatchers("/securitynone").permitAll().antMatchers("/*").hasRole("USER").anyRequest().authenticated().and().httpBasic();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		String encodedPassword = passwordEncoder().encode("password");
		
		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).withUser("clement").password(encodedPassword).roles("USER");
	}
	
}
