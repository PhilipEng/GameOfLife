package gameoflife.game.initialise;

import gameoflife.board.objects.Spinner;

public class InitialiseGame {
	
	private CardInit gameCards;
	private BoardInit gameBoard;
	private Spinner spinner;
	private SpacesInit spacesInit;
	
	
	/**
	 * InitialiseGame constructor
	 * 
	 * Generates many Initialisation components, CardInit, BoardInit, SpacesInit, Spinner
	 * 
	 * @param pathToCareerCards Path of Career Cards CSV
	 * @param pathToCollegeCareerCards Path of College Career Cards CSV
	 * @param pathToHouseCards Path of House Cards CSV
	 * @param pathToActionCards Path of Action Cards CSV
	 * @param pathToBoardConfig Path to BoardSpace CSV
	 */
	public InitialiseGame(String pathToCareerCards, String pathToCollegeCareerCards, String pathToHouseCards, String pathToActionCards, String pathToBoardConfig) {
		gameCards = new CardInit(pathToCareerCards, pathToCollegeCareerCards, pathToHouseCards, pathToActionCards);
		gameBoard = new BoardInit(pathToBoardConfig);
		spacesInit = new SpacesInit(gameBoard.getBoardData());
		spacesInit.generateSpaces();
		spinner = new Spinner();
	}


	/**
	 * Gets gameCards Initialisation
	 * @return return gameCards
	 */
	public CardInit getGameCards() {
		return gameCards;
	}

	/**
	 * Gets gameBoard Initialisation
	 * @return returns gameBoard
	 */
	public BoardInit getGameBoard() {
		return gameBoard;
	}
	
	/**
	 * Gets spinner
	 * @return returns Spinner
	 */
	public Spinner getSpinner() {
		return spinner;
	}

	/**
	 * Gets spacesInit Initialisation
	 * @return returns spacesInit
	 */
	public SpacesInit getSpacesInit() {
		return this.spacesInit;
	}
}
