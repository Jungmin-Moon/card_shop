package com.luckycardshop.catalog_service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "cardshop")
public class CardShopProperties {
	
	/*
	 * Welcome message to users
	 */
	private String greeting;
	
	public String getGreeting() {
		return greeting;
	}
	
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
}
