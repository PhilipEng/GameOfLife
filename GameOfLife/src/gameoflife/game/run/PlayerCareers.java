package gameoflife.game.run;

import java.util.Scanner;

import gameoflife.cards.CareerCard;
import gameoflife.cards.Deck;
import gameoflife.game.util.OfferChoice;
import gameoflife.player.Player;

public class PlayerCareers {
	
	public PlayerCareers() {
		
	}
	
	public void educatePlayer(Player player) {
		player.getStatistics().educate();
		player.getBankAccount().decreaseBalance(100000);
	}
	
	public void choosePlayerCareer(Player player, Deck careerDeck, Deck collegeDeck) {
		if(player.getStatistics().isEducated()) {
			if(player.getInventory().getCareer() != null) {
				collegeDeck.addToDeck((CareerCard) player.getInventory().getCareer());
			}
			player.getInventory().setCareer(chooseCareer(collegeDeck));
		} else {
			if(player.getInventory().getCareer() != null) {
				careerDeck.addToDeck((CareerCard) player.getInventory().getCareer());
			}
			player.getInventory().setCareer(chooseCareer(careerDeck));
		}
		
		player.getStatistics().gotJob();
		
		player.getBankAccount().setSalary(player.getInventory().getCareer().getSalary());
	}
	
	
	/*
	 * Takes the top 2 cards from the deck. User input selects which card 
	 * to keep. The unwanted card is returned to the deck.
	 */
	private CareerCard chooseCareer(Deck deck) {
		CareerCard careerCard1 = (CareerCard)deck.drawFromDeck();
		CareerCard careerCard2 = (CareerCard)deck.drawFromDeck();
		
		careerCard1.printDetails();
		careerCard2.printDetails();
		
		OfferChoice choice = new OfferChoice();
		
		if(choice.pickCard() == 1) {
			deck.addToDeck(careerCard2);
			return careerCard1;
		}else {
			deck.addToDeck(careerCard1);
			return careerCard2;
		}
	}
	
}
