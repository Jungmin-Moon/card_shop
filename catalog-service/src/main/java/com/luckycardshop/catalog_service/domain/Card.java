package com.luckycardshop.catalog_service.domain;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record Card(
	
	/*
	 * Learned about @NotBlank annotation and @Pattern for regexp on fields 
	 */
		
	@NotBlank(message = "Name must be defined")
	@Pattern(regexp = "^[a-zA-Z0-9 !@#$&()\\-`.+,/\"]*$")
	String name,
	
	@NotBlank(message = "Card type must be defined")
	@Pattern(regexp = "^[a-zA-Z0-9 !@#$&()\\\\-`.+,/\\\"]*$")
	String cardType,
	
	@NotBlank(message = "Attribute must be defined")
	@Pattern(regexp = "^[a-zA-Z0-9!@#$&()\\\\-`.+,/\\\"]*$")
	String attribute,
	
	//@Range with min and max is much easier to use for Integers
	@NotNull(message = "Level must be defined")
	@Range(min = 0, max = 12)
	int level,
	
	@NotNull(message = "Rank must be defined")
	@Range(min = 0, max = 12)
	int rank,
	
	@NotNull(message = "Pendulum Scale must be defined")
	@Range(min = 0, max = 12)
	int pendScale,
	
	@NotNull(message = "How many link arrows must be defined")
	@Range(min = 0, max = 8)
	int linkArrows,
	
	@NotBlank(message = "Monster type must be defined")
	@Pattern(regexp = "^[a-zA-Z0-9 !@#$&()\\\\-`.+,/\\\"]*$")
	String monsterType,
	
	@NotBlank(message = "The text in the box must be defined")
	@Pattern(regexp = "^[a-zA-Z0-9 !@#$&()\\\\-`.+,/\\\"]*$")
	String textBoxText,
	
	@NotNull(message = "Attack must be defined")
	@Range(min = 0, max = 10000)
	int atk,
	
	@NotNull(message = "Defense must be defined")
	@Range(min = 0, max = 10000)
	int def,
	
	@NotNull(message = "Link must be defined")
	@Range(min = 0, max = 99)
	int link,
	
	@NotNull(message = "Price must be defined")
	@Positive(message = "The price must be greater than zero.")
	Double price
) {}
