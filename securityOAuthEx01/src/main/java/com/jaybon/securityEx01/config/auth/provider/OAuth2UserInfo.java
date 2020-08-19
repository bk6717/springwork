package com.jaybon.securityEx01.config.auth.provider;

public interface OAuth2UserInfo {
	
	String getProviderId();
	String getName();
	String getEmail();
	String getProvider();
	
}
