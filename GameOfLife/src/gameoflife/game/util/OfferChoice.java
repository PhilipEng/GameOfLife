package gameoflife.game.util;

import java.util.Scanner;

public class OfferChoice {
	
	public OfferChoice() {
		
	}
	
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
	
	public int pickCard() {
		System.out.println("Choose a card: (1 / 2) "); 
		@SuppressWarnings("resource") // Suppressed warning for scanner never closed
		Scanner scanner = new Scanner( System.in );
		String input;
		int answer;
		//scanner.close();
		
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
			       System.out.println("Please input a value");
		    }
		}
	}
	
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
