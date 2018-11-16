package gameoflife.game.initialise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

import gameoflife.board.spaces.Space;

public class SpacesInit {
 
	private List<Space> spaces;
	
	private int[][][] boardData;
	
	public int numberSpaces;
	
	public SpacesInit(int[][][] boardData) {
		this.boardData = boardData;
		this.numberSpaces = 124;
		spaces = new ArrayList<Space>(this.numberSpaces);
		
	}
	
	public void generateSpaces(){
		int columns = boardData.length;
		int rows = boardData[0].length;
		int sizeData = boardData[0][0].length;
//		System.out.println(Arrays.binarySearch(boardData[1], 12));
		
		
		for(int i = 0; i <columns; i++) {
			for(int j = 0; j < rows; j++) {
				if(this.boardData[i][j][1] != 0) {
					System.out.println(this.spaces.size());
					System.out.println(Arrays.toString(boardData[i][j]));
					this.spaces.add(new Space(boardData[i][j][0],boardData[i][j][1],boardData[i][j][2]));
					
				}
			}
		}
		spaces.sort(Comparator.comparing((Space::getSpaceNum)));
		for(int i = 0; i<numberSpaces; i++) {
			spaces.get(i).printDetails();
		}
	}
}
