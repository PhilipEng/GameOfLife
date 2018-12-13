package gameoflife.cards;

import static org.junit.Assert.*;

import org.junit.Test;

public class DeckTest {

	@Test
	public void test_draw_card_1() {
		// Initialize Career Cards
		CareerCard actor = new CareerCard("Actor", 100000, 5);
		CareerCard inventor = new CareerCard("Inventor", 80000, 4);
		CareerCard singer = new CareerCard("Singer", 70000, 3);
		CareerCard raceCarDriver = new CareerCard("Race Car Driver", 60000, 2);
		CareerCard athlete = new CareerCard("Athlete", 50000, 1);
		CareerCard policeOfficer = new CareerCard("Police Officer", 50000, 4);
		CareerCard chef = new CareerCard("Chef", 50000, 3);
		CareerCard dancer = new CareerCard("Dancer", 50000, 2);
		
		// Initialize Career Card Deck
		Deck careerDeck = new Deck();
		careerDeck.addToDeck(actor);
		careerDeck.addToDeck(inventor);
		careerDeck.addToDeck(singer);
		careerDeck.addToDeck(raceCarDriver);
		careerDeck.addToDeck(athlete);
		careerDeck.addToDeck(policeOfficer);
		careerDeck.addToDeck(chef);
		careerDeck.addToDeck(dancer);
		
		CareerCard drawnCard = (CareerCard)careerDeck.drawFromDeck();
		
		assertEquals("First card in deck should be same as first card drawn", drawnCard, actor); //Cards added to deck go to bottom of deck
	}

	@Test
	public void test_draw_card_2() {
		// Initialize Career Cards
		CareerCard actor = new CareerCard("Actor", 100000, 5);
		CareerCard inventor = new CareerCard("Inventor", 80000, 4);
		CareerCard singer = new CareerCard("Singer", 70000, 3);
		CareerCard raceCarDriver = new CareerCard("Race Car Driver", 60000, 2);
		CareerCard athlete = new CareerCard("Athlete", 50000, 1);
		CareerCard policeOfficer = new CareerCard("Police Officer", 50000, 4);
		CareerCard chef = new CareerCard("Chef", 50000, 3);
		CareerCard dancer = new CareerCard("Dancer", 50000, 2);
		
		// Initialize Career Card Deck
		Deck careerDeck = new Deck();
		careerDeck.addToDeck(actor);
		careerDeck.addToDeck(inventor);
		careerDeck.addToDeck(singer);
		careerDeck.addToDeck(raceCarDriver);
		careerDeck.addToDeck(athlete);
		careerDeck.addToDeck(policeOfficer);
		careerDeck.addToDeck(chef);
		careerDeck.addToDeck(dancer);
		
		careerDeck.drawFromDeck();
		
		assertEquals("After a card is drawn, there should be 1 less card in the deck", careerDeck.getTotalCards(), 7); 
	}
}
