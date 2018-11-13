package gameoflife.game.initialise;

import gameoflife.board.Spinner;

public class InitialiseGame {
	
	private CardInit gameCards;
	private BoardInit gameBoard;
	private Spinner spinner;
	
	
	public InitialiseGame(String pathToCareerCards, String pathToCollegeCareerCards, String pathToHouseCards, String pathToActionCards, String pathToBoardConfig) {
		gameCards = new CardInit(pathToCareerCards, pathToCollegeCareerCards, pathToHouseCards, pathToActionCards);
		gameBoard = new BoardInit(pathToBoardConfig);
		spinner = new Spinner();
	}


	public CardInit getGameCards() {
		return gameCards;
	}

	public BoardInit getGameBoard() {
		return gameBoard;
	}
	
	public Spinner getSpinner() {
		return spinner;
	}

}
