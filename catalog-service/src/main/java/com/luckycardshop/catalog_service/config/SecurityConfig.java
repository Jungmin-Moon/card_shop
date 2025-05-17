package com.luckycardshop.catalog_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {
	
	@Bean //allows GET on the / home page and /cards/** to not require authentication
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		//book had mvcMatchers which is now deprecated so it just needed to be replaced with requestMatchers
		//the jwt method in OAuth2ResourceServerConfigurer is also deprecated so it needed to be come a lambda like below
		
		return http.authorizeHttpRequests(authorize -> authorize.requestMatchers(HttpMethod.GET, "/", "/cards/**").permitAll() 
					.anyRequest().authenticated()) //this states any request that isn't the above need authentication
				
					//enables OAuth2 resource server support using default based on JWT 
					.oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults())).sessionManagement(sessionManagement -> sessionManagement
											.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
					.csrf(AbstractHttpConfigurer::disable) //disabled b/c the authentication is stateless
					.build();
											
										
	}
}
