package gameoflife.game.initialise;

import gameoflife.board.objects.Spinner;

public class InitialiseGame {
	
	private CardInit gameCards;
	private BoardInit gameBoard;
	private Spinner spinner;
	private SpacesInit spacesInit;
	
	
	public InitialiseGame(String pathToCareerCards, String pathToCollegeCareerCards, String pathToHouseCards, String pathToActionCards, String pathToBoardConfig) {
		gameCards = new CardInit(pathToCareerCards, pathToCollegeCareerCards, pathToHouseCards, pathToActionCards);
		gameBoard = new BoardInit(pathToBoardConfig);
		spacesInit = new SpacesInit(gameBoard.getBoardData());
		spacesInit.generateSpaces();
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

	public SpacesInit getSpacesInit() {
		return this.spacesInit;
	}
}
