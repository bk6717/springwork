package com.cos.jwtEx01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.jwtEx01.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);
	
}
