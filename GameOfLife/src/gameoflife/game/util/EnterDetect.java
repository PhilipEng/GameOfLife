package gameoflife.game.util;

import java.util.Scanner;

public class EnterDetect {
	/**
	 * EnterDetect Constructor
	 */
	public EnterDetect() {
	}
	
	/**
	 * Detects if an input is entered
	 */
	public void detectEnter() {
		@SuppressWarnings("resource") // Suppressed warning for scanner never closed
		Scanner keyboard = new Scanner( System.in );
		@SuppressWarnings("unused") // Suppressed warning for scanner never closed
		String input = keyboard.nextLine();
	}
}
