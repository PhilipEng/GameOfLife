package gameoflife.board;

import java.util.concurrent.ThreadLocalRandom;

public class Spinner {
	
	private int maxSpin;
	
	private int minSpin;
	
	public Spinner() {
		maxSpin = 10;
		minSpin = 1;
	}
	
	public int spin() {
		return ThreadLocalRandom.current().nextInt(minSpin, maxSpin+1);
	}
}
