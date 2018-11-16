package gameoflife.cards;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	private ArrayList<Card> cards;
	
	public Deck() {
		cards = new ArrayList<Card>();
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public Card drawFromDeck() {
		return cards.remove(0);
	}
	
	public void addToDeck(Card card) {
		cards.add(card);
	}
	
	public int getTotalCards() {
		return cards.size();
	}
}
