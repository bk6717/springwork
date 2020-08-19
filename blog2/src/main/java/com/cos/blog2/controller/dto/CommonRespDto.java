package com.cos.blog2.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonRespDto<T> {
	
	private int statusCode; //응답코드 => 1 정상 , -1 실패 , 0 변경안됨 
	private T data; //select시 사용 여기에 데이터를 넣어서 사용한다.
}
