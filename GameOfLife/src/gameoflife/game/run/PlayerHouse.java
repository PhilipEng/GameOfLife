package gameoflife.game.run;

import java.util.Scanner;


import gameoflife.bank.Loan;
import gameoflife.board.objects.Spinner;
import gameoflife.cards.Deck;
import gameoflife.cards.HouseCard;
import gameoflife.game.util.EnterDetect;
import gameoflife.game.util.OfferChoice;
import gameoflife.player.Player;

public class PlayerHouse {
	
	public PlayerHouse() {
		
	}
	
	/*
	 * Takes the top 2 cards from the deck. User input selects which card 
	 * to keep. The unwanted card is returned to the deck.
	 */
	public void chooseHouse(Deck deck, Player player) {
		int loansNeeded;
		HouseCard houseCard1 = (HouseCard)deck.drawFromDeck();
		HouseCard houseCard2 = (HouseCard)deck.drawFromDeck();
		
		houseCard1.printDetails();
		houseCard2.printDetails();
		
		OfferChoice choice = new OfferChoice();
		
		if(choice.pickCard() == 1) {
			
			if(houseCard1.getPurchasePrice() > player.getBankAccount().getBalance()) {
				loansNeeded = (houseCard1.getPurchasePrice() - player.getBankAccount().getBalance())/Loan.LOANAMOUNT;
				System.out.println("This house cost's more than your current balance: To buy it you will have to take out " +loansNeeded +" loans of $" +Loan.LOANAMOUNT);
				System.out.println("Are you willing to take out loans to purcahse this house?");
				Boolean buy = choice.yesOrNo();
				
				if(buy) {
					deck.addToDeck(houseCard2);
					player.getInventory().addHouse(houseCard1);
					player.getBankAccount().decreaseBalance(houseCard1.getPurchasePrice());

				} else {
					deck.addToDeck(houseCard1);
					deck.addToDeck(houseCard2);
				}
			} else {
				deck.addToDeck(houseCard2);
				player.getInventory().addHouse(houseCard1);
				player.getBankAccount().decreaseBalance(houseCard1.getPurchasePrice());
			}
		}else {
			if(houseCard2.getPurchasePrice() > player.getBankAccount().getBalance()) {
				loansNeeded = (houseCard2.getPurchasePrice() - player.getBankAccount().getBalance())/Loan.LOANAMOUNT;
				System.out.println("This house cost's more than your current balance: To buy it you will have to take out " +loansNeeded +" loans of $" +Loan.LOANAMOUNT);
				System.out.println("Are you willing to take out loans to purcahse this house?");
				Boolean buy = choice.yesOrNo();
				
				if(buy) {
					deck.addToDeck(houseCard1);
					player.getInventory().addHouse(houseCard2);
					player.getBankAccount().decreaseBalance(houseCard2.getPurchasePrice());
				} else {
					deck.addToDeck(houseCard1);
					deck.addToDeck(houseCard2);
				}
			} else {
				deck.addToDeck(houseCard1);
				player.getInventory().addHouse(houseCard2);
				player.getBankAccount().decreaseBalance(houseCard2.getPurchasePrice());
			}
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
