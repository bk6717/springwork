package com.cos.jwtStudy.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User {
	
	@Id
	@GeneratedValue
	private long id;
	private String username;
	private String password;
	private String roles;
	
	//Enum으로 안하고 ,로 구분 role 입력 => 파싱
	public List<String> getRoleList(){
		if (this.roles.length() > 0) {
			return Arrays.asList(this.roles.split(","));
		}
		
		return new ArrayList<>();
	}
}
