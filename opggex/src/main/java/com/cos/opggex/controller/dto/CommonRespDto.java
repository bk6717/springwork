package com.cos.opggex.controller.dto;

public class CommonRespDto<T>{
	private int statusCode; // 1=정상 , -1=실패 , 0= 변경 x
	private T data;
}
