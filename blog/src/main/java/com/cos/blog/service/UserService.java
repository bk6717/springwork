package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

//Controller, Repository, configuration, Service, Component
//RestController, Bean
//controller, RestController 차이  => controller는 뷰리졸버 html 파일을 리턴한다.
// 						  			RestController.는  데이터만 리턴한다.

@Service //ioc
public class UserService {
	
	@Autowired
	private UserRepository userRepository; //Di

	@Transactional
	public void 회원가입(User user) {
		user.setRole("ROLE_USER");
		userRepository.save(user);
	}
	
	@Transactional(readOnly = true) //select만하는 트랜잭션 -> 데이터가 안변하기때문에 정확성이 있다.
	public User 로그인(User user) {
	 return	userRepository.login(user);
	}
}
