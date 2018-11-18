package gameoflife.game.run;

import java.util.ArrayList;
import java.util.Arrays;

import gameoflife.board.objects.Spinner;
import gameoflife.board.spaces.Space;
import gameoflife.board.spaces.SpaceType;
import gameoflife.game.initialise.BoardInit;
import gameoflife.game.initialise.CardInit;
import gameoflife.game.util.EnterDetect;
import gameoflife.player.Player;

public class RunGame {
	
	private int gameOverCountdown;
	
	public RunGame(ArrayList<Player> players, CardInit gameCards, BoardInit gameBoard, Spinner spinner, ArrayList<Space> spaceList) {
		
		// Need to sort how to end the game 
		// -Check if all players are retired at the start of each players turn?
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
			PlayerMove move = new PlayerMove();
			move.spinMove(player, gameCards, gameBoard, spinner, players, spaceList, false);
		}
	}
	
	/*public void retirePlayer() {
		this.gameOverCountdown --;
	}
	
	public int getGameOverCountdownValue() {
		return this.gameOverCountdown;
	}*/

}
