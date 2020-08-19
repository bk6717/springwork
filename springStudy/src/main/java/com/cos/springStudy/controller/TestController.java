package com.cos.springStudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.springStudy.service.UserService;

@RestController
public class TestController {
	
	@Autowired
	private UserService UserService;
	
	@GetMapping("/user/{id}")
	public String findUser() {
		return "<h1>유저 찾기 페이지</h1>";
	}
	
	@GetMapping("/post/{id}")
	public String findPost() {
		return "<h1>글 상세보기 페이지</h1>";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "<h1>관리자 페이지</h1>";
	}
}
 
