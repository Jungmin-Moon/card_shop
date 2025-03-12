package com.luckycardshop.catalog_service.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.luckycardshop.catalog_service.domain.Card;
import com.luckycardshop.catalog_service.domain.CardService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("cards")
public class CardController {
	private final CardService cardService;
	
	public CardController(CardService cardService) {
		this.cardService = cardService;	
	}
	
	@GetMapping
	public Iterable<Card> get() {
		return cardService.viewCardList();
	}
	
	@GetMapping("{name}")
	public Card getByName(@PathVariable String name) {
		return cardService.viewCardDetails(name);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Card post(@Valid @RequestBody Card card) {
		return cardService.addCardToCatalog(card);
	}
	
	@DeleteMapping("{name}")
	@ResponseStatus(HttpStatus.NO_CONTENT) 
	public void delete(@PathVariable String name) {
		cardService.removeCardFromCatalog(name);
	}
	
	@PutMapping("{name}")
	public Card put(@PathVariable String name, @Valid @RequestBody Card card) {
		return cardService.editCardDetails(name, card);
	}
}
