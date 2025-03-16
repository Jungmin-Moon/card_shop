package com.luckycardshop.catalog_service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

//annotation that creates the custom property and assigns it a gloabl prefix
@ConfigurationProperties(prefix = "cardshop")
public class CardShopProperties {
	
	/*
	 * Welcome message to users
	 */
	private String greeting;
	//this class could now hold many more custom properties which we add to the application.yml and just get/set them without worrying about multiple files
	
	public String getGreeting() {
		return greeting;
	}
	
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
}
