package com.cos.securityex01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//메모리에 한번만뜨면 되기때문에 @Configuration
@Configuration //ioC bean을 등록
@EnableWebSecurity // 필터 체인 관리 시작
@EnableGlobalMethodSecurity(prePostEnabled = true)//특정주소 접근시 권한 및 인증을 미리체크
//타입이 WebSecurityConfigurerAdapter
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Bean
	public BCryptPasswordEncoder encodePwd() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable(); //csrf-token 비활성화 코드
		
		http.authorizeRequests()
			.antMatchers("/user/**","/admin/**") //내부적으로 무한으로 오버로딩이 되어있다.
			.authenticated() 
			.anyRequest()
			.permitAll()
		.and()
			.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/loginProc")
			.defaultSuccessUrl("/");
		//  "/"를 제외 한 나머지 주소들은 인증을 해야한다. 
	}
}
