package com.luckycardshop.catalog_service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.luckycardshop.catalog_service.domain.Card;

//this loads a full Spring web app context and a Servlet container on a random port
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CatalogServiceApplicationTests {

	@Autowired
	private WebTestClient webTestClient;
	
	@Test
	void contextLoads() {
	}
	//will update tests later
	/*
	@Test
	void whenPostRequestThenCardCreated() {
		//this is a new card to test
		var card = new Card("Pot of Greed", "Spell Card", "N/A", 0, 0, 0, 0, "N/A", "Draw 2 cards", 0, 0, 0, 5.45);
		
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
