package com.cos.securityex01.config.auth;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.securityex01.model.User;

import lombok.Data;
@Data
//Authentication 객체에 저장할 수 있는 유일한 타입 
public class PrincipalDetails implements UserDetails{

	private User user;		
	
	
	public PrincipalDetails(User user) {
		super();
		this.user = user;
	}
	
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}
	
	//사용자가 만료된지를 알고싶을때
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	//잠금걸려있는 사용자 
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	
	//비밀번호 만료
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	//계정 활성화
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	//권한
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}
	
}
