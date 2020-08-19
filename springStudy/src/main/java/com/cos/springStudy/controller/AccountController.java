package com.cos.springStudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cos.springStudy.model.Account;
import com.cos.springStudy.service.AccountService;

@Controller
public class AccountController {
	
	@Autowired
	private AccountService AccountService;
	
	@GetMapping("/account")
	public List<Account> findAll(){
		return AccountService.계좌정보보기();
	}
	
	@PutMapping("/send")
	public @ResponseBody String send(){
		return "<h1>송금이 완료되었습니다.</h1>";
	}
	
	@PutMapping("/withdraw")
	public @ResponseBody String withdraw() {
		return "<h1>인출이 완료되었습니다.</h1>";
	}

}
