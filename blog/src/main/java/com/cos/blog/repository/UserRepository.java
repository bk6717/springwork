package com.cos.blog.repository;

import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.User;
public interface UserRepository {
	@Transactional
	public void save(User user);		
	
	public User login(User user);
	
}
