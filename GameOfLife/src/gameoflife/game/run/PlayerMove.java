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
	
	public void spinMove(Player player, CardInit gameCards, BoardInit gameBoard, Spinner spinner, ArrayList<Player> players, ArrayList<Space> spacesList, boolean branch) {
		System.out.println("Press ENTER to Spin for Move:");
		EnterDetect enterDetect = new EnterDetect();
		enterDetect.detectEnter();
		
		int move = spinner.spin();
		System.out.println("Move Value: " + move);
		
		//Need to fix board gen to use new board design
		//gameBoard.getBoardGen().redrawBoard(gameBoard.getBoardData(), players, spacesList);

		Spaces spaces = new Spaces();
		
		for(int i = 0; i < move; i++) {
			if(branch) { // If the player is branching, move to branch value
				player.getPawn().setSpaceNum(spaces.getSpaceBranch(player.getPawn().getSpaceNum(), gameBoard)); //If the next branch position for the pawn is not zero, move to branch position
			} else if(spaces.getSpaceMerge(player.getPawn().getSpaceNum(), gameBoard) != 0) { // If player is merging, move to merge value
				player.getPawn().setSpaceNum(spaces.getSpaceMerge(player.getPawn().getSpaceNum(), gameBoard)); //If the next branch position for the pawn is not zero, move to branch position
			} else {
				player.getPawn().iterateSpaceNum();
			}
			
			if(spaces.getSpaceType(player.getPawn().getSpaceNum(), gameBoard) == SpaceType.PAYDAY) { //If the new space is a payday space, PAYDAY
				player.getBankAccount().payday();
			} else if(spaces.getSpaceType(player.getPawn().getSpaceNum(), gameBoard) == SpaceType.RETIRE) { //If the space is a retire space don't move anymore
				break;
			} else if(spaces.checkForStop(player)) {	//If the new space is a stop space, stop moving
				break;		
			}
		}
		
		gameBoard.getBoardGen().redrawBoard(gameBoard.getBoardData(), players, spacesList);
		spaces.executeCurrentSpace(player, gameCards, gameBoard);
		
	}
}
