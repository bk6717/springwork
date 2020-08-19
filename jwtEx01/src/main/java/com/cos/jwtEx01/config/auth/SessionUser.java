package com.cos.jwtEx01.config.auth;

import java.util.List;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SessionUser {
	private long id;
	private String username;
	private List<String> roles;
}
