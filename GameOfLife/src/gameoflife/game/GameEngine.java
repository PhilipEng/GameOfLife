package gameoflife.game;

import java.util.ArrayList;

import gameoflife.board.spaces.Space;
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

	public static void main(String[] args) {
		//-----------------------------------------------------------------------
		// Initialise Game
		//-----------------------------------------------------------------------
		InitialiseGame gameInit = new InitialiseGame(PATH_TO_CAREER_CARDS, PATH_TO_COLLEGE_CAREER_CARDS, PATH_TO_HOUSE_CARDS, PATH_TO_ACTION_CARDS, PATH_TO_BOARD_CONFIG);
		
		//gameInit.getGameCards().getCareerDeck().drawFromDeck().printDetails();
		
		//-----------------------------------------------------------------------
		// Start Game
		//-----------------------------------------------------------------------
		StartGame startGame = new StartGame(gameInit.getGameCards().getCareerDeck(), gameInit.getGameCards().getCollegeCareerDeck(), gameInit.getSpacesInit().getSpaces());
		
		//System.out.println(startGame.getPlayers().get(1).getBankAccount().getBalance());
		
		// Draw game board
		gameInit.getGameBoard().getBoardGen().drawBoard(gameInit.getGameBoard().getBoardData());
		
		RunGame runGame = new RunGame(startGame.getPlayers(), gameInit.getGameCards(), gameInit.getGameBoard(), gameInit.getSpinner(), gameInit.getSpacesInit().getSpaces());
		
		System.out.println("End Game");
		EndGame endGame = new EndGame(); //Calculate winnner, print winner, leaderboard, close board
	}


}
