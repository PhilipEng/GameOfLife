package gameoflife.game.run;

import java.util.ArrayList;

import gameoflife.board.objects.Spinner;
import gameoflife.board.spaces.Space;
import gameoflife.game.initialise.BoardInit;
import gameoflife.game.initialise.CardInit;
import gameoflife.game.util.EnterDetect;
import gameoflife.player.Player;

public class RunGame {
		
	/**
	 * RunGame constructor, while gameRound returns true, it will continually run.
	 * @param players List of Player objects playing the game
	 * @param gameCards CardInit object, initialisation if all card objects used in the game
	 * @param spinner Spinner, for determining Spinner values.
	 * @param spaceList List of Space Objects, sorted by Space Number
	 * @param gameBoard BoardInit containing game board visualisation
	 */
	public RunGame(ArrayList<Player> players, CardInit gameCards, Spinner spinner,  ArrayList<Space> spaceList, BoardInit gameBoard) {
		
		while(gameRound(players, gameCards, spinner, spaceList, gameBoard)) {} 
	}
	
	// Returns false if the game is finished
	/**
	 * gameRound() method continually runs while the game is not finished, when all players have retired the method will return false, and the method will finish.
	 * 
	 * Calls playerTurn() every loop, so controls the order players take their turns
	 * @param players List of Player object playing the game
	 * @param gameCards CardInit object, initialisation if all card objects used in the game
	 * @param spinner Spinner, for determining Spinner values.
	 * @param spaceList List of Space Objects, sorted by Space Number
	 * @param gameBoard BoardInit containing game board visualisation
	 * @return Returns Boolean false when all players have retired
	 */
	public boolean gameRound(ArrayList<Player> players, CardInit gameCards, Spinner spinner,  ArrayList<Space> spaceList, BoardInit gameBoard){
		for(int i = 0; i < players.size(); i++) {
			if(endGame(players)) {
				return false;
			}
			playerTurn(players, i, gameCards, spinner, spaceList, gameBoard);
			
		} 
		return true;
	}
	
	/**
	 * playerTurn() is the turn manager for a general turn of a player.
	 * 
	 * Prints players details. If player is retired, end turn.
	 * Otherwise, calls a spinMove(). Redraws gameBoard reflecting updated player position.
	 * Calls executeCurrentSpace() to perform action based on the current space the player is on.
	 * @param players List of Player objects playing the game
	 * @param currPlayerIndex Index of the current Player in players whose turn it is.
	 * @param gameCards CardInit object, initialisation if all card objects used in the game
	 * @param spinner Spinner, for determining Spinner values.
	 * @param spaceList List of Space Objects, sorted by Space Number
	 * @param gameBoard BoardInit containing game board visualisation
	 */
	public void playerTurn(ArrayList<Player> players, int currPlayerIndex, CardInit gameCards, Spinner spinner,  ArrayList<Space> spaceList, BoardInit gameBoard){
		System.out.println();
		System.out.println("---------------------------------------------------------------");
		System.out.println("--- " + players.get(currPlayerIndex).getName() + ": Your Turn ");
		System.out.println("---------------------------------------------------------------");
		
		players.get(currPlayerIndex).printDetails();
		
		if(players.get(currPlayerIndex).getStatistics().isRetired()) {
			System.out.println(players.get(currPlayerIndex).getName() + ", you are Retired.");
			System.out.println("You cannot do anything on your turn");
		} else {
			PlayerMove move = new PlayerMove();
			move.spinMove(players, currPlayerIndex, spinner, spaceList, false);
			
			gameBoard.getBoardGen().redrawBoard(gameBoard.getBoardData(), players, spaceList); //Redraw the board after moving
						
			Spaces spaces = new Spaces();
			spaces.executeCurrentSpace(players, currPlayerIndex, gameCards, spinner, spaceList, gameBoard);
		}
		System.out.println(players.get(currPlayerIndex).getName() + ": Press ENTER to End your Turn:");
		EnterDetect enterDetect = new EnterDetect();
		enterDetect.detectEnter();
	}
	
	/**
	 * endGame() method checks the retirement status of all of the players and if everybody is retired it returns true, indicating that End Game should be triggered.
	 * @param players List of Player object playing the game
	 * @return Boolean true if all players are retired
	 */
	private boolean endGame(ArrayList<Player> players) {		// At the start of each turn, check if all players are retired
		for(int i = 0; i < players.size(); i++) {				
			if(!players.get(i).getStatistics().isRetired()) {	// If any player is not retired, return false
				return false;
			}
		} return true;
	}

}
