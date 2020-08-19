package com.cos.springStudy.repository;

import java.util.List;

import com.cos.springStudy.model.User;

public interface UserRepository {
	
	public User findById(int id);

	public List<User> findAll();
	

}
