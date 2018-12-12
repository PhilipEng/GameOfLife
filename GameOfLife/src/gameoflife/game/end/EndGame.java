package gameoflife.game.end;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.sun.media.jfxmedia.events.PlayerStateEvent.PlayerState;

import java.util.Collections;


import gameoflife.bank.Loan;
import gameoflife.board.objects.Spinner;
import gameoflife.board.spaces.Space;
import gameoflife.cards.Deck;
import gameoflife.game.run.PlayerHouse;
import gameoflife.game.util.EnterDetect;
import gameoflife.player.Player;

public class EndGame {

	private Spinner spinner;
	public EndGame(ArrayList<Player> players, Spinner spinner, Deck houseDeck) {
		int i;
		EnterDetect enter = new EnterDetect();
		
		this.spinner = spinner;
		System.out.println();
		System.out.println("---------------------------------------------------------------");
		System.out.println("-----------------         END OF GAME         -----------------");
		System.out.println("---------------------------------------------------------------");
		System.out.println();


		for (i = 0; i<players.size(); i++) {
			System.out.println("Press ENTER to view the results for " +players.get(i).getName() + ":");
			enter.detectEnter();
			retirePlayer(players.get(i), houseDeck);
		}
		
		players = sortPlayersByValue(players);
		
		System.out.println("Press ENTER to View the Final Results:");
		enter.detectEnter();
		
		System.out.println();
		System.out.println("---------------------------------------------------------------");
		System.out.println("-----------------        FINAL RESULTS        -----------------");
		System.out.println("---------------------------------------------------------------");



		for (i = 0; i<players.size(); i++) {
			if(i>0) {
				if(players.get(i).getBankAccount().getBalance() == players.get(i-1).getBankAccount().getBalance()) {
					System.out.println("Pos " +(i) +": " +players.get(i).getName() +"   \tBal: €" +players.get(i).getBankAccount().getBalance());
				} else {
					System.out.println("Pos " +(i+1) +": " +players.get(i).getName() +"   \tBal: €" +players.get(i).getBankAccount().getBalance());

				}
			} else {
				System.out.println("Pos " +(i+1) +": " +players.get(i).getName() +"   \tBal: €" +players.get(i).getBankAccount().getBalance());

			}
		}
	}
	
	

	public void retirePlayer(Player player, Deck houseDeck) {
		System.out.println("---------------------------");
		System.out.println("End-Game Breakdown for " +player.getName());
		System.out.println("---------------------------");
		System.out.println();

		System.out.println(player.getName() +"'s Bank Account Balance was: " +player.getBankAccount().printBalance());
		if(player.getBankAccount().getNumLoans() != 0) {
			System.out.println("But they have " +player.getBankAccount().getNumLoans() +" outstanding Loans, with a Repayment Cost of: " +player.getBankAccount().getNumLoans()*Loan.LOANREPAYAMOUNT);
		} else {
			System.out.println("And they have no outstanding Loans.");
		}
		
		System.out.println();

		System.out.println(player.getName() +" retired in position " +player.getStatistics().getRetirementPos() +".");
		System.out.println("They get a retirement bonus of €" +calculateRetirementBonus(player.getStatistics().getRetirementPos()));
		player.getBankAccount().increaseBalance(calculateRetirementBonus(player.getStatistics().getRetirementPos()));
		
		System.out.println();
		
		if(player.getInventory().getNumHouses() == 0) {
			System.out.println(player.getName() +" finished with no houses.");
		} else {
			System.out.println(player.getName() +" finished with " + player.getInventory().getNumHouses() +" houses.");
			PlayerHouse  houseSpace = new PlayerHouse();
			while(player.getInventory().getNumHouses() > 0) {
				houseSpace.sellHouse(houseDeck, player, spinner, 0);
			}
			System.out.println(player.getName() +", you have sold all of your houses");
		}
		
		
		/*else if(player.getInventory().getNumHouses() == 1) {
			System.out.println(player.getName() +" finished with 1 house.");
			player.getInventory().getHouse(0).printDetails();
			System.out.println("Your house will be sold and the sale value will be added to your retirement fund.");
			player.getBankAccount().increaseBalance(player.getInventory().sellAllHouses(spinner));
		} else {
			System.out.println(player.getName() +" finished with " +player.getInventory().getNumHouses() +" house.");
			for(int house = 0; house < player.getInventory().getNumHouses(); house ++) {
				player.getInventory().getHouse(house).printDetails();
				
			}
			System.out.println("Your houses will be sold and the sale values will be added to your retirement fund.");
			player.getBankAccount().increaseBalance(player.getInventory().sellAllHouses(spinner));

		}*/
		
		System.out.println();
		System.out.println(player.getName() +" has " +player.getStatistics().getNumChildren() +" children. For each child you will be awarded with €50,000");
		player.getBankAccount().increaseBalance(player.getStatistics().getNumChildren()*50000);

		System.out.println();
		System.out.println(player.getName() +" landed on " +player.getInventory().getNumberActionCards() +" Action Spaces. For each Action Space you will be awarded with €100,000");
		player.getBankAccount().increaseBalance(player.getInventory().getNumberActionCards()*100000);
		System.out.println("You have been awarded €" +player.getInventory().getNumberActionCards()*100000 +" for Action Spaces");
		
		System.out.println();
		System.out.println("Repaying Loans...");
		player.getBankAccount().repayLoans();
		System.out.println("Repayed " +player.getBankAccount().getNumLoans() +" loans. €" +player.getBankAccount().getNumLoans()*Loan.LOANREPAYAMOUNT +" was deducted from your account.");
		System.out.println();
		System.out.println();

		
	}

	private int calculateRetirementBonus(int retirementPos) {
		switch (retirementPos) {
		case 1:
			return  400000;
		case 2:
			return 300000;
		case 3:
			return 200000;
		case 4:
			return 100000;
		default:
			return 0;
		}
	}
	
	private ArrayList<Player> sortPlayersByValue(ArrayList<Player> players) {
		players.sort( (o1, o2) -> o2.getBankAccount().getIntegerBalance().compareTo(o1.getBankAccount().getIntegerBalance()));
		return players;
	}
}
