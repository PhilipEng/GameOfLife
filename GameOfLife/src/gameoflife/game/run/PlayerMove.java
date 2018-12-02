package gameoflife.game.run;

import java.util.ArrayList;

import gameoflife.board.objects.Spinner;
import gameoflife.board.spaces.Space;
import gameoflife.board.spaces.SpaceType;
import gameoflife.game.initialise.BoardInit;
import gameoflife.game.initialise.CardInit;
import gameoflife.game.util.EnterDetect;
import gameoflife.player.Player;

public class PlayerMove {

	public PlayerMove() {
		
	}
	
	public void spinMove(ArrayList<Player> players, int currPlayerIndex, Spinner spinner,  ArrayList<Space> spaceList, boolean branch) {
		System.out.println("Press ENTER to Spin for Move:");
		EnterDetect enterDetect = new EnterDetect();
		enterDetect.detectEnter();
		
		int move = spinner.spin();
		System.out.println("Move Value: " + move);
		
		//Need to fix board gen to use new board design
		//gameBoard.getBoardGen().redrawBoard(gameBoard.getBoardData(), players, spacesList);

		Spaces spaces = new Spaces();
		Space currSpace = spaces.getSpace(players.get(currPlayerIndex).getPawn().getSpaceNum(), spaceList);
		
		System.out.println("Pawn starts turn at space number: " + players.get(currPlayerIndex).getPawn().getSpaceNum());
		
		for(int i = 0; i < move; i++) {
			
			if(currSpace.isBranch() && branch) {	//If we are on a branch space and the user wants to branch
				players.get(currPlayerIndex).getPawn().setSpaceNum(currSpace.getNextSpaceNum());	//Move the pawn to the branch space
			} else if(currSpace.isMerge()) {
				players.get(currPlayerIndex).getPawn().setSpaceNum(currSpace.getNextSpaceNum());	//Move the pawn to the merge space
			} else {
				players.get(currPlayerIndex).getPawn().iterateSpaceNum(); //Move to the next space
			}
			
			currSpace = spaces.getSpace(players.get(currPlayerIndex).getPawn().getSpaceNum(), spaceList); //Update Space
			
			System.out.println("Pawn moves to space number: " + players.get(currPlayerIndex).getPawn().getSpaceNum());
			
			// Check the space type
			if(currSpace.getType() == SpaceType.PAYDAY) {
				System.out.println("You got paid!");
				players.get(currPlayerIndex).getBankAccount().payday();
			} else if(currSpace.getType() == SpaceType.RETIRE) {
				break;	//If the player is on the retirement space, stop moving
			} else if(spaces.checkForStop(currSpace)) {
				break;	//If the player is on a stop spaces, stop moving
			}
		}
	}
}
