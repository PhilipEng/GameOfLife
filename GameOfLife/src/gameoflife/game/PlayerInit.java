package gameoflife.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import gameoflife.player.Player;
import gameoflife.board.Pawn;
import gameoflife.board.PawnColour;
import gameoflife.cards.CareerCardDeck;

public class PlayerInit {

	public PlayerInit() {
		
	}
	
	public ArrayList<Player> buildPlayers(){
		
		ArrayList<Player> players = new ArrayList<Player>();
		int numberOfPlayers;
		Scanner in = new Scanner( System.in );
		String input;
		
		while(true) {
			System.out.println("How many players are playing?(Enter number 2-4):");
			input = in.nextLine();
			numberOfPlayers = Integer.parseInt(input);
			
			if((numberOfPlayers <= 4) && (numberOfPlayers >= 2)) {
				break;
			}
			System.out.println("Game cannot be played with " +numberOfPlayers +" Players");
			System.out.println();
		}
		
		System.out.println("Number of Players = " +numberOfPlayers);
		
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<PawnColour> colours = new ArrayList<PawnColour>();
		
		//Taking Player names and colours
		for (int i = 1; i <= numberOfPlayers; i++) {
			System.out.println("Enter Player" +i +" name:");
			String name = in.nextLine();
			names.add(name);
			System.out.println("Player" +i +" name: " +names.get(i-1));

			System.out.println("What colour should your pawn be? (RED, YELLOW, BLUE, GREEN)"); //Every player can use the same pawn colour!
			String colour = in.nextLine();
			
			while (!PawnColour.contains(colour)) {
				System.out.println("The colour you entered is not an option. Please enter RED, YELLOW, BLUE or GREEN:");
				colour = in.nextLine();
			}
			colours.add(PawnColour.valueOf(colour.toUpperCase()));
			System.out.println("Player" +i +" colour: " +colours.get(i-1));
		}
		
		//Creating pawns and players
		
		int initialBalance = 200000;
		
		List<Pawn> pawns = new ArrayList<Pawn>();
		pawns = buildPawns(colours, numberOfPlayers);
 		for (int i = 0; i < numberOfPlayers; i++) {
			players.add(new Player(names.get(i), initialBalance, pawns.get(i)));
		}
		return players;
	}
	
	public ArrayList<Pawn> buildPawns(ArrayList<PawnColour> colours, int numberOfPlayers){
		ArrayList<Pawn> pawns = new ArrayList<Pawn>();
		int initX = 0;
		int initY = 0;
		for (int i = 0; i < numberOfPlayers; i++) {
			pawns.add(new Pawn(colours.get(i), initX, initY));
		}
		return pawns;
	}
	
	public void chooseCareer(ArrayList<Player> players, CareerCardDeck careerDeck, CareerCardDeck collegeCareerDeck) {
		Scanner in = new Scanner( System.in );
		String input;
		boolean yn;
		
		for (int i = 0; i < players.size(); i++) {
			System.out.println(players.get(i).getName() + ": Would you like to go to College? (Y/N) ");
			
			while (true) {
				  input = in.nextLine().trim().toLowerCase();
				  if (input.equals("y")) {
				    yn = true;
				    break;
				  } else if (input.equals("n")) {
				    yn = false;
				    break;
				  } else {
				     System.out.println("Please answer y/n");
				  }
				}
			
			if(yn) {
				players.get(i).decreaseBalanceBy(100000);
				players.get(i).giveEducation();
	 			players.get(i).setCareer(collegeCareerDeck.chooseCareer());
	 			//Change pawn position
			} else {
				players.get(i).setCareer(careerDeck.chooseCareer());
			}

			players.get(i).printDetails();
		}
	}
}
