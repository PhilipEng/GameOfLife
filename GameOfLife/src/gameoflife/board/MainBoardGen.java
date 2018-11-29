package gameoflife.board;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class MainBoardGen {
	public static void main(String[] args){
		BoardGeneration boardGeneration = new BoardGeneration();
		Path path = Paths.get("resource/SpacesTesting.csv");
		int[][][] boardSpaceData = boardGeneration.boardMatrixfromcsvFile(path, boardGeneration.getNumRows(), boardGeneration.getNumColumns(), boardGeneration.getSizeElement()); 
		System.out.println(Arrays.deepToString(boardSpaceData));
		boardGeneration.drawBoard(boardSpaceData);
	}
}
