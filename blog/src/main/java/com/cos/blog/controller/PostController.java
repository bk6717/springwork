package com.cos.blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blog.config.handler.exception.MyRoleException;
import com.cos.blog.controller.dto.CommonRespDto;
import com.cos.blog.model.Post;
import com.cos.blog.model.User;
import com.cos.blog.repository.PostRepository;
import com.cos.blog.repository.UserRepository;
import com.cos.blog.service.PostService;

import lombok.RequiredArgsConstructor;

@Controller
//@RequiredArgsConstructor
public class PostController {
	 
	@Autowired
	private PostService postService;
	@Autowired
	private PostRepository postRepository;
//	private final PostService postService;
	
//	public PostController(PostService postService) {
//		this.postService = postService;
//	}
	
	@GetMapping("/post/saveForm")
	public String postForm() {
		return "post/saveForm";
	}
	
	@PostMapping("/post")
	public @ResponseBody CommonRespDto<?> postProc(@RequestBody Post post){
		postService.글쓰기(post);
		return new CommonRespDto<String>(1, "ㄱㅡㄹㅆㅡㄱㅣ ㅅㅓㅇㄱㅗㅇ");
	}
	
	@GetMapping("/posts")
	public String getPosts(Model model) {
		model.addAttribute("posts", postService.목록보기());
		return "index";
	}
	// >주소 -> 쿼리스트링
	// /post/{id} => 주소에 파라메터를 받는 것 
	@GetMapping("/post/{id}")
	public String getPost(@PathVariable int id, Model model) { //주소값은 스트링이지만 아이디값을 인트로 받아준다.
		model.addAttribute("PostDetailRespDto", postService.상세보기(id));
		return "post/detail";
	}
	
	@DeleteMapping("/post/{id}")
	public @ResponseBody CommonRespDto<?> deleteById(@PathVariable int id, HttpSession session) throws MyRoleException{
		//세션값 확인, 글의 주인
		User principal = (User)session.getAttribute("principal");
		Post postEntity = postRepository.findOne(id);
		if (principal.getId() != postEntity.getUserId()) {
			throw new MyRoleException(); 
			
		}
		postService.삭제하기(id);
		return new CommonRespDto<Sting>(1, "삭제에 성공 하였습니다.");
	}
	
	@PutMapping("/post/{id}")
	public @ResponseBody CommonRespDto<?> update(@RequestBody Post post) {
		postService.수정하기(post);
		return new CommonRespDto<Sting>(1, "수정성공");
	}
	
}

