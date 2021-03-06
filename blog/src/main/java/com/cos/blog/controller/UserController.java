package com.cos.blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blog.controller.dto.CommonRespDto;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;


@Controller
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/auth/joinProc")
	public @ResponseBody CommonRespDto<?> joinProc(@RequestBody User user) {
		userService.회원가입(user);
		
		return new CommonRespDto<String>(1, "회원가입 결과 성공"); // 모든 DML을 하게되면 return을 이걸 해준다. (ResponseEntity 가지고있음)
		
		// User에서 String으로 바꿧다
		// 왜냐하면 return으로 OK라고 회원가입완료됬다고 말해주기만하면되니까
	}
	
	
	@PostMapping("auth/loginProc") // 페이지 요청하는거 아니면 commonresdto 다 쓰면된다.
	public @ResponseBody CommonRespDto<?> loginProc(@RequestBody User user, HttpSession session){
		 User persistUser =  userService.로그인(user);
		   
		   // 로그인할 때는 세션을 받아야되기때문에 User 오브젝트 리턴해야함!!!
		if(ObjectUtils.isEmpty(persistUser)) {
			//세션 등록해야함
			return new CommonRespDto<String>(-1, "로그인 결과 실패");
			
		} else {
			session.setAttribute("principal", persistUser);
			return new CommonRespDto<String>(1, "로그인 결과 성공"); // 모든 DML을 하게되면 return을 이걸 해준다. (ResponseEntity 가지고있음)
			// persistUser 가 세션등록이 돼있으면
			//뭐지 로그인결과실패?
		}
		   
		
		
	}
	
	
	
	
}