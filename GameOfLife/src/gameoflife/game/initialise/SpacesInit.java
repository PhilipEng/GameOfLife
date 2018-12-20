package gameoflife.game.initialise;

import java.util.ArrayList;
import java.util.Comparator;

import gameoflife.board.spaces.Space;

public class SpacesInit {
 
	private ArrayList<Space> spaces;
	
	private int[][][] boardData;
	
	private int numberSpaces;
	
	public SpacesInit(int[][][] boardData) {
		this.boardData = boardData;
		this.numberSpaces = 124;
		spaces = new ArrayList<Space>(this.numberSpaces);
		
	}
	
	public void generateSpaces(){
		int columns = boardData.length;
		int rows = boardData[0].length;
		
		for(int i = 0; i <columns; i++) {
			for(int j = 0; j < rows; j++) {
				if(this.boardData[i][j][1] != 0) {
					this.spaces.add(new Space(boardData[i][j][0],boardData[i][j][1],boardData[i][j][2], j, i));
					
				}
			}
		}
		this.spaces.sort(Comparator.comparing((Space::getSpaceNum)));
//		for(int i = 0; i<numberSpaces; i++) {
//			this.spaces.get(i).printDetails();
//		}
	}
	
	public ArrayList<Space> getSpaces(){
		return this.spaces;
	}
}
