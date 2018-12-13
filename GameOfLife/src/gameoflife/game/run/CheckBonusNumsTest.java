package gameoflife.game.run;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import gameoflife.bank.Balance;
import gameoflife.board.objects.Pawn;
import gameoflife.board.objects.PawnColour;
import gameoflife.cards.CareerCard;
import gameoflife.player.Player;

public class CheckBonusNumsTest {

	@Test
	public void test_PlayerHasBonusNumber() {
		ArrayList<Player> players = new ArrayList<Player>();
		
		Pawn pawn1 = new Pawn(PawnColour.RED);
		Pawn pawn2 = new Pawn(PawnColour.BLUE);
		Pawn pawn3 = new Pawn(PawnColour.GREEN);
		
		Player player1 = new Player("Player1", pawn1);
		Player player2 = new Player("Player2", pawn2);
		Player player3 = new Player("Player3", pawn3);
		
		CareerCard actor = new CareerCard("Actor", 100000, 5);
		CareerCard inventor = new CareerCard("Inventor", 80000, 4);
		CareerCard singer = new CareerCard("Singer", 70000, 3);
		
		player1.getInventory().setCareer(actor);
		player1.getStatistics().gotJob();
		player2.getInventory().setCareer(inventor);
		player2.getStatistics().gotJob();
		player3.getInventory().setCareer(singer);
		player3.getStatistics().gotJob();
		
		players.add(player1);
		players.add(player2);
		players.add(player3);
		
		@SuppressWarnings("unused")
		CheckBonusNums bonusNums = new CheckBonusNums(players, 4);
		
		int expected = Balance.INITIALBALANCE + 20000;
		
		assertEquals("Player2 recieved the bonus as evident by his balance increase", players.get(1).getBankAccount().getBalance(), expected);
	}
	
	@Test
	public void test_NoPlayerHasBonusNumber() {
		ArrayList<Player> players = new ArrayList<Player>();
		
		Pawn pawn1 = new Pawn(PawnColour.RED);
		Pawn pawn2 = new Pawn(PawnColour.BLUE);
		Pawn pawn3 = new Pawn(PawnColour.GREEN);
		
		Player player1 = new Player("Player1", pawn1);
		Player player2 = new Player("Player2", pawn2);
		Player player3 = new Player("Player3", pawn3);
		
		CareerCard actor = new CareerCard("Actor", 100000, 5);
		CareerCard inventor = new CareerCard("Inventor", 80000, 4);
		CareerCard singer = new CareerCard("Singer", 70000, 3);
		
		player1.getInventory().setCareer(actor);
		player1.getStatistics().gotJob();
		player2.getInventory().setCareer(inventor);
		player2.getStatistics().gotJob();
		player3.getInventory().setCareer(singer);
		player3.getStatistics().gotJob();
		
		players.add(player1);
		players.add(player2);
		players.add(player3);
		
		@SuppressWarnings("unused")
		CheckBonusNums bonusNums = new CheckBonusNums(players, 6);
		
		int unexpected = Balance.INITIALBALANCE + 20000;
		
		for(int i = 0; i < players.size(); i++) {
			if(players.get(i).getBankAccount().getBalance() == unexpected) {
				fail("A player got the bonus number");
			}
		}
		
	}

}
