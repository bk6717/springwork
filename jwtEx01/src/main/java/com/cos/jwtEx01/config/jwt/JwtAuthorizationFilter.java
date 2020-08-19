package com.cos.jwtEx01.config.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.cos.jwtEx01.config.auth.SessionUser;
import com.cos.jwtEx01.model.User;
import com.cos.jwtEx01.repository.UserRepository;

//인가
public class JwtAuthorizationFilter extends BasicAuthenticationFilter{
	
	private UserRepository userRepository;
	
	public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	} 
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String header = request.getHeader(JwtProperties.HEADER_STRING);
		if (header == null || header.startsWith(JwtProperties.TOKEN_PREFIX)) {
			chain.doFilter(request, response);
		}
		
		String token = request.getHeader(JwtProperties.HEADER_STRING)
				.replace(JwtProperties.TOKEN_PREFIX,"")
				.replace(" ", "")
				.replace("=", "");
		
		//5. 토큰 검증 (인증이기때문에 AuthenticationManager 필요없음 )
		// SecurityContext에 직접접근해서 세션을 만들떄 자동으로 UserDetailsService에 있는 loadByUsername이 호출됨
		String username = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET))
				.build()
				.verify(token)
				.getClaim("username").asString();
		
		if (username != null) {
			User user = userRepository.findByUsername(username);
			SessionUser sessionUser = SessionUser.builder()
					.id(user.getId())
					.username(user.getUsername())
					.roles(user.getRoleList())
					.build();
			HttpSession session = request.getSession();
			session.setAttribute("sessionUser", sessionUser);
		}
		chain.doFilter(request, response);
		
	}
}
