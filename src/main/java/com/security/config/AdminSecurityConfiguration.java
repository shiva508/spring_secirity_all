package com.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;

//@Configuration
public class AdminSecurityConfiguration extends WebSecurityConfigurerAdapter {
	private AuthenticationEntryPoint getDigetstEntryPoint() {
		DigestAuthenticationEntryPoint entryPoint = new DigestAuthenticationEntryPoint();
		entryPoint.setRealmName("admin-digest-realm");
		entryPoint.setKey("fkksss_+");
		return entryPoint;
	}
}
