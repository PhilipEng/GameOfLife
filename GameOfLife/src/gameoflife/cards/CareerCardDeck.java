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
	
	CareerCardDeck() {
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
	
	/*
	 * Takes the top 2 cards from the deck. User input selects which card 
	 * to keep. The unwanted card is returned to the deck.
	 */
	public CareerCard chooseCareer() {
		CareerCard careerCard1 = this.drawFromDeck();
		CareerCard careerCard2 = this.drawFromDeck();
		
		careerCard1.printDetails();
		careerCard2.printDetails();
		
		System.out.println("Choose a career: (1 / 2) "); // Needs improvement
														//Use pop up box on screen to choose
		Scanner scanner = new Scanner( System.in );
		String input = scanner.nextLine();
		int answer = Integer.parseInt(input);
		//scanner.close();
		
		if(answer == 1) {
			this.addToDeck(careerCard2);
			return careerCard1;
		}else {
			this.addToDeck(careerCard1);
			return careerCard2;
		}
		
	}
}
