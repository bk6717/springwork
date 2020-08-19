package com.cos.blog2.repository;

import com.cos.blog2.model.User;

//mapper가 스캔하기 때문에 어노테이션을 안써도 메모리에 뜸 
public interface UserRepository {
 
	public void save(User user);
	
	public User login(User user);
	
	
	
}
