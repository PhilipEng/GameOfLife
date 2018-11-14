package gameoflife.game.run;

import java.util.HashSet;
import java.util.Set;

import gameoflife.game.initialise.BoardInit;
import gameoflife.game.initialise.CardInit;
import gameoflife.player.Player;

public class Spaces {
	
	private Set<Integer> stopSpaceNums;
	
	public Spaces() {
		stopSpaceNums = new HashSet<Integer>(); //Add all stop space numbers to list
		stopSpaceNums.add(9);
		stopSpaceNums.add(10);
		stopSpaceNums.add(11);
		stopSpaceNums.add(12);
		stopSpaceNums.add(13);
		stopSpaceNums.add(14);
	}
	
	public boolean checkForStop(Player player){
		if(stopSpaceNums.contains(player.getPawn().getSpaceNum())) {
			return true;
		} else {
			return false;
		}
	}
	
	public void executeStop(Player player, BoardInit gameBoard) {
		//Get branch spaces
	}
	
	public int spaceBranch(int space, BoardInit gameBoard) {
		//Go to space in the gameBoard
		//Return gameBoard branch value
	}
	
	public int spaceType(int space, BoardInit gameBoard) {
		//Go to space in the gameBoard
		//Return gameBoard space type value 
	}
	
	public void executeCurrentSpace(Player player, CardInit gameCards, BoardInit gameBoard) {
		//Case statement for space type
		//Execute certain space options
	}
}
