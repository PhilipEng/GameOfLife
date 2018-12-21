package gameoflife.game.run;

import java.util.ArrayList;

import gameoflife.board.objects.Spinner;
import gameoflife.board.spaces.Space;
import gameoflife.board.spaces.SpaceType;
import gameoflife.game.util.EnterDetect;
import gameoflife.player.Player;

public class PlayerMove {

	/**
	 * PlayerMove Constructor
	 */
	public PlayerMove() {
		
	}
	
	/**
	 * spinMove() method controls the action of a player on a single turn (1 spin). 
	 * 
	 * Players spins the spinner, then moves forward depending on the spaces it is on.
	 * If player lands on retirement or stop space, their movement will stop.
	 * @param players List of Player object playing the game
	 * @param currPlayerIndex Index of the Player whose turn it currently is.
	 * @param spinner Spinner 
	 * @param spaceList List of Space objects that have been sorted by Space Number
	 * @param branch Whether the player is branching (true).
	 */
	public void spinMove(ArrayList<Player> players, int currPlayerIndex, Spinner spinner,  ArrayList<Space> spaceList, boolean branch) {
		System.out.println(players.get(currPlayerIndex).getName() + ": Press ENTER to Spin for Move:");
		EnterDetect enterDetect = new EnterDetect();
		enterDetect.detectEnter();
		
		int move = spinner.spin();
		System.out.println("Move Value: " + move);
		System.out.println();
		
		@SuppressWarnings("unused")
		CheckBonusNums bonusNums = new CheckBonusNums(players, move);

		Spaces spaces = new Spaces();
		Space currSpace = spaces.getSpace(players.get(currPlayerIndex).getPawn().getSpaceNum(), spaceList);
		
		for(int i = 0; i < move; i++) {
			
			if(currSpace.isBranch() && branch) {	//If we are on a branch space and the user wants to branch
				players.get(currPlayerIndex).getPawn().setSpaceNum(currSpace.getNextSpaceNum());	//Move the pawn to the branch space
			} else if(currSpace.isMerge()) {
				players.get(currPlayerIndex).getPawn().setSpaceNum(currSpace.getNextSpaceNum());	//Move the pawn to the merge space
			} else {
				players.get(currPlayerIndex).getPawn().iterateSpaceNum(); //Move to the next space
			}
			
			currSpace = spaces.getSpace(players.get(currPlayerIndex).getPawn().getSpaceNum(), spaceList); //Update Space
			
			
			// Check the space type
			if(currSpace.getType() == SpaceType.PAYDAY) {
				System.out.println(players.get(currPlayerIndex).getName() + ": You got paid!");
				players.get(currPlayerIndex).getBankAccount().payday();
			} else if(currSpace.getType() == SpaceType.RETIRE) {
				break;	//If the player is on the retirement space, stop moving
			} else if(spaces.checkForStop(currSpace)) {
				break;	//If the player is on a stop spaces, stop moving
			}
		}
	}
}
