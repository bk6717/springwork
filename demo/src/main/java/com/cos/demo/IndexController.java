package com.cos.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class IndexController {
	
	@Autowired
	Test t;
	
	// get 요청이 들어올때 아래코드 둘중하나를 탄다.
	// http://localhost:8080/
	// http://localhost:8080
	@GetMapping({ "", "/" })
	// @ResponseBody가없으면 알아서 Hello라는 파일을 찾는다.
	// @ResponseBody를 사용하면 Hello 라는 데이터를 리턴한다.
	// 없으면 reqeustDispater 있으면 print
	public @ResponseBody String index() {
		System.out.println(t.num);
		return "Hello"; // ViewResolver
	}
	
	//x-www-form-urlencoded => key=value
	@PostMapping("/form")
	public @ResponseBody String form(String username, String password, String email) {
		System.out.println(username);
		System.out.println(password);
		System.out.println(email);
		return "User"; //ViewResolver
	}

	//x-www-form-urlencoded => key=value
	@PostMapping("/form/model")
	public @ResponseBody String formModel(User user) {
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getEmail());
		return "User"; //ViewResolver
	}
	
	//x-www-form-urlencoded => key=value
	@GetMapping("/form/model")
	public @ResponseBody String formModelGet(User user) {
		
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getEmail());
		return "User"; //ViewResolver
		
	}
	
	// json => {"key" = "value"}
	@PostMapping("/json/model")
	public @ResponseBody User josnModel(@RequestBody User user) {
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getEmail());
		return user; //ViewResolver 작동금지  => Jackson 작동
	}
	
	@GetMapping("/index")
	public String home() {
		return "index";
	}
	
}