package gameoflife.cards;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

/* 
 * Class builds a deck for house cards. 
 */

public class HouseCardDeck extends Deck {
	private ArrayList<HouseCard> cards;
	
	public HouseCardDeck() {
		super();
		cards = new ArrayList<HouseCard>();
	}
	
	@Override
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	@Override
	public HouseCard drawFromDeck() {
		return cards.remove(0);
	}
	
	public void addToDeck(HouseCard card) {
		cards.add(card);
	}
	
	@Override
	public int getTotalCards() {
		return cards.size();
	}
	
	/*
	 * Takes the top 2 cards from the deck. User input selects which card 
	 * to keep. The unwanted card is returned to the deck.
	 */
	public HouseCard chooseHouse() {
		HouseCard houseCard1 = this.drawFromDeck();
		HouseCard houseCard2 = this.drawFromDeck();
		
		houseCard1.printDetails();
		houseCard2.printDetails();
		
		System.out.println("Choose a house: (1 / 2) "); // Needs improvement
														//Use pop up box on screen to choose
		Scanner scanner = new Scanner( System.in );
		String input = scanner.nextLine();
		int answer = Integer.parseInt(input);
		//scanner.close();
		
		if(answer == 1) {
			this.addToDeck(houseCard2);
			return houseCard1;
		}else {
			this.addToDeck(houseCard1);
			return houseCard2;
		}
		
	}
}
