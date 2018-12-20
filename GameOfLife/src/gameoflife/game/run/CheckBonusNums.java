package gameoflife.game.run;

import java.util.ArrayList;

import gameoflife.player.Player;

public class CheckBonusNums {
	/**
	 * CheckBonusNums() will check the spinVal every time a player moves and if the spinVal matches the bonusNumber of a players careers, they will be awarded a bonus
	 * @param players List of Players
	 * @param spinVal Spinner Value to compare the bonus numbers against
	 */
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
