package com.hsc.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hsc.jwt.dao.UserRepository;
import com.hsc.jwt.model.User;

@SpringBootApplication
public class JwtAuthenticationApplication{

	@Autowired
	private static UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(JwtAuthenticationApplication.class, args);
		
	}
	
	
	
	




}
