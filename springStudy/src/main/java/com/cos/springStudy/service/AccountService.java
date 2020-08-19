package com.cos.springStudy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.springStudy.dto.SendRequestDto;
import com.cos.springStudy.model.Account;
import com.cos.springStudy.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	
	@Transactional // 트랜잭션은 함수가 종료되면 실행됨
	//하나라도 안되면 rollback 되고, 둘다 완료되면 commit해야함
		public void 송금(SendRequestDto dto) { //누가 누구에게 얼마를
		//보내는사람 
		Account 홍길동 = accountRepository.findByAccountNumber(dto.getSenderAccountNumber());
		
		홍길동.setMoney(홍길동.getMoney() - dto.getMoney());
		accountRepository.update(홍길동);
		
		Account 장보고 = accountRepository.findByAccountNumber(dto.getReceiverAccountNumber());
		
		장보고.setMoney(장보고.getMoney() + dto.getMoney());
		accountRepository.update(장보고);
		
	}
	
	public void 인출(Account a, int accepMoney) {
		Account 홍길동 = accountRepository.findByAccountNumber(a.getAccountNumber());
		
		홍길동.setMoney(홍길동.getMoney() - accepMoney);
		accountRepository.update(홍길동);
	}
	
	@Transactional
	public List<Account> 계좌정보보기(){
		return accountRepository.findAll();
	}
}
 