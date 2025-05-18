package com.luckycardshop.catalog_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {
	
	@Bean //allows GET on the / home page and /cards/** to not require authentication
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		//book had mvcMatchers which is now deprecated so it just needed to be replaced with requestMatchers
		//the jwt method in OAuth2ResourceServerConfigurer is also deprecated so it needed to be come a lambda like below
		
		return http.authorizeHttpRequests(authorize -> authorize.requestMatchers(HttpMethod.GET, "/", "/cards/**").permitAll() 
					.anyRequest().hasRole("employee")) //this states any request that isn't the above need authentication
				
					//enables OAuth2 resource server support using default based on JWT 
					.oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults())).sessionManagement(sessionManagement -> sessionManagement
											.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
					.csrf(AbstractHttpConfigurer::disable) //disabled b/c the authentication is stateless
					.build();
											
										
	}
	
	@Bean
	public JwtAuthenticationConverter jwtAuthenticationConverter() {
		//converter to map to GrantedAuthorities objects
		var jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
		
		//applying a ROLE_ prefix
		jwtGrantedAuthoritiesConverter.setAuthorityPrefix("ROLE_");
		jwtGrantedAuthoritiesConverter.setAuthoritiesClaimName("roles"); //extracts the list of roles from roles claim
		
		//used to define a strategy to convert a JWT. only customize how to build granted authorities out of it
		var jwtAuthenticationConverter = new JwtAuthenticationConverter();
		
		jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);
		
		return jwtAuthenticationConverter;
	}
	
}
