package com.cos.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cos.demo.model.Member;

@Repository
public interface MemberRepository {

	public Member findById(int id);
	public List<Member> findAll();

}
