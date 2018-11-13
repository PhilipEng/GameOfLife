package gameoflife.cards;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

/* 
 * Class builds a deck for career cards. Used for regular career 
 * cards and college career cards.
 */

public class CareerCardDeck extends Deck {
	private ArrayList<CareerCard> cards;
	
	public CareerCardDeck() {
		super();
		cards = new ArrayList<CareerCard>();
	}
	
	@Override
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	@Override
	public CareerCard drawFromDeck() {
		return cards.remove(0);
	}
	
	public void addToDeck(CareerCard card) {
		cards.add(card);
	}
	
	@Override
	public int getTotalCards() {
		return cards.size();
	}
}
