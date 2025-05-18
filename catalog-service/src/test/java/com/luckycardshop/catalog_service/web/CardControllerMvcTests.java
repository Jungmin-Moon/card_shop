package com.luckycardshop.catalog_service.web;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.luckycardshop.catalog_service.domain.CardNotFoundException;
import com.luckycardshop.catalog_service.domain.CardService;

@Ignore("not needed atm")
@WebMvcTest(CardController.class)
public class CardControllerMvcTests {
	
	//used to test web layer in mock environment
	@Autowired
	private MockMvc mockMvc;
	
	//book had @MockBean but since that is deprecated using @MockitoBean instead
	//creates a mock CardService to be used in tests
	@MockitoBean
	private CardService cardService;
	
	@Test
	void whenGetCardNotExistingThenShouldReturn404() throws Exception {
		String name = "Pot of Greed";
		
		//defines what Exception should be thrown in this error case
		given(cardService.viewCardDetails(name)).willThrow(CardNotFoundException.class);
		
		//used to perform a GET to make sure that indeed there is no such card in the catalog
		mockMvc.perform(get("/cards/" + name))
				.andExpect(status().isNotFound());
	} 
}
