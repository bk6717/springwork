package com.cos.jwtEx01.config.jwt;

public interface JwtProperties {
	
	String SECRET = "하하하"; // 우리 서버만 알고있는 비밀값
	int EXPIRATION_TIME = 864000000; // 10일 (ms 단위)
	String TOKEN_PREFIX = "Bearer ";
	String HEADER_STRING = "Authorization";
	
}