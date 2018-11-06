package gameoflife.cards;

import java.util.ArrayList;
import java.util.Collections;


public class ActionCardDeck extends Deck {
	private ArrayList<ActionCard> cards;
	
	public ActionCardDeck() {
		super();
		cards = new ArrayList<ActionCard>();
	}
	
	@Override
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	@Override
	public ActionCard drawFromDeck() {
		return cards.remove(0);
	}
	
	public void addToDeck(ActionCard card) {
		cards.add(card);
	}
	
	@Override
	public int getTotalCards() {
		return cards.size();
	}

}
