package com.jaybon.securityEx01.test;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jaybon.securityEx01.model.User;
import com.jaybon.securityEx01.repository.UserRepository;

@RestController
public class OptionalControllerTest {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/test/user/{id}")
	public User 옵셔널_유저찾기(@PathVariable int id) {
//		Optional<User> userOptional = userRepository.findById(id);
//		User user;
//		if(userOptional.isPresent()) {
//			user = userOptional.get();
//		}else {
//			user = new User();
//		}
		
		//orElseGet()
//		User user = userRepository.findById(id).orElseGet(()-> {
//				return User.builder().id(10).username("하하하").email("testt@naver.com").build();
//		});
		
		User user = userRepository.findById(id)
				.orElseThrow(()-> {
					return new NullPointerException("널 포인터 오류");
				});
				
				
		return user;
	}
}
