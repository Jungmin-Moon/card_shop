package com.luckycardshop.catalog_service.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class CardValidationTests {
	private static Validator validator;
	
	//this executes before all tests in the class
	@BeforeAll
	static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	//identifies test case
	@Test
	void whenAllFieldsCorrectThenValidationSucceeds() {
		Card card = new Card("Pot of Greed", "Spell Card", "N/A", 0, 0, 0, 0, "N/A", "Draw 2 cards", 0, 0, 0, 5.45); //testing a new Card object
		
		//creates a set that will hold any and all validation violations the above test case might produce
		Set<ConstraintViolation<Card>> violations = validator.validate(card);
		
		//checks that if the Set is empty then no errors were made 
		assertThat(violations).isEmpty();
	}
	
	@Test
	void whenNameDefinedButIncorrectThenValidationFails() {
		//now testing each value individually instead, in this case name
		Card card = new Card("", "Spell Card", "N/A", 0, 0, 0, 0, "N/A", "Draw 2 cards", 0, 0, 0, 5.45); //testing a new Card object
		
		//just like above test it is going to house the validation errors in this case only the card name 
		Set<ConstraintViolation<Card>> violations = validator.validate(card);
		
		//is asserting that the only error here should be name validation so it should have a size of 1
		assertThat(violations).hasSize(1);
		
		//is asserting that the message is equal to the message that is defined by the @NotBlank message in Card
		assertThat(violations.iterator().next().getMessage()).isEqualTo("Name should not be empty and be valid.");
	}
}
