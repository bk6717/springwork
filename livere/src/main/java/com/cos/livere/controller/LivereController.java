package com.cos.livere.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LivereController {

	@GetMapping("/detail")
	public String detail() {
		return "detail";
	}
	
	
	
}
