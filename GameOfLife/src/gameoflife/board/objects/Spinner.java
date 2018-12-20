package gameoflife.board.objects;

import java.util.concurrent.ThreadLocalRandom;

public class Spinner {
	
	private int maxSpin;
	
	private int minSpin;
	
	/**
	 * Spinner Class, sets maximum and minimum possible spinner value
	 */
	public Spinner() {
		maxSpin = 10;
		minSpin = 1;
	}
	
	/**
	 * spin() returns a random number between minSpin and maxSpin
	 * @return return Int spinner value
	 */
	public int spin() {
		return ThreadLocalRandom.current().nextInt(minSpin, maxSpin+1);
	}
}
