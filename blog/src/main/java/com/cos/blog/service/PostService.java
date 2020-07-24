package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.Post;
import com.cos.blog.model.User;
import com.cos.blog.repository.PostRepository;
import com.cos.blog.repository.UserRepository;

//Controller, Repository, configuration, Service, Component
//RestController, Bean
//controller, RestController 차이  => controller는 뷰리졸버 html 파일을 리턴한다.
// 						  			RestController.는  데이터만 리턴한다.

@Service //ioc
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Transactional
	public void 글쓰기(Post post) {
		postRepository.save(post);
	}
	
}