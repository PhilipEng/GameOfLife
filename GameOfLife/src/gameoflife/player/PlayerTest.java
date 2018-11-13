package gameoflife.player;

import gameoflife.board.objects.Pawn;
import gameoflife.board.objects.PawnColour;

public class PlayerTest {

	public static void main(String[] args) {
		
		Pawn pawn = new Pawn(PawnColour.RED);
		
		Player player = new Player("Jamie", pawn);
		
		player.printDetails();
		
		System.out.println(player.getBankAccount().getBalance());
		player.getBankAccount().decreaseBalance(100000);
		player.getBankAccount().increaseBalance(100000);
		System.out.println(player.getBankAccount().getBalance());
		player.getBankAccount().takeOutLoan();
		System.out.println(player.getBankAccount().getBalance());
		player.getBankAccount().repayLoan();
		System.out.println(player.getBankAccount().getBalance());
		player.getBankAccount().repayLoan();
		System.out.println(player.getBankAccount().getBalance());
	}

}
