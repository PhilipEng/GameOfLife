package gameoflife.game.util;

import java.util.Scanner;

public class OfferChoice {
	
	/**
	 * OfferChoice Constructor
	 */
	public OfferChoice() {
		
	}
	
	/**
	 * Parses a scanner input into an int
	 * @return Returns the int that was entered
	 */
	public int getNumInput() {
		@SuppressWarnings("resource") // Suppressed warning for scanner never closed
		Scanner scanner = new Scanner( System.in );
		String input;
		int answer;
		
		while (true) {
			try {
				input = scanner.nextLine();
				answer = Integer.parseInt(input);
				return answer;
			} catch (NumberFormatException ex) {
			       System.out.println("Please answer with a number");
		    }
		}
	}
	
	/**
	 * Offers 2 options (1 or 2), used for picking cards.
	 * 
	 * @return Returns either 1 or 2
	 */
	public int pickCard() {
		System.out.println("Choose a card: (1 / 2) "); 
		@SuppressWarnings("resource") // Suppressed warning for scanner never closed
		Scanner scanner = new Scanner( System.in );
		String input;
		int answer;
		
		while (true) {
			try {
				input = scanner.nextLine();
				answer = Integer.parseInt(input);
				if(answer == 1) return 1;
				else if(answer == 2) return 2;
				else {
					System.out.println("Please answer (1 / 2)");
				} 
			} catch (NumberFormatException ex) {
			       System.out.println("Please answer (1 / 2)");
		    }
		}
	}
	
	/**
	 * Looks for input Y or N, returns true for Y, false for N
	 * @return Returns true for Y, false for N
	 */
	public boolean yesOrNo() {
		@SuppressWarnings("resource") // Suppressed warning for scanner never closed
		Scanner in = new Scanner( System.in );
		System.out.println("Please answer (Y / N)");
		String answer;
		
		while (true) {
			try {
				answer = in.nextLine().trim().toLowerCase();
				if (answer.equals("y")) {
					return true;
				} else if (answer.equals("n")) {
					return false;
				} else {
					System.out.println("Please answer (Y / N)");
				}
			} catch (NumberFormatException ex) {
			       System.out.println("Please answer (Y / N)");
		    }
		}
	}
	
	/**
	 * Offers number of Players playing the game, looks for number between 2 and 4.
	 * 
	 * @return Returns the number of players playing the game
	 */
	public int pickNumPlayers() {
		@SuppressWarnings("resource") // Suppressed warning for scanner never closed
		Scanner scanner = new Scanner( System.in );
		
		String input;
		int numPlayers;
		
		while (true) {
			try {
				System.out.println("How many players are playing?(Enter number 2-4):");
				input = scanner.nextLine();
				numPlayers = Integer.parseInt(input);
				if ((numPlayers <= 4) && (numPlayers >= 2)) {
					return numPlayers;
				} else {
					System.out.println("Game cannot be played with " + numPlayers +" Players");
					System.out.println();
				}
			} catch (NumberFormatException ex) {
			       System.out.println("Please input a value:");
		    }
		}
	}
	
	/**
	 * houseSpaceOptions() offers the player 3 choices relating to a house space.
	 * 
	 * They can buy (buy), sell (sell) or do nothing (n). Will try until it receives one of these inputs.
	 * @return Returns the string "buy", "sell", or "n"
	 */
	public String houseSpaceOptions() {
		@SuppressWarnings("resource") // Suppressed warning for scanner never closed
		Scanner scanner = new Scanner(System.in);
		
		String input;
		
		while(true) {
			try {
				System.out.println("Would you like to buy a house (buy), sell a house (sell), or do nothing (n)?");
				input = scanner.nextLine();
				if(input.toUpperCase().contentEquals("SELL") ||  input.toUpperCase().contentEquals("BUY") || input.toUpperCase().contentEquals("N")) {
					return input.toUpperCase();
				} else {
					System.out.println("Please answer: sell, buy, or n.");
				}
			} catch (NumberFormatException ex) {
			       System.out.println("Please answer: sell, buy, or n.");
			      }
			}
		}
}
