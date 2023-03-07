package com.hsc.jwt.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hsc.jwt.JwtAuthenticationApplication;
import com.hsc.jwt.dao.UserRepository;
import com.hsc.jwt.helper.JwtUtil;
import com.hsc.jwt.model.User;

@RestController
@CrossOrigin(origins = "*")
public class HomeController {

	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserRepository userRepository;
	
//	@GetMapping("getusers")
//	public String getUser() {
//		System.out.println("inside get user");
//		return "{\"name\":\"Anshul\"}";
//	}
	@GetMapping("db")
	public String createUser() {
		User user= new User(1, "Anshul", "Anshul", "Anshul@hsc.com"	, "Admin", true);
		this.userRepository.save(user);
		return "Data gaya";
	}
	
	@GetMapping("getusers")
	public User getUser(HttpServletRequest request) {
		String jwtToken=null;
		String username = null;
		String requestTokenHeader = request.getHeader("Authorization");
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);
			
			try {
				
				username = this.jwtUtil.extractUsername(jwtToken);
				
			} catch (Exception e) {
				
				// TODO: handle exception
			}
		}
		
		System.out.println("inside get user");
		User user = this.userRepository.findByUsername(username);
		return user;
		}
	
	
}
