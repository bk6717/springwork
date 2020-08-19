package com.cos.opggex.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
	
	private int id;
	private int userId;
	private String title;
	private String content;
	private Timestamp createDate;
	private int likeCount;
	private int viewCount;
	
}
