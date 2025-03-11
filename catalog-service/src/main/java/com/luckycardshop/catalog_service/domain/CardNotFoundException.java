package com.luckycardshop.catalog_service.domain;

public class CardNotFoundException extends RuntimeException{
	public CardNotFoundException(String name) {
		super("The card with name: " + name + " was not found.");
	}
}
