package com.cos.securityex01.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

// ORM => object Relation Mapping

@Data
@Entity //데이터베이스 테이블에 모델이 된다.
public class User {
	@Id //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private String email;
	private String role;
	@CreationTimestamp
	private Timestamp createDate;
}
