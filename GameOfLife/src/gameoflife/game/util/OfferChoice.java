package gameoflife.game.util;

import java.io.IOException;
import java.util.Scanner;

public class OfferChoice {
	
	public OfferChoice() {
		
	}
	
	public int pickCard() {
		System.out.println("Choose a card: (1 / 2) "); 
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
}
