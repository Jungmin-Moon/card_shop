package com.luckycardshop.catalog_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

//this loads a full Spring web app context and a Servlet container on a random port
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("integration")
class CatalogServiceApplicationTests {

	@Autowired
	private WebTestClient webTestClient;
	
	//update this later when an embedded db is part of the pom dependencies
	/*
	@Test
	void contextLoads() {
	} */
	//will update tests later
	/* This also has to be updated later when an embedded server or similar is available for testing purposes
	@Test
	void whenPostRequestThenCardCreated() {
		//this is a new card to test
		var card = Card.of("Pot of Greed", "Spell Card", "N/A", 0, 0, 0, 0, "N/A", "Draw 2 cards", 0, 0, 0, 5.45);
		
		//checking that when we do a post request on the /cards uri
		//that the body we are sending which is card, that the status is that it was created
		//then we are checking to make sure that 
		//exchange() sends the request
		//we are expecting it to not be null and be a Card object
		//then checking to make sure the card created is the same as the card passed
		webTestClient.post()
					.uri("/cards")
					.bodyValue(card)
					.exchange()
					.expectStatus().isCreated()
					.expectBody(Card.class).value(actualCard -> {
						assertThat(actualCard).isNotNull();
						assertThat(actualCard.name()).isEqualTo(card.name());
					});
	} */
}
