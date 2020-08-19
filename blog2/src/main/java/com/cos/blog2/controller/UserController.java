package com.cos.blog2.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blog2.controller.dto.CommonRespDto;
import com.cos.blog2.model.User;
import com.cos.blog2.service.UserService;

@Controller
public class UserController {
	
	//요청시 컨트롤러가 뜸, userService는 컨트롤러보다 더 미리 떠있기 떄문에 DI 가능
	//톰캣 시작시 service가 메모리에 뜸 
	//요청시 request가 메모리에 뜸
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/auth/joinProc")
	//제네릭의 타입을 모를때는 ? 사용가능
	public @ResponseBody CommonRespDto<?> joinProc(@RequestBody User user) {
		// key = value 데이터만 받을 수 있기때문에 @ResponseBody를 적어줘야함
		// 응답을 데이터로 받기 위해 사용
		int result = userService.회원가입(user);
		return new CommonRespDto<String>(result, "회원가입 결과 : "+result);
	}
	
	
	@PostMapping("/auth/loginProc")
	public @ResponseBody CommonRespDto<?> loginProc(@RequestBody User user, HttpSession session){
		User persisUser = userService.로그인(user);
		
		if (ObjectUtils.isEmpty(persisUser)) { // 빈갹채
			System.out.println("유저 없음");
			return new CommonRespDto<String>(1,"로그인 실패");
		}else {
			System.out.println("유저 있음");
			session.setAttribute("principal", persisUser);
			return new CommonRespDto<String>(1, "로그인 성공");
		}
	}
}
