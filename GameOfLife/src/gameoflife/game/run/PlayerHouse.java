package gameoflife.game.run;

import java.util.Scanner;

import gameoflife.board.objects.Spinner;
import gameoflife.cards.Deck;
import gameoflife.cards.HouseCard;
import gameoflife.game.util.EnterDetect;
import gameoflife.player.Player;

public class PlayerHouse {
	
	public PlayerHouse() {
		
	}
	
	/*
	 * Takes the top 2 cards from the deck. User input selects which card 
	 * to keep. The unwanted card is returned to the deck.
	 */
	public HouseCard chooseHouse(Deck deck) {
		HouseCard houseCard1 = (HouseCard)deck.drawFromDeck();
		HouseCard houseCard2 = (HouseCard)deck.drawFromDeck();
		
		houseCard1.printDetails();
		houseCard2.printDetails();
		
		System.out.println("Choose a house: (1 / 2) "); // Needs improvement
														//Use pop up box on screen to choose
		Scanner scanner = new Scanner( System.in );
		String input = scanner.nextLine();
		int answer = Integer.parseInt(input);
		//scanner.close();
		
		if(answer == 1) {
			deck.addToDeck(houseCard2);
			return houseCard1;
		}else {
			deck.addToDeck(houseCard1);
			return houseCard2;
		}
	}
	
	public void sellHouse(Player player, Spinner spinner) {
		
		for(int i = 0; i < player.getInventory().getNumHouses(); i++) {
			System.out.println("House number " + (i+1) + ": ");
			player.getInventory().getHouse(i).printDetails();
		}
		
		System.out.println("Choose a house number to sell: ");
		
		Scanner scanner = new Scanner( System.in );
		String input = scanner.nextLine();
		int answer = (Integer.parseInt(input)) - 1;
		
		System.out.println("Press ENTER to Spin for House value:");
		EnterDetect enterDetect = new EnterDetect();
		enterDetect.detectEnter();
		int spinnerVal = spinner.spin();
		System.out.println("Spinner Value: " + spinnerVal);
		
		System.out.println("Congratulations! You sold the " + player.getInventory().getHouse(answer).getHouseType() + " for €" + player.getInventory().getHouse(answer).getSalePrice(spinnerVal));
		player.getBankAccount().increaseBalance(player.getInventory().getHouse(answer).getSalePrice(spinnerVal));
		player.getInventory().removeHouse(answer);
	}

}
