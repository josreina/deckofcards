package com.problem.statement.deckofcards.service;

import java.util.List;

import com.problem.statement.deckofcards.util.Card;

/* @author: josreina */
public interface DeckOfCardsService {
	

	/* method to set up initially de deck with all the cards */
	public void setUpDeck();
	
	/* method to shuffle the deck of cards */
	public void shuffle();
	
	/* method to deal one card of the remaining on the deck */
	public Card dealOneCard();
	
	public List<Card> getDeck();

}
