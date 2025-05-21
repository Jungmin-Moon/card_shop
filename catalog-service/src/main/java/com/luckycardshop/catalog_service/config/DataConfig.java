package com.luckycardshop.catalog_service.config;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
@EnableJdbcAuditing
public class DataConfig {
	
	

	@Bean
	AuditorAware<String> auditorAware() {
		return () -> Optional.ofNullable(SecurityContextHolder.getContext()) //gets the security context for currently authenticated user
							.map(SecurityContext::getAuthentication) //extracts the authentication object for the currently authenticated user
							.filter(Authentication::isAuthenticated)
							.map(Authentication::getName); //gets their username
	}
}
