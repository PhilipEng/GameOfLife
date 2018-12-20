package gameoflife.board.objects;

import java.util.concurrent.ThreadLocalRandom;

public class Spinner {
	
	private int maxSpin;	// Highest number on spinner
	private int minSpin;	// Lowest number on spinner
	
	public Spinner() {
		maxSpin = 10;
		minSpin = 1;
	}
	
	public int spin() {
		return ThreadLocalRandom.current().nextInt(minSpin, maxSpin+1);
	}
}
