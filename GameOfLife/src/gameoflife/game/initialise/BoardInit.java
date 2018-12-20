package gameoflife.game.initialise;

import java.nio.file.Path;
import java.nio.file.Paths;

import gameoflife.board.BoardGeneration;

public class BoardInit {
	
	private BoardGeneration gameBoard;
	private int[][][] boardData;
	
	/**
	 * BoardInit constructor. 
	 * 
	 * Reads CSV file given path, and parses it using BoardGeneration.boardMatrixfromcsvFile() and then draws initial gameBoard.
	 * @param pathToBoardConfig path to the CSV file for Spaces
	 */
	public BoardInit(String pathToBoardConfig) {
		gameBoard = new BoardGeneration();
		Path path = Paths.get(pathToBoardConfig);
		boardData = gameBoard.boardMatrixfromcsvFile(path, gameBoard.getNumRows(), gameBoard.getNumColumns(), gameBoard.getSizeElement());
		gameBoard.drawBoard(boardData);
	}
	
	/**
	 * Get BoardGeneration object
	 * @return Returns BoardGeneration object
	 */
	public BoardGeneration getBoardGen() {
		return this.gameBoard;
	}
	
	/**
	 * Gets BoardData, an int[][][] array containing all board space data from csv file
	 * @return Returns BoardData
	 */
	public int[][][] getBoardData() {
		return this.boardData;
	}
}
