package com.luckycardshop.catalog_service.demo;

import java.util.List;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.luckycardshop.catalog_service.domain.Card;
import com.luckycardshop.catalog_service.domain.CardRepository;

@Component
@Profile("testdata")
public class CardDataLoader {
	//easy way to switch profiles when running from Eclipse IDE is in Boot Dashboard, right click the project, open config and change profile
	
	
	private final CardRepository cardRepository;
	
	public CardDataLoader(CardRepository cardRepository) {
		this.cardRepository = cardRepository;
	}
	
	//had to be updated since Card record now has a Long id and int version with a constructor
	//framework will handle those values as long as everything else is supplied
	@EventListener(ApplicationReadyEvent.class)
	public void loadCardTestData() {
		cardRepository.deleteAll();
		var card1 = Card.of("Pot of Greed", "Spell Card", "N/A", 0, 0, 0, 0, "N/A", "Draw 2 cards", 0, 0, 0, 5.45);
		
		var impermText = "Target 1 face-up monster your opponent controls; negate its effects (until the end of this turn), then, "
				+ "if this card was set before activation and is on the field at resolution, for the rest of this turn all other Spell/Trap effects in this column are negated. If you control no cards, you can activate this "
				+ "card from your hand.";
		var card2 = Card.of("Infinite Impermanence", "Trap Card", "N/A", 0, 0, 0, 0, "N/A", impermText, 0, 0, 0, 15.56);
		cardRepository.saveAll(List.of(card1, card2));
	}
}
