package com.cos.springStudy.repository;

import java.util.List;

import com.cos.springStudy.model.Account;

public interface AccountRepository {
	
	//서비스가 아니라 가장 기본적인 crud를 만들어야한다.
	//이것을 조합해 서비스를 만든다. 
	
	//추상 클래스 
	//xml 매핑파일과 연결
	public void update(Account account); //객체를 넘겨서 처리
	
	public List<Account> findAll();
	
	public Account findByAccountNumber(String accountNumber);
	
	
}
