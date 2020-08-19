package com.cos.springStudy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SendRequestDto {
	private String senderAccountNumber;
	private String receiverAccountNumber;
	private int money;
}