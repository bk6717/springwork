package com.cos.springStudy.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cos.springStudy.config.aop.SessionIntercepter;

@Configuration //필터링
public class WebConfig implements WebMvcConfigurer{ //web.xml 처럼 작동한다.

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new SessionIntercepter())
			.addPathPatterns("/user/**");
	}
}