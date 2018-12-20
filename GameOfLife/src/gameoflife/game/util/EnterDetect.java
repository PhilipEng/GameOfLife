package gameoflife.game.util;

import java.util.Scanner;

public class EnterDetect {
	public EnterDetect() {
	}
	
	public void detectEnter() {
		@SuppressWarnings("resource") // Suppressed warning for scanner never closed
		Scanner keyboard = new Scanner( System.in );
		@SuppressWarnings("unused") // Suppressed warning for scanner never closed
		String input = keyboard.nextLine();
		//keyboard.close();
	}
}
