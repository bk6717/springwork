package com.cos.validex01;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/board")
public class ProjectTaskController {

	@Autowired // 주입을 받으려면 IOC(RestController)등록 해줘야함
	private ProjectTaskRepository projectTaskRepository;
	
	
	@PostMapping({"" , "/"})
	public ResponseEntity<?> save(@Valid @RequestBody ProjectTask requestprojectTask, BindingResult bindingResult){
		//val 체크할때 오류가 터지면 BindingResilt에게 전부 넘겨준다. //오류가 안터지면 안담긴다.
		
		
		
		
		
		
		
		ProjectTask entityProjectTask 
				= projectTaskRepository.save(requestprojectTask); // save된 entity를 리턴받는다.
		
		RespDto<?> respDto = RespDto.builder()
				.statusCode(StatusCode.OK)
				.msg("요청에 성공하였습니다.")
				.data(entityProjectTask)
				.build();
		
		
		return new ResponseEntity<RespDto>(respDto,HttpStatus.CREATED);//201 정상적으로 insert가 되었다.  
		
	}
}
