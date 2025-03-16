package com.luckycardshop.catalog_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luckycardshop.catalog_service.config.CardShopProperties;

@RestController
public class HomeController {
	
	private final CardShopProperties cardShopProperties;
	
	public HomeController(CardShopProperties cardShopProperties) {
		this.cardShopProperties = cardShopProperties;
	}
	
	@GetMapping("/")
	public String getGreeting() {
		//now instead of hard coding it in the controller can edit the application.yml and edit the greeting whenever and future properties as well.
		return cardShopProperties.getGreeting();
	}
}
