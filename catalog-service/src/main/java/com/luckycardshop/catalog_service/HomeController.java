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
		return cardShopProperties.getGreeting();
	}
}
