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
	@Pattern(regexp = "^[a-zA-Z0-9 !@#&-.+,/\"]*$", message = "Name should not be empty and be valid.")
	String name,
	
	@NotBlank(message = "Card type must be defined")
	@Pattern(regexp = "^[a-zA-Z ]*$", message = "Card type can only be: Ritual, Fusion, Synchro, XYZ, Pendulum, Link, Spell Card or Trap Card.")
	String cardType,
	
	@NotBlank(message = "Attribute must be defined")
	@Pattern(regexp = "^[a-zA-Z/]*$", message = "Attribute can only be: Light, Dark, Water, Fire, Earth, Wind or Divine")
	String attribute,
	
	//@Range with min and max is much easier to use for Integers
	@NotNull(message = "Level must be defined")
	@Range(min = 0, max = 12, message = "Level must be between 0 and 12")
	int level,
	
	@NotNull(message = "Rank must be defined")
	@Range(min = 0, max = 12, message = "Rank must be between 0 and 12")
	int rank,
	
	@NotNull(message = "Pendulum Scale must be defined")
	@Range(min = 0, max = 12, message = "Pendulum Scale must be between 0 and 12")
	int pendScale,
	
	@NotNull(message = "How many link arrows must be defined")
	@Range(min = 0, max = 8, message = "Link arrows must be between 0 and 8")
	int linkArrows,
	
	@NotBlank(message = "Monster type must be defined")
	@Pattern(regexp = "^[a-zA-Z -/]*$", message = "Monster Type can only be one of 26 types and can have at most one space or dash or N/A if it is a spell or trap card")
	String monsterType,
	
	@NotBlank(message = "The text in the box must be defined")
	@Pattern(regexp = "^[a-zA-Z0-9 !@#$&()\\\\-`.+,/\\\"]*$")
	String textBoxText,
	
	@NotNull(message = "Attack must be defined")
	@Range(min = 0, max = 10000, message = "Attack must be between 0 and 10000")
	int atk,
	
	@NotNull(message = "Defense must be defined")
	@Range(min = 0, max = 10000, message = "Defense must be between 0 and 10000")
	int def,
	
	@NotNull(message = "Link must be defined")
	@Range(min = 0, max = 99, message = "Link materials must be between 0 and 99")
	int link,
	
	@NotNull(message = "Price must be defined")
	@Positive(message = "The price must be greater than zero.")
	Double price
) {}
