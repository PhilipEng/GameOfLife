package gameoflife.game;

import java.util.ArrayList;

import gameoflife.cards.CareerCardDeck;
import gameoflife.player.Player;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GameInit gameInit = new GameInit();
		
		CareerCardDeck careerDeck = new CareerCardDeck();
		CareerCardDeck collegeCareerDeck = new CareerCardDeck();
		
		careerDeck = gameInit.buildCareerDeck();
		collegeCareerDeck = gameInit.buildCollegeCareerDeck();
		
		PlayerInit playerInit = new PlayerInit();
		
		ArrayList<Player> players = new ArrayList<Player>();
		
		players = playerInit.buildPlayers();
		
		playerInit.chooseCareer(players, careerDeck, collegeCareerDeck);
		
		System.out.println("Debiting $280k from " +players.get(0).name +"'s account.");

		players.get(0).decreaseBalanceBy(280000);
		
		players.get(0).printDetails();

	}

}
