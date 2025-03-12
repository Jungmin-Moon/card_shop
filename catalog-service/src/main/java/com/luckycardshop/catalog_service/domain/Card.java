package com.luckycardshop.catalog_service.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record Card(
	
	@NotBlank(message = "Name must be defined")
	@Pattern(regexp = "[a-zA-Z &+-.*]")
	String name,
	
	@NotBlank(message = "Card type must be defined")
	@Pattern(regexp = "[a-zA-Z ]")
	String cardType,
	
	@NotBlank(message = "Attribute must be defined")
	@Pattern(regexp = "[a-zA-Z]")
	String attribute,
	
	@NotBlank(message = "Level must be defined")
	@Pattern(regexp = "([0-9]|1[0-2])", message = "Level must be between 0 and 12")
	int level,
	
	@NotBlank(message = "Rank must be defined")
	@Pattern(regexp = "([0-9]|1[0-2])", message = "Rank must be between 0 and 12")
	int rank,
	
	@NotBlank(message = "Pendulum Scale must be defined")
	@Pattern(regexp = "([0-9]|1[0-2])", message = "Pendulum Scale must be between 0 and 12")
	int pendScale,
	
	@NotBlank(message = "How many link arrows must be defined")
	@Pattern(regexp = "([1-8])", message = "Link Arrows must be between 1 and 8")
	int linkArrows,
	
	@NotBlank(message = "Monster type must be defined")
	@Pattern(regexp = "[a-zA-Z -]")
	String monsterType,
	
	@NotBlank(message = "The text in the box must be defined")
	@Pattern(regexp = "[a-zA-Z &+-.*]")
	String textBoxText,
	
	@NotBlank(message = "Attack must be defined")
	@Pattern(regexp = "([0-9]|[1-9][0-9]{1,3}|10000)", message = "Atk must be between 0 and 10,000")
	int atk,
	
	@NotBlank(message = "Defense must be defined")
	@Pattern(regexp = "([0-9]|[1-9][0-9]{1,3}|10000)", message = "Def must be between 0 and 10,000")
	int def,
	
	@NotBlank(message = "Link must be defined")
	@Pattern(regexp = "([1-9]|[1-9][0-9])", message = "Link rating must be between 1 and 99")
	int link,
	
	@NotBlank(message = "Price must be defined")
	@Positive(message = "The price must be greater than zero.")
	Double price
) {}
