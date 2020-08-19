package com.cos.opggex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LankingController {

	
	@GetMapping("/ranking")
	public String ranking() {
		return "<h1>랭킹 페이지</h1>";
	}
	
}
