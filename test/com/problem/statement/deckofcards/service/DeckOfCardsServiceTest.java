package com.problem.statement.deckofcards.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.problem.statement.deckofcards.service.DeckOfCardsService;
import com.problem.statement.deckofcards.service.impl.DeckOfCardsServiceImpl;
import com.problem.statement.deckofcards.util.Card;
import com.problem.statement.deckofcards.util.DeckOfCardsConstants;

public class DeckOfCardsServiceTest {
	
	private DeckOfCardsService cardsService;
	
	private List<Card> deck;
	
	private List<Card> auxDeck;
	
	private Card card;
	
	
	/**
	 * @throws Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		deck = new ArrayList<Card>(DeckOfCardsConstants.DECK_SIZE);
		
		auxDeck = new ArrayList<Card>(DeckOfCardsConstants.DECK_SIZE);
		
		cardsService = new DeckOfCardsServiceImpl();
		
		card = new Card();
		
	}
	
	@Test
	public final void testSetUpDeck() throws Exception{
		
		cardsService.setUpDeck();
		this.deck = cardsService.getDeck();
		assertNotNull(this.deck, DeckOfCardsConstants.DECK_MSG + DeckOfCardsConstants.EMPTY_STR + 
				DeckOfCardsConstants.NOT_NULL_MSG);  
		assertEquals(this.deck.size(),DeckOfCardsConstants.DECK_SIZE);
	    
	}
		
	@Test
	public final void testShuffle() throws Exception{
		
		cardsService.shuffle();
		this.deck = cardsService.getDeck();
		cardsService.shuffle();
		this.auxDeck = cardsService.getDeck();
		assertNotNull(this.deck, DeckOfCardsConstants.DECK_MSG + DeckOfCardsConstants.EMPTY_STR + 
				DeckOfCardsConstants.NOT_NULL_MSG);
		assertNotNull(this.auxDeck, DeckOfCardsConstants.DECK_MSG + DeckOfCardsConstants.EMPTY_STR + 
				DeckOfCardsConstants.NOT_NULL_MSG);  

		assertEquals(this.deck.size(), DeckOfCardsConstants.DECK_SIZE);
		assertEquals(this.auxDeck.size(), DeckOfCardsConstants.DECK_SIZE);
		
		assertNotEquals(this.auxDeck, this.deck);
		 
	}
	
	@Test
	public final void testDealOneCard() throws Exception{
		
		cardsService.shuffle();
		this.deck = cardsService.getDeck();
		assertNotNull(this.deck, DeckOfCardsConstants.DECK_MSG + DeckOfCardsConstants.EMPTY_STR + 
				DeckOfCardsConstants.NOT_NULL_MSG);
		assertEquals(this.deck.size(), DeckOfCardsConstants.DECK_SIZE);
		
		card = cardsService.dealOneCard();
		assertNotNull(this.card, DeckOfCardsConstants.CARD_MSG + DeckOfCardsConstants.EMPTY_STR + 
				DeckOfCardsConstants.NOT_NULL_MSG);
		assertNotNull(this.card.getFace(), DeckOfCardsConstants.FACE_MSG + DeckOfCardsConstants.EMPTY_STR + 
				DeckOfCardsConstants.NOT_NULL_MSG);
		assertNotNull(this.card.getSuit(), DeckOfCardsConstants.SUIT_MSG + DeckOfCardsConstants.EMPTY_STR + 
				DeckOfCardsConstants.NOT_NULL_MSG);
		this.deck = cardsService.getDeck();
		assertEquals(this.deck.size(), DeckOfCardsConstants.DECK_SIZE-1);
		
	}
	
	@Test
	public final void testDealAllCards() throws Exception{
		
		cardsService.shuffle();
		this.deck = cardsService.getDeck();
		
		assertNotNull(this.deck, DeckOfCardsConstants.DECK_MSG + DeckOfCardsConstants.EMPTY_STR + 
				DeckOfCardsConstants.NOT_NULL_MSG);
		assertEquals(this.deck.size(), DeckOfCardsConstants.DECK_SIZE);
		
		
		assertEquals(this.deck.size(), DeckOfCardsConstants.DECK_SIZE);
		
		//Loop to deal all the cards 
		while (deck.size() > 0) {
			card = cardsService.dealOneCard();
			assertNotNull(this.card, DeckOfCardsConstants.CARD_MSG + DeckOfCardsConstants.EMPTY_STR + 
					DeckOfCardsConstants.NOT_NULL_MSG);
			assertNotNull(this.card.getFace(), DeckOfCardsConstants.FACE_MSG + DeckOfCardsConstants.EMPTY_STR + 
					DeckOfCardsConstants.NOT_NULL_MSG);
			assertNotNull(this.card.getSuit(), DeckOfCardsConstants.SUIT_MSG + DeckOfCardsConstants.EMPTY_STR + 
					DeckOfCardsConstants.NOT_NULL_MSG);
			this.deck = cardsService.getDeck();
		}
		
		//Check after the deck is empty a null value is returned
		card = cardsService.dealOneCard();
		assertNull(card);
	    
	}

}
