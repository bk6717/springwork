package com.jaybon.securityEx01.test;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class GlobalExceptionControllerTest {

	@ExceptionHandler(value = {NullPointerException.class, IllegalAccessException.class})
	 
	public String 널_일리걸아규먼트_익셉션(Exception e) {
		StringBuilder sb = new StringBuilder();
		sb.append("<h1>해당 아큐먼트로 찾을 수 있는 정보가 없습니다</h1>");
		sb.append("<h2>"+e.getMessage()+"</h2>");
		return sb.toString();
		
	}
	
}
