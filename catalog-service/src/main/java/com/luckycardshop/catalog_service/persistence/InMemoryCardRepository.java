package com.luckycardshop.catalog_service.persistence;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.luckycardshop.catalog_service.domain.Card;
import com.luckycardshop.catalog_service.domain.CardRepository;

@Repository
public class InMemoryCardRepository implements CardRepository{
	
	private static final Map<String, Card> cards = new ConcurrentHashMap<>();
	
	@Override
	public Iterable<Card> findAll() {
		return cards.values();
	}
	
	@Override
	public Optional<Card> findByName(String name) {
		return existsByName(name) ? Optional.of(cards.get(name)) : Optional.empty();
	}
	
	@Override
	public boolean existsByName(String name) {
		return cards.get(name) != null;
	}
	
	@Override
	public Card save(Card card) { 
		cards.put(card.name(), card);
		return card;
	}
	
	@Override
	public void deleteByName(String name) {
		cards.remove(name);
	}
}
