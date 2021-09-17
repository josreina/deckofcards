/**
 * 
 */
package com.problem.statement.deckofcards.util;

import java.util.Objects;

/**
 * @author jose.reina
 *
 */
public class Card {
	
	/*The face of the card */
	public Face face;
	
	/*The suit of the card */
	public Suit suit;

	/**
	 * @return the face
	 */
	public Face getFace() {
		return face;
	}

	/**
	 * @param face the face to set
	 */
	public void setFace(Face face) {
		this.face = face;
	}

	/**
	 * @return the suit
	 */
	public Suit getSuit() {
		return suit;
	}

	/**
	 * @param suit the suit to set
	 */
	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	
	
	@Override
	  public int hashCode() {
	    return Objects.hash(this.face, this.suit);
	  }

	  @Override
	  public String toString() {
	    return "Card{" + "face=" + this.face + ", suit='" + this.suit + '}';
	  }
	

}
