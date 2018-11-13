package gameoflife.game;

import gameoflife.game.initialise.InitialiseGame;
import gameoflife.game.start.StartGame;

public class GameEngine {
	
	private static final String PATH_TO_CAREER_CARDS = "../resource/CareerCards.csv";
	private static final String PATH_TO_COLLEGE_CAREER_CARDS = "../resource/CollegeCareerCards.csv";
	private static final String PATH_TO_HOUSE_CARDS = "../resource/HouseCards.csv";
	private static final String PATH_TO_ACTION_CARDS = "../resource/ActionCards.csv";
	private static final String PATH_TO_BOARD_CONFIG = "../resource/SpacesTesting.csv";

	public static void main(String[] args) {
		//-----------------------------------------------------------------------
		// Initialise Game
		//-----------------------------------------------------------------------
		InitialiseGame gameInit = new InitialiseGame(PATH_TO_CAREER_CARDS, PATH_TO_COLLEGE_CAREER_CARDS, PATH_TO_HOUSE_CARDS, PATH_TO_ACTION_CARDS, PATH_TO_BOARD_CONFIG);
		
		//gameInit.getGameCards().getCareerDeck().drawFromDeck().printDetails();
		
		//-----------------------------------------------------------------------
		// Start Game
		//-----------------------------------------------------------------------
		StartGame startGame = new StartGame(gameInit.getGameCards().getCareerDeck(), gameInit.getGameCards().getCollegeCareerDeck());
		
		//System.out.println(startGame.getPlayers().get(1).getBankAccount().getBalance());
		
		// Draw game board
		gameInit.getGameBoard().getBoardGen().drawBoard(gameInit.getGameBoard().getBoardData());
		

	}


}
