package gameoflife.game;

import java.util.ArrayList;

import gameoflife.cards.ActionCardDeck;
import gameoflife.cards.CareerCardDeck;
import gameoflife.cards.HouseCardDeck;
import gameoflife.player.Player;

public class Main {

	public static void main(String[] args) {
		
		//-----------------------------------------------------------------------
		// Set paths to Game Card configuration files
		//-----------------------------------------------------------------------
		String pathToCareerCards = "../GameConfig/CareerCards.csv";
		String pathToCollegeCareerCards = "../GameConfig/CollegeCareerCards.csv";
		String pathToHouseCards = "../GameConfig/HouseCards.csv";
		String pathToActionCards = "../GameConfig/ActionCards.csv";
		
		//-----------------------------------------------------------------------
		// Initialise Game Cards
		//-----------------------------------------------------------------------
		GameInit gameInit = new GameInit();
		
		// Create Career card decks
		CareerCardDeck careerDeck = new CareerCardDeck();
		careerDeck = gameInit.buildCareerDeck(pathToCareerCards);
		CareerCardDeck collegeCareerDeck = new CareerCardDeck();
		collegeCareerDeck = gameInit.buildCareerDeck(pathToCollegeCareerCards);
		
		// Create House card deck
		HouseCardDeck houseDeck = new HouseCardDeck();
		houseDeck = gameInit.buildHouseDeck(pathToHouseCards);
		
		// Create Action card deck
		ActionCardDeck actionDeck = new ActionCardDeck();
		actionDeck = gameInit.buildActionDeck(pathToActionCards);

		//-----------------------------------------------------------------------
		// Initialise Players
		//-----------------------------------------------------------------------
		PlayerInit playerInit = new PlayerInit();
		
		ArrayList<Player> players = new ArrayList<Player>();  
		players = playerInit.buildPlayers();
		playerInit.chooseCareer(players, careerDeck, collegeCareerDeck);
		
		
		//-----------------------------------------------------------------------
		// Testing
		//-----------------------------------------------------------------------
		System.out.println("Debiting $280k from " +players.get(0).name +"'s account.");
		  
		players.get(0).decreaseBalanceBy(280000);
		 
		players.get(0).printDetails();
		 

	}

}
