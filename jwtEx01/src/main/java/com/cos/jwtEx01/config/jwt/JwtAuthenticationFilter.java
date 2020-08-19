package com.cos.jwtEx01.config.jwt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.cos.jwtEx01.config.auth.PrincipalDetails;
import com.cos.jwtEx01.dto.LoginRequestDto;
import com.cos.jwtEx01.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	private final AuthenticationManager authenticationManager; 
	
	//1..Authentication 객체를 생성한다. => 의존 : AuthenticationManager
	//인증 요청시에 실행되는 함수 => /login 일때만 실행되는 함수 
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		//내가 커스터마이징 해야함
		
		//request에 있는 username과 password 를 파싱해서 object로 받기
		ObjectMapper om = new ObjectMapper();
		LoginRequestDto loginRequestDto = null;
		
		try {
			loginRequestDto = om.readValue(request.getInputStream(), LoginRequestDto.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//유저네임패스워드 토큰 생성 
		UsernamePasswordAuthenticationToken authenticationToken =
				new UsernamePasswordAuthenticationToken(
						loginRequestDto.getUsername(), //인증주체 혹은 접근주체 
						loginRequestDto.getPassword());
		
		//authentication함수가 호출되면 인증 프로바이더가 유저 디테일 서비스의 
		//loadUserByUsername(토큰의 첫번째 파라메터)를 호풀하고
		//UserDetails를 리턴받아서 토큰의 두번째 파라메터(credential)과
		//UserDetails(DB값)의 getPassword()함수로 비교해서 동일하면
		//Authentication 객체를 만들어서 필터체인으로 리턴해준다.
		
		//tip : 인증 프로바이더의 디폴트 서비스는 UserDetailsService 타입이고
		//tip : 인증 프로바이더의 디폴트 암호화 방식은 BCryptPasswordEncoder이다 .
		//결론은 인증프로바이더에게 알려줄필요가없다.
		
		Authentication authentication =
				authenticationManager.authenticate(authenticationToken);
		
		PrincipalDetails principalDetails = (PrincipalDetails)authentication.getPrincipal();
		System.out.println("Authentication : " + principalDetails.getUser().getUsername());
		return authentication;
	
	}
	//2..Authentication이 만들어지고 나서 실행한다.
	//JWT Token을 생성해서 response에 담아주기
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		PrincipalDetails principalDetails = (PrincipalDetails)authResult.getPrincipal();
		
		String jwtToken = JWT.create()
				.withSubject(principalDetails.getUsername()) //유저네임
				.withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME)) //만료시간 
				.withClaim("id", principalDetails.getUser().getId()) //비공개 클레임
				.withClaim("username", principalDetails.getUser().getUsername())
				.sign(Algorithm.HMAC512("하하하"));

		response.addHeader(JwtProperties.HEADER_STRING , JwtProperties.TOKEN_PREFIX + jwtToken);
		
	}
}
