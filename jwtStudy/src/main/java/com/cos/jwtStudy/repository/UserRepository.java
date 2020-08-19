package com.cos.jwtStudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.jwtStudy.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
}
