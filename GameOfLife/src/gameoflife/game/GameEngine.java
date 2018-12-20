package gameoflife.game;

import gameoflife.game.end.EndGame;
import gameoflife.game.initialise.InitialiseGame;
import gameoflife.game.run.RunGame;
import gameoflife.game.start.StartGame;

public class GameEngine {
	
	private static final String PATH_TO_CAREER_CARDS = "resource/CareerCards.csv";
	private static final String PATH_TO_COLLEGE_CAREER_CARDS = "resource/CollegeCareerCards.csv";
	private static final String PATH_TO_HOUSE_CARDS = "resource/HouseCards.csv";
	private static final String PATH_TO_ACTION_CARDS = "resource/ActionCards.csv";
	private static final String PATH_TO_BOARD_CONFIG = "resource/SpacesCSV.csv";

	/**
	 * Main of Project, runs 4 components, Initialise Game, StartGame, RunGame, and EndGame
	 * @param args args
	 */
	public static void main(String[] args) {
		//-----------------------------------------------------------------------
		// Initialise Game
		//-----------------------------------------------------------------------
		InitialiseGame gameInit = new InitialiseGame(PATH_TO_CAREER_CARDS, PATH_TO_COLLEGE_CAREER_CARDS, PATH_TO_HOUSE_CARDS, PATH_TO_ACTION_CARDS, PATH_TO_BOARD_CONFIG);
				
		//-----------------------------------------------------------------------
		// Start Game
		//-----------------------------------------------------------------------
		StartGame startGame = new StartGame(gameInit.getGameCards().getCareerDeck(), gameInit.getGameCards().getCollegeCareerDeck(), gameInit.getSpacesInit().getSpaces(), gameInit.getGameBoard());
				
		@SuppressWarnings("unused")
		RunGame runGame = new RunGame(startGame.getPlayers(), gameInit.getGameCards(), gameInit.getSpinner(), gameInit.getSpacesInit().getSpaces(), gameInit.getGameBoard());
		
		@SuppressWarnings("unused")
		EndGame endGame = new EndGame(startGame.getPlayers(), gameInit.getSpinner(), gameInit.getGameCards().getHouseDeck()); //Calculate winnner, print winner, leaderboard, close board
	}


}
