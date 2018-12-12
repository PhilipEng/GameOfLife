package gameoflife.game.run;

import java.util.ArrayList;

import gameoflife.player.Player;

public class CheckBonusNums {
	public CheckBonusNums(ArrayList<Player> players, int spinVal) {
		for(int i = 0; i < players.size(); i++) {
			
			if(players.get(i).getStatistics().isWorking() && (spinVal == players.get(i).getInventory().getCareer().getBonusNumber())) {
				System.out.println();
				System.out.println("Congratulations " + players.get(i).getName() + ", your bonus number matched the spinner value!");
				System.out.println();
				players.get(i).getBankAccount().increaseBalance(20000);
			}
		}
	}
}
