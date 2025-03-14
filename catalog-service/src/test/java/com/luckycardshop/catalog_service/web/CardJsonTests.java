package com.luckycardshop.catalog_service.web;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import com.luckycardshop.catalog_service.domain.Card;

//annotation that tells people and compiler this class is for JSON serialization and deserialization tests
@JsonTest
public class CardJsonTests {
	
	//loads the utility class to assert JSON serialization and deserialization
	@Autowired
	private JacksonTester<Card> json;
	
	@Test
	void testSerialize() throws Exception {
		
		//establishing what object we want to test the serialization of
		var card = new Card("Pot of Greed", "Spell Card", "N/A", 0, 0, 0, 0, "N/A", "Draw 2 cards", 0, 0, 0, 5.45);
		
		//this actually parses it using the utility class on the Object in this case card
		var jsonContent = json.write(card);
		
		//the assertions are checking that the parsed JSON object has the same values for each field like the card object
		assertThat(jsonContent).extractingJsonPathStringValue("@.name").isEqualTo(card.name());
		assertThat(jsonContent).extractingJsonPathStringValue("@.cardType").isEqualTo(card.cardType());
		assertThat(jsonContent).extractingJsonPathStringValue("@.attribute").isEqualTo(card.attribute());
		assertThat(jsonContent).extractingJsonPathNumberValue("@.level").isEqualTo(card.level());
		assertThat(jsonContent).extractingJsonPathNumberValue("@.rank").isEqualTo(card.rank());
		assertThat(jsonContent).extractingJsonPathNumberValue("@.pendScale").isEqualTo(card.pendScale());
		assertThat(jsonContent).extractingJsonPathNumberValue("@.linkArrows").isEqualTo(card.linkArrows());
		assertThat(jsonContent).extractingJsonPathStringValue("@.monsterType").isEqualTo(card.monsterType());
		assertThat(jsonContent).extractingJsonPathStringValue("@.textBoxText").isEqualTo(card.textBoxText());
		assertThat(jsonContent).extractingJsonPathNumberValue("@.atk").isEqualTo(card.atk());
		assertThat(jsonContent).extractingJsonPathNumberValue("@.def").isEqualTo(card.def());
		assertThat(jsonContent).extractingJsonPathNumberValue("@.link").isEqualTo(card.link());
		assertThat(jsonContent).extractingJsonPathNumberValue("@.price").isEqualTo(card.price());
	}
	
	@Test
	void testDeserialize() throws Exception {
		
		//this is creating a JSON body to test
		var content = """
				{
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
				""";
		
		//checking that when the json above is parsed through the values are equal to the ones passed in the new Card object
		assertThat(json.parse(content))
				.usingRecursiveComparison()
				.isEqualTo(new Card("Pot of Greed", "Spell Card", "N/A", 0, 0, 0, 0, "N/A", "Draw 2 cards", 0, 0, 0, 5.45));
	}
}
