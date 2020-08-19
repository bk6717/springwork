package com.cos.opggex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.opggex.model.Post;
import com.cos.opggex.repository.PostRepository;
import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Platform;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.match.MatchHistory;
import com.merakianalytics.orianna.types.core.summoner.Summoner;

@RestController
@CrossOrigin(origins = "*")
public class TestController {
	
	@Autowired
	private PostRepository postRepository;

	@GetMapping("/post/{id}")
	public Post findById (@PathVariable int id) {
		Post post = postRepository.findById(id);
		return post;
	}
	
	@GetMapping("/post")
	public @ResponseBody String findById2 () {
		return "data";
	}

	//
//	@GetMapping("summoner/{username}")
	
	
	//// test ////
	@GetMapping("/test1")
	public String test1(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "1";
	}
	
	@GetMapping("/test2")
	public String test2() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "2";
	}
	
	@GetMapping("/test3")
	public String test3() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "3";
	}
}


