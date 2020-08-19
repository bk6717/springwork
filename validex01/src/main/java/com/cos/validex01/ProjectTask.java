package com.cos.validex01;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

//모델
@Entity
@NoArgsConstructor
@Data// 모델은 setter가 있으면안된다. => 불변
public class ProjectTask {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@Size(max = 10, message = "Summary cannot exceed the length") // 10자를 넘으면 안됨 
	@NotBlank(message = "Summary cannot be blank")
	private String summary;
	
	@NotBlank(message = "acceptanceCriteria cannot ne blank")
	private String acceptanceCriteria;
	private String status;
	
	@Email(message = "Your email XXX")
	private String email;
}

