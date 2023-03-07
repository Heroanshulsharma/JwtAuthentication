package com.hsc.jwt.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hsc.jwt.dao.UserRepository;
import com.hsc.jwt.model.CustomUserDetails;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository UserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		com.hsc.jwt.model.User user= this.UserRepository.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("User not found");
			
		}
		else {
			return new CustomUserDetails(user);
		}
		
	}

	
}
