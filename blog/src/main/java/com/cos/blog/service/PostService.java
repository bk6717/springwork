package com.cos.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.controller.dto.CommonRespDto;
import com.cos.blog.controller.dto.PostDetailRespDto;
import com.cos.blog.model.Post;
import com.cos.blog.repository.PostRepository;

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
	
	@Transactional (readOnly = true)
	public List<Post> 목록보기(){
		return postRepository.findAll();
	}
	
	@Transactional (readOnly = true)
	public PostDetailRespDto 상세보기(int id) {
		return postRepository.findById(id);
	}
	
	@Transactional (readOnly = true)
	public void 삭제하기(int id){
		postRepository.deleteById(id); 
	}
	
	@Transactional (readOnly = true)
	public void 수정하기() {
		postRepository.update(post);
	}
}
