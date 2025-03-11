package com.luckycardshop.catalog_service.domain;

import java.util.Optional;

public interface CardRepository {
	Iterable<Card> findAll();
	Optional<Card> findByName(String name);
	boolean existsByName(String name);
	Card save(Card card);
	void deleteByName(String name);
}
