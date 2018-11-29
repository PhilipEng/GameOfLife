package gameoflife.game.run;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import gameoflife.board.spaces.Space;
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
		return 0;
	}
	
	public int getSpaceMerge(int space, BoardInit gameboard) {
		//Return gameBoard merge value
		return 0;
	}
	
	public SpaceType getSpaceType(int space, ArrayList<Space> spacesList) {
		//Return gameBoard space type 
		for(int i = 0; i < spacesList.size(); i++) {
			if(space+1 == spacesList.get(i).getSpaceNum()) {
				return  spacesList.get(i).getType();
			}
		}
		return null;
	}
	
	public void executeCurrentSpace(Player player, CardInit gameCards, ArrayList<Space> spacesList) {

		// STOP - if school/family stop, offer branch options  - if they choose to take the branch, set branch = true
		//		- else execute stop space rule
		//		- then call spinMove(player, gameCards, gameBoard, spinner, players, spaceList, branch);
		// PAYDAY - pay land-on-payday bonus (100,000?)
		// ACTION - draw action card use PlayerAction methods
		// RETIRE - player.getStatistics().Retire();
		// HOLIDAY - do nothing
		// HOUSE - use PlayerHouse methods
		// BABY - add babies to playerStatistics
		Space space = null;
		for(int i = 0; i < spacesList.size(); i++) {
			if(player.getPawn().getSpaceNum() == spacesList.get(i).getSpaceNum()) {
				space = spacesList.get(i);
				break;
			}
		}
		
		switch(space.getType()) {
			case RETIRE:
				player.getStatistics().Retire();
				break;
			default:
				break;	
		}
	}
}
