package com.cos.springStudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cos.springStudy.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public void 테스트(int id) {
		userRepository.findById(id);
		}
	}
