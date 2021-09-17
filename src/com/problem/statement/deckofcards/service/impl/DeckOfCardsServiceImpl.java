package com.problem.statement.deckofcards.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.problem.statement.deckofcards.service.DeckOfCardsService;
import com.problem.statement.deckofcards.util.Card;
import com.problem.statement.deckofcards.util.DeckOfCardsConstants;
import com.problem.statement.deckofcards.util.Face;
import com.problem.statement.deckofcards.util.Suit;

public class DeckOfCardsServiceImpl implements DeckOfCardsService{
	
	private static final Logger LOGGER = Logger.getLogger("DeckOfCardsServiceImpl");
	
	private List<Card> deck = new ArrayList<Card>(DeckOfCardsConstants.DECK_SIZE);
	
	/* method to set up initially the deck with all the cards */
	public void setUpDeck() {
		
		try {
			this.deck = new ArrayList<Card>(DeckOfCardsConstants.DECK_SIZE);
			
			for (Suit suit : Suit.values()) {
				for (Face face : Face.values()) {	
					Card card = new Card();
					card.setFace(face);
					card.setSuit(suit);
					deck.add(card);
				}
				
			}
		
		}
		catch (IllegalArgumentException iaE) {
			LOGGER.log(Level.SEVERE, iaE.getMessage());
		}
		catch (NullPointerException nE) {
			LOGGER.log(Level.SEVERE, nE.getMessage());
		} 
		catch (UnsupportedOperationException uoE) {
			LOGGER.log(Level.SEVERE, uoE.getMessage());
		}
		catch (ClassCastException ccE) {
			LOGGER.log(Level.SEVERE, ccE.getMessage());
		}
		
	}
	
	/* method to shuffle the deck of cards */
	public void shuffle() {
		try {
			int change = 0;
			
			//I assume the shuffle is made at the beginning of the game, so we need to setUp the deck first
			setUpDeck();
			
	        Random random = new Random();
	        for (Card card : this.deck) {
	        	//To shuffle the cards we need to positions in the list and randomly swap them
	            change = this.deck.indexOf(card) + random.nextInt(this.deck.size() - this.deck.indexOf(card));
	            swap(this.deck, this.deck.indexOf(card), change);
	        }
		}catch (IllegalArgumentException iaE) {
			LOGGER.log(Level.SEVERE, iaE.getMessage());
		}
		catch (NullPointerException nE) {
			LOGGER.log(Level.SEVERE, nE.getMessage());
		} 
		catch (UnsupportedOperationException uoE) {
			LOGGER.log(Level.SEVERE, uoE.getMessage());
		}
		catch (ClassCastException ccE) {
			LOGGER.log(Level.SEVERE, ccE.getMessage());
		}
		catch (IndexOutOfBoundsException iobE) {
			LOGGER.log(Level.SEVERE, iobE.getMessage());
		}
		
		
	}
	
	/* method to deal one card of the remaining on the deck */
	public Card dealOneCard() {
		
		Card result = null;
		
		try {
			
			Random random = new Random();
			
			if (!this.deck.isEmpty()) {	
				int pos = random.nextInt(this.deck.size());
				if (this.deck.get(pos) != null) {
					result = this.deck.get(pos);
					this.deck.remove(result);
				} else {
					dealOneCard();
				}
			}
		
		} catch (NullPointerException nE) {
			LOGGER.log(Level.SEVERE, nE.getMessage());
		} 
		catch (UnsupportedOperationException uoE) {
			LOGGER.log(Level.SEVERE, uoE.getMessage());
		}
		catch (ClassCastException ccE) {
			LOGGER.log(Level.SEVERE, ccE.getMessage());
		}
		catch (IndexOutOfBoundsException iobE) {
			LOGGER.log(Level.SEVERE, iobE.getMessage());
		}
			
			
		return result;
	}
	
	public List<Card> getDeck(){
		return this.deck;
	}
	
	/* Auxiliar Method to swap cards in two random positions */
	private static void swap(List<Card> a, int i, int change) throws UnsupportedOperationException, ClassCastException,
	NullPointerException, IllegalArgumentException, IndexOutOfBoundsException {
        Card helper = a.get(i);
        a.set(i, a.get(change));
        a.set(change, helper);
    }
	

}
