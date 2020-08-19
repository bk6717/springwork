package com.cos.jwtEx01.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.jwtEx01.config.auth.SessionUser;
import com.cos.jwtEx01.model.User;
import com.cos.jwtEx01.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1") //API 진입 주소를 알려준다
//@CrossOrigin // CORS 허용
public class RestApiController {
	
	private final UserRepository UserRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//모든사람이 접근가능 
	@GetMapping("home")
	public String home() {
		return "<h1>home</h1>";
	}
	
	//모든사람이 접근가능 
	@GetMapping("user")
	public String user(HttpSession session) {
		SessionUser sessionUser = (SessionUser)session.getAttribute("sessionUser");
		System.out.println("principal :" + sessionUser.getId());
		System.out.println("principal :" + sessionUser.getUsername());
		System.out.println("principal :" + sessionUser.getRoles());
		return "<h1>user</h1>";
	}
	
	//매니저가 접근 가능 
	@GetMapping("manager/reports")
	public String reports() {
		return "<h1>reports</h1>";
	}
	
	//admin이 접근 가능
	@GetMapping("admin/user")
	public List<User> users(){
		return null;
	}
	
	@PostMapping("join")
	public String join(@RequestBody User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles("ROLE_USER");
		UserRepository.save(user);
		return "회원가입완료";
	}

}
