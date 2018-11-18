package gameoflife.game.run;

import java.util.HashSet;
import java.util.Set;

import gameoflife.board.spaces.SpaceType;
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
	
	public int getSpaceBranch(int space, BoardInit gameboard) {
		//Return gameBoard branch value
	}
	
	public int getSpaceMerge(int space, BoardInit gameboard) {
		//Return gameBoard merge value
	}
	
	public SpaceType getSpaceType(int space, BoardInit gameBoard) {
		//Return gameBoard space type 
	}
	
	public void executeCurrentSpace(Player player, CardInit gameCards, BoardInit gameBoard) {

		// STOP - if school/family stop, offer branch options  - if they choose to take the branch, set branch = true
		//		- else execute stop space rule
		//		- then call spinMove(player, gameCards, gameBoard, spinner, players, spaceList, branch);
		// PAYDAY - pay land-on-payday bonus (100,000?)
		// ACTION - draw action card use PlayerAction methods
		// RETIRE - player.getStatistics().Retire();
		// HOLIDAY - do nothing
		// HOUSE - use PlayerHouse methods
		// BABY - add babies to playerStatistics
	}
}
