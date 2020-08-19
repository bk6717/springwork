package com.cos.validex01;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class RespDto<T> {
	
	private int statusCode; //오류코드, 프로토콜을 정해놓는것이 좋음
	//statusCode가 실패가 뜨면 메시지를 읽는다.
	private String msg; //오류 메세지
	//에러가 뜨면 데이터에 에러를 담는다
	//statusCode가 전송되면 데이터를 읽는다.
	private T data;
	
}
