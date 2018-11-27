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
		
	public RunGame(ArrayList<Player> players, CardInit gameCards, BoardInit gameBoard, Spinner spinner, ArrayList<Space> spaceList) {
		
		while(gameRound(players, gameCards, gameBoard, spinner, spaceList)) {} 
	}
	
	// Returns false if the game is finished
	public boolean gameRound(ArrayList<Player> players, CardInit gameCards, BoardInit gameBoard, Spinner spinner, ArrayList<Space> spaceList){
		for(int i = 0; i < players.size(); i++) {
			if(endGame(players)) {
				return false;
			}
			playerTurn(players.get(i), gameCards, gameBoard, spinner, players, spaceList);
			
		} 
		return true;
	}
	
	public void playerTurn(Player player, CardInit gameCards, BoardInit gameBoard, Spinner spinner, ArrayList<Player> players, ArrayList<Space> spaceList){
		System.out.println("---------------------------");
		System.out.println("-- Your Turn " + player.getName());
		System.out.println("---------------------------");
		
		player.printDetails();
		
		if(player.getStatistics().isRetired()) {
			System.out.println(player.getName() + ", you are Retired.");
			System.out.println("You cannot do anything on your turn");
			System.out.println(player.getName() + ": Press ENTER to End your Turn:");
			EnterDetect enterDetect = new EnterDetect();
			enterDetect.detectEnter();
		} else {
			PlayerMove move = new PlayerMove();
			move.spinMove(player, gameCards, gameBoard, spinner, players, spaceList, false);
			System.out.println(player.getName() + ": Press ENTER to End your Turn:");
			EnterDetect enterDetect = new EnterDetect();
			enterDetect.detectEnter();
		}
	}
	
	private boolean endGame(ArrayList<Player> players) {		// At the start of each turn, check if all players are retired
		for(int i = 0; i < players.size(); i++) {				
			if(!players.get(i).getStatistics().isRetired()) {	// If any player is not retired, return false
				return false;
			}
		} return true;
	}

}
