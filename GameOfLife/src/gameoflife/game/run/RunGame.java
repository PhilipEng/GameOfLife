package gameoflife.game.run;

import java.util.ArrayList;

import gameoflife.board.objects.Spinner;
import gameoflife.board.spaces.Space;
import gameoflife.game.initialise.BoardInit;
import gameoflife.game.initialise.CardInit;
import gameoflife.game.util.EnterDetect;
import gameoflife.player.Player;

public class RunGame {
		
	public RunGame(ArrayList<Player> players, CardInit gameCards, Spinner spinner,  ArrayList<Space> spaceList, BoardInit gameBoard) {
		
		while(gameRound(players, gameCards, spinner, spaceList, gameBoard)) {} 
	}
	
	// Returns false if the game is finished
	public boolean gameRound(ArrayList<Player> players, CardInit gameCards, Spinner spinner,  ArrayList<Space> spaceList, BoardInit gameBoard){
		for(int i = 0; i < players.size(); i++) {
			if(endGame(players)) {
				return false;
			}
			playerTurn(players, i, gameCards, spinner, spaceList, gameBoard);
			
		} 
		return true;
	}
	
	public void playerTurn(ArrayList<Player> players, int currPlayerIndex, CardInit gameCards, Spinner spinner,  ArrayList<Space> spaceList, BoardInit gameBoard){
		System.out.println("---------------------------");
		System.out.println("-- Your Turn " + players.get(currPlayerIndex).getName());
		System.out.println("---------------------------");
		
		players.get(currPlayerIndex).printDetails();
		
		if(players.get(currPlayerIndex).getStatistics().isRetired()) {
			System.out.println(players.get(currPlayerIndex).getName() + ", you are Retired.");
			System.out.println("You cannot do anything on your turn");
			System.out.println(players.get(currPlayerIndex).getName() + ": Press ENTER to End your Turn:");
			EnterDetect enterDetect = new EnterDetect();
			enterDetect.detectEnter();
		} else {
			PlayerMove move = new PlayerMove();
			move.spinMove(players, currPlayerIndex, spinner, spaceList, false);
			
			gameBoard.getBoardGen().redrawBoard(gameBoard.getBoardData(), players, spaceList); //Redraw the board after moving
						
			Spaces spaces = new Spaces();
			spaces.executeCurrentSpace(players, currPlayerIndex, gameCards, spinner, spaceList, gameBoard);
			
			System.out.println(players.get(currPlayerIndex).getName() + ": Press ENTER to End your Turn:");
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
