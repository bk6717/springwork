package com.cos.opggex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.opggex.controller.dto.CommonRespDto;
import com.cos.opggex.model.Post;
import com.cos.opggex.repository.PostRepository;

@RestController
@RequestMapping("/community")
public class CommunityController {
	
	@Autowired
	private PostRepository postRepository;

	@GetMapping({"/",""})
	public String main() {
		return "커뮤니티 메인";
	}
	
	//글쓰기페이지 이동
	@GetMapping("/postFrom")
	public String postFrom() {
		return "<h1>글쓰기 페이지</h1>";
	}
	
	//글쓰기
//	@GetMapping()
//	public CommonRespDto<?> save(){
//		return new CommonRespDto<String>(1, "글쓰기 완료");
//	}
	
	//상세보기
	@GetMapping("/{id}")
	public Post detail(@PathVariable int id) {
		Post post = postRepository.findById(id);
		return post;
	}
	
}
