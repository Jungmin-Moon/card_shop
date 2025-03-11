package com.luckycardshop.catalog_service.domain;

public class CardAlreadyExistsException extends RuntimeException{
	public CardAlreadyExistsException(String name) {
		super("A card with that name: " + name + " already exists.");
	}
}
