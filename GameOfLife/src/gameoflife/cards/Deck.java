package gameoflife.cards;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	private ArrayList<Card> cards;
	
	/**
	 * Deck constructor
	 */
	public Deck() {
		cards = new ArrayList<Card>();
	}
	
	/**
	 * Shuffle method to shuffle decks
	 */
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	/**
	 * drawFromDeck draws a card from the deck
	 * @return Returns a card
	 */
	public Card drawFromDeck() {
		return cards.remove(0);
	}
	
	/** 
	 * Adds a card to the deck
	 * @param card Card to be added to deck
	 */
	public void addToDeck(Card card) {
		cards.add(card);
	}
	
	/**
	 * Gets total number of cards in deck
	 * @return Returns int of number of cards
	 */
	public int getTotalCards() {
		return cards.size();
	}
}
