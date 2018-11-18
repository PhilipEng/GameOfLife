package gameoflife.game.start;

import java.util.ArrayList;
import java.util.Scanner;

import gameoflife.board.objects.Pawn;
import gameoflife.board.objects.PawnColour;
import gameoflife.cards.Deck;
import gameoflife.game.run.PlayerCareers;
import gameoflife.game.util.EnterDetect;
import gameoflife.player.Player;

public class StartGame {
	
	private ArrayList<Player> players;
	
	public StartGame(Deck careerDeck, Deck collegeDeck) {
		start();
		buildPlayers(careerDeck, collegeDeck);
	}
	
	
	public ArrayList<Player> getPlayers(){
		return this.players;
	}
	
	
	public void start(){
		System.out.println("---------------------------");
		System.out.println("WELCOME TO THE GAME OF LIFE");
		System.out.println("---------------------------");
		System.out.println("Press ENTER to Start:");
		EnterDetect enterDetect = new EnterDetect();
		enterDetect.detectEnter();
	}
	
	public void buildPlayers(Deck careerDeck, Deck collegeDeck) {
		players = new ArrayList<Player>();
		
		int numPlayers;
		Scanner in = new Scanner( System.in );
		String input;
		
		while(true) {
			System.out.println("How many players are playing?(Enter number 2-4):");
			input = in.nextLine();
			numPlayers = Integer.parseInt(input);
			
			if((numPlayers <= 4) && (numPlayers >= 2)) {
				break;
			}
			System.out.println("Game cannot be played with " + numPlayers +" Players");
			System.out.println();
		}
		
		System.out.println("Number of Players = " +numPlayers);
		
		//ArrayList<String> names = new ArrayList<String>();
		//ArrayList<PawnColour> colours = new ArrayList<PawnColour>();
		
		for(int i = 1; i <= numPlayers; i++) {
			System.out.println("Enter Player" +i +" name:");
			String name = in.nextLine();
			
			System.out.println("What colour should your pawn be? (RED, YELLOW, BLUE, GREEN)"); 
			String colour = in.nextLine();
			
			/*while (!PawnColour.contains(colour) || colours.contains(PawnColour.valueOf(colour.toUpperCase()))) {
				System.out.println("The colour you entered is not an option.");		//Need to print remaining available pawn colours
				colour = in.nextLine();
			}*/
			
			Pawn pawn = new Pawn(PawnColour.valueOf(colour.toUpperCase()));
			
			players.add(new Player(name, pawn));
			
			System.out.println("Would you like to go to college?");
			System.out.println("You currently have €200,000. College will cost you €100,000.");
			System.out.println("(Y/N)");
			String answer;
			
			boolean yn;
			
			while (true) {
				answer = in.nextLine().trim().toLowerCase();
				  if (answer.equals("y")) {
				    yn = true;
				    break;
				  } else if (answer.equals("n")) {
				    yn = false;
				    break;
				  } else {
				     System.out.println("Please answer y/n");
				  }
				}
			
			PlayerCareers playercareer = new PlayerCareers();
			if(yn) {
				playercareer.educatePlayer(players.get(i-1));
				players.get(i-1).getPawn().setSpaceNum(93);
			} else {
				//Set pawn position and space no.
				players.get(i-1).getPawn().setSpaceNum(1);
				playercareer.choosePlayerCareer(players.get(i-1), careerDeck, collegeDeck);
			}
			
			players.get(i-1).printDetails();
		}
	}
	
}
