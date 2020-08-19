package com.cos.jwtEx01.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.cos.jwtEx01.config.jwt.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity // 시큐리티 활성화 => 기본 스프링 필터체인에 등록이 된다.

public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		   http
				.csrf().disable() //csrf 토큰 해지
			//세션을 안씀     (STATELESS : 상태가 없다)
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
				.formLogin().disable() // 폼태그 로그인 막음
				.httpBasic().disable() // jsessionId 막음
				.addFilter(new JwtAuthenticationFilter(authenticationManager())) //내가 정의한 필터가 동작한다.
//				.addFilter(null)
				.authorizeRequests()
				.antMatchers("/api/v1/user/**")
					.access("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
				.antMatchers("/api/v1/manager/**")
					.access("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
				.antMatchers("/api/v1/admin/**")
					.access("hasRole('ROLE_ADMIN')")
				.anyRequest().permitAll()
				.and()
				.exceptionHandling()
				.accessDeniedHandler(new AccessDeniedHandler() {
					
					@Override
					public void handle(HttpServletRequest request, HttpServletResponse response,
							AccessDeniedException accessDeniedException) throws IOException, ServletException {
						
					}
				});
		   
	}
}
