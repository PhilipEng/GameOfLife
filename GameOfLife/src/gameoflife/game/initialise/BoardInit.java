package gameoflife.game.initialise;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import gameoflife.board.BoardGeneration;

public class BoardInit {
	
	private BoardGeneration gameBoard;
	private int[][][] boardData;
	
	public BoardInit(String pathToBoardConfig) {
		gameBoard = new BoardGeneration();
		Path path = Paths.get(pathToBoardConfig);
		boardData = gameBoard.boardMatrixfromcsvFile(path, gameBoard.getNumRows(), gameBoard.getNumColumns(), gameBoard.getSizeElement()); 
		System.out.println(Arrays.deepToString(boardData));
		gameBoard.drawBoard(boardData);
	}
	
	public BoardGeneration getBoardGen() {
		return this.gameBoard;
	}
	
	public int[][][] getBoardData() {
		return this.boardData;
	}
}
