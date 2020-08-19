package com.cos.jwtStudy.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.jwtStudy.model.User;
import com.cos.jwtStudy.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class RestApiController {

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//모든 사람 접근가능
	@GetMapping("home")
	public String home() {
		return "<h1>home<h2>";
	}
	
//	//유저 페이지
//	@GetMapping("user")
//	public String user(Authentication authentication) {
//	
//	}
	//매니저 or 유저 접근가능
	@GetMapping("manager/reports")
	public String reports() {
		return "<h1>reports</h1>";
	}
	//관리자 접근 
	@GetMapping("admin/users")
	public List<User> users(){
		return userRepository.findAll();
	}
	
	//회원가입
	@PostMapping("join")
	public String join(@RequestBody User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles("ROLE_USER");
		userRepository.save(user);
		
		return "회원가입 완료";
	}
}
