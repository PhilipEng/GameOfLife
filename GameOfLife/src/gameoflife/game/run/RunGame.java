package gameoflife.game.run;

import java.util.ArrayList;
import java.util.Arrays;

import gameoflife.board.objects.Spinner;
import gameoflife.board.spaces.Space;
import gameoflife.game.initialise.BoardInit;
import gameoflife.game.initialise.CardInit;
import gameoflife.game.util.EnterDetect;
import gameoflife.player.Player;

public class RunGame {
	
	private int gameOverCountdown;
	
	public RunGame(ArrayList<Player> players, CardInit gameCards, BoardInit gameBoard, Spinner spinner, ArrayList<Space> spaceList) {
		
		this.gameOverCountdown = players.size(); //Decrease each time a player retires
		
		while(gameOverCountdown != 0) {
			gameRound(players, gameCards, gameBoard, spinner, spaceList);
		}
	}
	
	public void gameRound(ArrayList<Player> players, CardInit gameCards, BoardInit gameBoard, Spinner spinner, ArrayList<Space> spaceList){
		for(int i = 0; i < players.size(); i++) {
			playerTurn(players.get(i), gameCards, gameBoard, spinner, players, spaceList);
		}
	}
	
	public void playerTurn(Player player, CardInit gameCards, BoardInit gameBoard, Spinner spinner, ArrayList<Player> players, ArrayList<Space> spaceList){
		System.out.println("---------------------------");
		System.out.println("-- Your Turn " + player.getName());
		System.out.println("---------------------------");
		
		player.printDetails();
		
		if(player.getStatistics().isRetired()) {
			System.out.println(player.getName() + ", you are Retired.");
			System.out.println("You cannot do anything on your turn");
			System.out.println("Press ENTER to End your Turn:");
			EnterDetect enterDetect = new EnterDetect();
			enterDetect.detectEnter();
		} else {
			spinMove(player, gameCards, gameBoard, spinner, players, spaceList);
		}
	}
	
	public void spinMove(Player player, CardInit gameCards, BoardInit gameBoard, Spinner spinner, ArrayList<Player> players, ArrayList<Space> spacesList) {
		System.out.println("Press ENTER to Spin for Move:");
		EnterDetect enterDetect = new EnterDetect();
		enterDetect.detectEnter();
		
		int move = spinner.spin();
		System.out.println("Move Value: " + move);
		
		//Need to fix board gen to use new board design
		gameBoard.getBoardGen().redrawBoard(gameBoard.getBoardData(), players, spacesList);

		Spaces spaces = new Spaces();
		
		int i;
		if(spaces.checkForStop(player)) { //If the player is on a stop at the start of his turn		
			spaces.executeStop(player, gameBoard);	//give player choices for branch if there are choices
			i = 1;//Remove 1 move
		} else {
			i = 0;
		}
		
		while(i < move) {
			if(spaces.spaceBranch(player.getPawn().getSpaceNum(), gameBoard) != 0) {
				player.getPawn().setSpaceNum(player.getPawn().getSpaceNum()); //If the next branch position for the pawn is not zero, move to branch position
			} else {
				player.getPawn().iterateSpaceNum();
			}
			i++;
			
			if(spaces.spaceType(player.getPawn().getSpaceNum(), gameBoard) == 3) { //If the new space is a payday space, PAYDAY
				player.getBankAccount().payday();
			} else if(spaces.checkForStop(player)) {	//If the new space is a stop space, stop moving
				break;		
			}
		}
		//gameBoard.getBoardGen().redrawBoard(gameBoard.getBoardData(), players, spacesList);
		spaces.executeCurrentSpace(player, gameCards, gameBoard);
	}
	
	public void retirePlayer() {
		this.gameOverCountdown --;
	}
	
	public int getGameOverCountdownValue() {
		return this.gameOverCountdown;
	}

}
