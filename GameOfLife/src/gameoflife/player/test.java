package gameoflife.player;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import gameoflife.board.Pawn;
import gameoflife.board.PawnColour;
import gameoflife.cards.CareerCard;
import gameoflife.cards.CareerCardDeck;
import gameoflife.finance.Balance;

public class test {

	public static void main(String[] args) {
		System.out.println("How many players are playing?(Enter number 1-4):");
		Scanner in = new Scanner( System.in );
		String input = in.nextLine();
		int numberOfPlayers = Integer.parseInt(input);
		
		System.out.println("Number of Players = " +numberOfPlayers);
		List<String> names = new ArrayList<String>();
		List<PawnColour> colours = new ArrayList<PawnColour>();
		
		//Taking Player names and colours
		for (int i = 1; i <= numberOfPlayers; i++) {
			System.out.println("Enter Player" +i +" name:");
			String name = in.nextLine();
			names.add(name);
			System.out.println("Player" +i +" name: " +names.get(i-1));

			System.out.println("What colour should your pawn be? (RED, YELLOW, BLUE, GREEN)");
			String colour = in.nextLine();
			
			while (!PawnColour.contains(colour)) {
				System.out.println("The colour you entered is not an option. Please enter RED, YELLOW, BLUE or GREEN:");
				colour = in.nextLine();
			}
			colours.add(PawnColour.valueOf(colour.toUpperCase()));
			System.out.println("Player" +i +" colour: " +colours.get(i-1));
		}
		//Creating pawns and players
		int initX = 0;
		int initY = 0;
		List<Player> players = new ArrayList<Player>();
		List<Pawn> pawns = new ArrayList<Pawn>();
 		for (int i = 1; i <= numberOfPlayers; i++) {
			pawns.add(new Pawn(colours.get(i-1), initX, initY));
			players.add(new Player(names.get(i-1), Balance.INITIALBALANCE, pawns.get(i-1)));
		}
 		CareerCard actor = new CareerCard("Actor", 100000, 5);
		CareerCard inventor = new CareerCard("Inventor", 80000, 4);
		CareerCard singer = new CareerCard("Singer", 70000, 3);
		CareerCard raceCarDriver = new CareerCard("Race Car Driver", 60000, 2);
		CareerCard athlete = new CareerCard("Athlete", 50000, 1);
		CareerCard policeOfficer = new CareerCard("Police Officer", 50000, 4);
		CareerCard chef = new CareerCard("Chef", 50000, 3);
		CareerCard dancer = new CareerCard("Dancer", 50000, 2);
		
		// Initialize Career Card Deck
		CareerCardDeck careerDeck = new CareerCardDeck();
		careerDeck.addToDeck(actor);
		careerDeck.addToDeck(inventor);
		careerDeck.addToDeck(singer);
		careerDeck.addToDeck(raceCarDriver);
		careerDeck.addToDeck(athlete);
		careerDeck.addToDeck(policeOfficer);
		careerDeck.addToDeck(chef);
		careerDeck.addToDeck(dancer);
		
		System.out.println("Total cards in career deck: " + careerDeck.getTotalCards());
		careerDeck.shuffle();
		
 		for (int i = 1; i <= numberOfPlayers; i++) {
			System.out.println("Career Selection for " +players.get(i-1).name);
 			players.get(i-1).setCareer(careerDeck.chooseCareer());
 		}
 		for (int i = 0; i <= numberOfPlayers-1; i++) {
 			players.get(i).printDetails();
 		}

 		
		System.out.println("Debiting $280k from " +players.get(0).name +"'s account.");
		
		players.get(0).decreaseBalanceBy(280000);
		
 		players.get(0).printDetails();

		System.out.println("Giving " +players.get(1).name +" college education and a spouse.");
 		players.get(1).getMarried();
 		players.get(1).giveEducation();
 		
 		players.get(1).printDetails();

	}
}
