package gameoflife.game.run;

import gameoflife.bank.Loan;
import gameoflife.board.objects.Spinner;
import gameoflife.cards.Deck;
import gameoflife.cards.HouseCard;
import gameoflife.game.util.EnterDetect;
import gameoflife.game.util.OfferChoice;
import gameoflife.player.Player;

public class PlayerHouse {
	
	/**
	 * PlayerHouse Constructor
	 */
	public PlayerHouse() {
		
	}
	

	/**
	 * chooseHouse() method takes 2 cards from the deck. User input selects which card 
	 * to keep. The unwanted card is returned to the deck.
	 * 
	 * Prints details about both houses before choice is made.
	 * 
	 * If Player has insufficient funds, they are asked whether they are willing to take out loans.
	 * @param deck Deck of House Cards
	 * @param player Player that is choosing a house
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
				loansNeeded = (houseCard1.getPurchasePrice() - player.getBankAccount().getBalance())/Loan.LOAN_AMOUNT;
				System.out.println(player.getName() + ": This house cost's more than your current balance: To buy it you will have to take out " +loansNeeded +" loans of �" +Loan.LOAN_AMOUNT);
				System.out.println("Are you willing to take out loans to purcahse this house?");
				if(choice.yesOrNo()) {
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
				loansNeeded = (houseCard2.getPurchasePrice() - player.getBankAccount().getBalance())/Loan.LOAN_AMOUNT;
				System.out.println(player.getName() + ": This house cost's more than your current balance: To buy it you will have to take out " +loansNeeded +" loans of $" +Loan.LOAN_AMOUNT);
				System.out.println("Are you willing to take out loans to purchase this house?");

				if(choice.yesOrNo()) {
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
	
	/**
	 * sellHouse() method is used to sell a House from a players inventory. Spins the spinner to determine the sale price of the house
	 * @param deck Deck of house cards, needed to put the House Card being sold back into the deck
	 * @param player Player that is selling the house
	 * @param spinner Spinner for determining sale price
	 * @param houseIndex Index of the house being sold, in the Houses list
	 */
	public void sellHouse(Deck deck, Player player, Spinner spinner, int houseIndex) {
		System.out.println();
		System.out.println(player.getName() + ": You are selling the House:");
		player.getInventory().getHouse(houseIndex).printDetails();
		System.out.println(player.getName() + ": Press ENTER to Spin for House value:");
		EnterDetect enterDetect = new EnterDetect();
		enterDetect.detectEnter();
		int spinnerVal = spinner.spin();
		System.out.println("Spinner Value: " + spinnerVal);
		System.out.println();
		System.out.println("Congratulations! You sold the " + player.getInventory().getHouse(houseIndex).getHouseType() + " for �" + player.getInventory().getHouse(houseIndex).getSalePrice(spinnerVal));
		player.getBankAccount().increaseBalance(player.getInventory().getHouse(houseIndex).getSalePrice(spinnerVal));
		deck.addToDeck(player.getInventory().removeHouse(houseIndex)); //Add house back into deck and remove from player inventory
		
	}
	
	/**
	 * chooseAndSellHouse() method to offer a Player a choice on which house they would like to sell.
	 * 
	 * Prints the details of all the Houses in the Players inventory.
	 * Invokes the sellHouse() method when player has decided on which house to sell.
	 * @param deck Deck of House Cards, needed to put the sold house back in the Deck
	 * @param player Player that is choosing which house to sell
	 * @param spinner Spinner needed to determine the sale price of the House.
	 */
	public void chooseAndSellHouse(Deck deck, Player player, Spinner spinner) {
		if(player.getInventory().getNumHouses() == 0) {
			System.out.println(player.getName() + ": You do not have any houses to sell.");
		} else {
			for(int i = 0; i < player.getInventory().getNumHouses(); i++) {
				System.out.println("House number " + (i+1) + ": ");
				player.getInventory().getHouse(i).printDetails();
			}
			
			System.out.println(player.getName() + ": Choose a house number to sell: ");
			
			int num;
			OfferChoice choice = new OfferChoice();
			
			while(true) { // Get input and check that number is valid
				num = choice.getNumInput();
				if((num < 1) || (num > player.getInventory().getNumHouses())) {
					System.out.println("Invalid number! Choose a number from 1 to "+ player.getInventory().getNumHouses() +": ");
				} else {
					break;
				}
			}
			sellHouse(deck, player, spinner, num-1);
		}
	}

}
