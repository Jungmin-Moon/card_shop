package com.luckycardshop.catalog_service.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.test.context.ActiveProfiles;

import com.luckycardshop.catalog_service.config.DataConfig;

@Ignore("Update later")
@DataJdbcTest
@Import (DataConfig.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("integration")
public class CardRepositoryJdbcTests {
	
	/*
	 * @DataJdbcTest marks it as a test class that focuses on Spring Data JDBC components
	 * @Import imports the data configuration(this enables auditing)
	 * @AutoConfigureTestDatabase with the given replace disables the default behaviors so that we can use testcontainers instead of an embedded
	 * @ActiveProfile is used to tell it to use this profile and load that yml
	 */
	
	
	@Autowired
	private CardRepository cardRepository;
	
	//lower level object to interact with the db
	@Autowired
	private JdbcAggregateTemplate jdbcAggregateTemplate;
	
	@Test
	void findCardByNameWhenExisting() {
		var cardName = "Pot of Greed";
		
		var card = Card.of(cardName, "Spell Card", "N/A", 0, 0, 0, 0, "N/A", "Draw 2 cards", 0, 0, 0, 5.45);
		
		jdbcAggregateTemplate.insert(card);
		
		Optional<Card> actualCard = cardRepository.findByName(cardName);
		
		assertThat(actualCard).isPresent();
		assertThat(actualCard.get().name()).isEqualTo(card.name());
	}
}
