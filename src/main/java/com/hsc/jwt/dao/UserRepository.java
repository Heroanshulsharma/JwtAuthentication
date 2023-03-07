package com.hsc.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hsc.jwt.model.User;

public interface UserRepository  extends JpaRepository<User, Integer>{
	
	public User findByUsername(String username);

}
