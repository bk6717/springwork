package com.cos.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SendRequestDto {
	
	private String senderAccountNumber;
	private String receiverAccountNumber;
	private int money;
	
}
