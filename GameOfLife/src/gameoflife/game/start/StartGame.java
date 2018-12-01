package gameoflife.game.start;

import java.util.ArrayList;
import java.util.Scanner;

import gameoflife.board.objects.Pawn;
import gameoflife.board.objects.PawnColour;
import gameoflife.board.spaces.Space;
import gameoflife.cards.Deck;
import gameoflife.game.initialise.BoardInit;
import gameoflife.game.run.PlayerCareers;
import gameoflife.game.run.Spaces;
import gameoflife.game.util.EnterDetect;
import gameoflife.game.util.OfferChoice;
import gameoflife.player.Player;

public class StartGame {
	
	private ArrayList<Player> players;
	
	public StartGame(Deck careerDeck, Deck collegeDeck, ArrayList<Space> spacesList, BoardInit gameBoard) {
		start();
		buildPlayers(careerDeck, collegeDeck, spacesList);
		gameBoard.getBoardGen().redrawBoard(gameBoard.getBoardData(), players, spacesList); //Redraw the board after moving

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
	
	public void buildPlayers(Deck careerDeck, Deck collegeDeck, ArrayList<Space> spacesList) {
		players = new ArrayList<Player>();
		
		OfferChoice choice = new OfferChoice();
		
		int numPlayers = choice.pickNumPlayers();
		Scanner in = new Scanner( System.in );
		
		
		System.out.println("Number of Players = " +numPlayers);
		
		//ArrayList<String> names = new ArrayList<String>();
		//ArrayList<PawnColour> colours = new ArrayList<PawnColour>();
		
		for(int i = 1; i <= numPlayers; i++) {
			System.out.println("Enter Player" +i +" name:");
			String name = in.nextLine();
			
			System.out.println("What colour should your pawn be? (RED, YELLOW, BLUE, GREEN)"); 
			String colour = in.nextLine();
			
			while(!checkColour(colour, players, i)) {
				colour = in.nextLine();
			}
			/*while (!PawnColour.contains(colour) || colours.contains(PawnColour.valueOf(colour.toUpperCase()))) {
				System.out.println("The colour you entered is not an option.");		//Need to print remaining available pawn colours
				colour = in.nextLine();
			}*/
			
			Pawn pawn = new Pawn(PawnColour.valueOf(colour.toUpperCase()));
			
			players.add(new Player(name, pawn));
			
			System.out.println("Would you like to go to college?");
			System.out.println("You currently have €200,000. College will cost you €100,000.");
			
			
			
			PlayerCareers playercareer = new PlayerCareers();
			Spaces spaces = new Spaces();
			if(choice.yesOrNo()) {
				playercareer.educatePlayer(players.get(i-1));
				players.get(i-1).getPawn().setSpaceNum(spaces.findCollegeStart(spacesList)); 
			} else {
				//Set pawn position and space no.
				players.get(i-1).getPawn().setSpaceNum(spaces.findStart(spacesList));
				playercareer.choosePlayerCareer(players.get(i-1), careerDeck, collegeDeck);
			}
			
			players.get(i-1).printDetails();
		}
	}
	
	public boolean checkColour(String colour, ArrayList<Player> players, int i) {
		if(!PawnColour.contains(colour)) {
			System.out.println("Please enter a valid colour (RED, YELLOW, BLUE, GREEN)");
			return false;
		}
		for(int x = 0;x<i-1;x++) {
			if(players.get(x).getPawn().getColour().toString().equalsIgnoreCase(colour)) {
				System.out.println("Another player has already picked this colour, choose another:");
				return false;
			}
		}
		return true;
	}
	
}
