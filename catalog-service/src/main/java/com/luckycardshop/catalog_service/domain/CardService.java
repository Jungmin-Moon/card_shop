package com.luckycardshop.catalog_service.domain;

import org.springframework.stereotype.Service;
import com.luckycardshop.catalog_service.domain.Card;

@Service
public class CardService {
	private final CardRepository cardRepository;
	
	public CardService(CardRepository cardRepository) {
		this.cardRepository = cardRepository;
	}
	
	public Iterable<Card> viewCardList() {
		return cardRepository.findAll();
	}
	
	public Card viewCardDetails(String cardName) {
		return cardRepository.findByName(cardName).orElseThrow( () -> new CardNotFoundException(cardName));
	}
	
	public Card addCardToCatalog(Card card) {
		if (cardRepository.existsByName(card.name())) {
			throw new CardAlreadyExistsException(card.name());
		}
		
		return cardRepository.save(card);
	}
	
	public void removeCardFromCatalog(String name) {
		cardRepository.deleteByName(name);
	}
	
	public Card editCardDetails(String name, Card card) {
		return cardRepository.findByName(name)
				.map(existingCard -> {
					var cardToUpdate = new Card(existingCard.id(),
										existingCard.name(),
										card.cardType(),
										card.attribute(),
										card.level(),
										card.rank(),
										card.pendScale(),
										card.linkArrows(),
										card.monsterType(),
										card.textBoxText(),
										card.atk(),
										card.def(),
										card.link(),
										card.price(),
										existingCard.createdDate(),
										existingCard.lastModifiedDate(),
										existingCard.version());
					return cardRepository.save(cardToUpdate);
					
				}).orElseGet(() -> addCardToCatalog(card));
	}
	
	
	/*
	 * Test card to use in PostMan
	 * {
    "name": "Pot of Greed",
    "cardType": "Spell Card",
    "attribute": "N/A",
    "level": 0,
    "rank": 0,
    "pendScale": 0,
    "linkArrows": 0,
    "monsterType": "N/A",
    "textBoxText": "Draw 2 cards",
    "atk": 0, 
    "def": 0,
    "link": 0,
    "price": 5.45
	}	
	 */
}