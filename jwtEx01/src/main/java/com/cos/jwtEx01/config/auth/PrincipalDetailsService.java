package com.cos.jwtEx01.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cos.jwtEx01.model.User;
import com.cos.jwtEx01.repository.UserRepository;

@Service
public class PrincipalDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user != null) {
			System.out.println("해당유저 찾았어요");
			return new PrincipalDetails(user);
		}
		System.out.println("유저 못찾았어요");
		return null;
	}
	

}
