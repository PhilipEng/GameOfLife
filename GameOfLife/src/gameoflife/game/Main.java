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
	}

}
