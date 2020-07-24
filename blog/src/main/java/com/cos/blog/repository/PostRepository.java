package com.cos.blog.repository;

import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.Post;
public interface PostRepository {
	
	@Transactional
	public void save(Post post);		
	
	
}
