package com.problem.statement.deckofcards.main;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.problem.statement.deckofcards.service.DeckOfCardsService;
import com.problem.statement.deckofcards.service.impl.DeckOfCardsServiceImpl;
import com.problem.statement.deckofcards.util.Card;
import com.problem.statement.deckofcards.util.DeckOfCardsConstants;

public class Main {
	
	//Main method to check the implementation of the services are working as expected
	private static final Logger LOGGER = Logger.getLogger("Main");
			
	public static void main(String[] args) {
		
		DeckOfCardsService cardsService = new DeckOfCardsServiceImpl();
		
		//Assumed the deck is going to be handled by the client, so if multiple
		// clients use the methods with different decks at the same time 
		//the service will be prepared
		List<Card> deck = new ArrayList<Card>(DeckOfCardsConstants.DECK_SIZE);
		
		try {
		
			cardsService.shuffle();
			
			deck = cardsService.getDeck();
			
			//Print in the logs the random shuffled deck
			for(Card card : deck) {
				LOGGER.log(Level.INFO, DeckOfCardsConstants.CARD_MSG + DeckOfCardsConstants.COLON_STR + 
						DeckOfCardsConstants.EMPTY_STR + card.suit.toString()
				+ DeckOfCardsConstants.EMPTY_STR + card.face.toString());
			}
			
			//Print in the logs the card dealt and the remaining ones
			LOGGER.log(Level.INFO, DeckOfCardsConstants.DEALING_MSG);
			while (deck.size() > 0) {
				Card card = cardsService.dealOneCard();
				
				if (card != null) {
					LOGGER.log(Level.INFO, DeckOfCardsConstants.CARD_MSG + DeckOfCardsConstants.COLON_STR + 
							DeckOfCardsConstants.EMPTY_STR + DeckOfCardsConstants.EMPTY_STR + card.suit.toString() 
					+ DeckOfCardsConstants.EMPTY_STR + card.face.toString());
				} else {
					LOGGER.log(Level.INFO, DeckOfCardsConstants.EMPTY_DECK_MSG);
				}
			}
			//Calling the dealOneCard service with the empty deck
			Card card = cardsService.dealOneCard();
			if (card == null) {
				//Print in the logs the empty deck
				LOGGER.log(Level.INFO, DeckOfCardsConstants.EMPTY_DECK_MSG);
			}
		} catch (NullPointerException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		} catch (IndexOutOfBoundsException ioe) {
			LOGGER.log(Level.SEVERE, ioe.getMessage());
		}

	}

}
