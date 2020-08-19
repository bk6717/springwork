package com.cos.blog2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog2.model.User;
import com.cos.blog2.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public int 회원가입(User user) {
		try {
			userRepository.save(user);
			return 1;
		} catch (Exception e) {
			e.getMessage();
			return -1;
		}
	}
	
	@Transactional
	public User 로그인(User user) {
		return userRepository.login(user);
	}
}
