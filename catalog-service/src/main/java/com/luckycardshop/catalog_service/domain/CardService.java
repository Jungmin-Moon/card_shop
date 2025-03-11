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
					var cardToUpdate = new Card(existingCard.name(),
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
										card.price());
					return cardRepository.save(cardToUpdate);
					
				}).orElseGet(() -> addCardToCatalog(card));
	}
}