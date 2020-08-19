package com.cos.securityex01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cos.securityex01.model.User;
//첫번째는 모델 
//두번째는 id
//JpaRepository를 상속하면 자동 컴포넌트 스캔됨
public interface UserRepository extends JpaRepository<User, Integer>{
	
	//jpa Naming 전략 
	//SELECT * FROM user WHERE username = 1?
	User findByUsername(String username);
	
//	@Query(value = "select * from user", nativeQuery = true)
//	User find마음대로();
}	
