package gameoflife.game.run;

import java.util.Scanner;

import gameoflife.cards.CareerCard;
import gameoflife.cards.Deck;
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
			player.getInventory().setCareer(chooseCareer(collegeDeck));
		} else {
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
		
		System.out.println("Choose a career: (1 / 2) "); // Needs improvement
														//Use pop up box on screen to choose
		Scanner scanner = new Scanner( System.in );
		String input = scanner.nextLine();
		int answer = Integer.parseInt(input);
		//scanner.close();
		
		if(answer == 1) {
			deck.addToDeck(careerCard2);
			return careerCard1;
		}else {
			deck.addToDeck(careerCard1);
			return careerCard2;
		}
	}
	
}
