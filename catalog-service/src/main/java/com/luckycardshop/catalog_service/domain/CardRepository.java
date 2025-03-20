package com.luckycardshop.catalog_service.domain;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface CardRepository extends CrudRepository<Card, Long>{
	
	Optional<Card> findByName(String name);
	boolean existsByName(String name);
	
	@Modifying
	@Transactional
	@Query("DELETE FROM Card where name = :name")
	void deleteByName(String name);
}
