package gameoflife.board.objects;

import java.awt.Color;
import java.util.ArrayList;

import java.util.List;

public enum PawnColour {
	RED, YELLOW, BLUE, GREEN;
	
	/**
	 * Checks if the string colour is a valid PawnColour.
	 * @param colour String to check validity of
	 * @return Returns true if String input is on list of PawnColours
	 */
	public static boolean contains(String colour) {
		List<String> pawnColours = new ArrayList<String>();
		pawnColours.add("RED");
		pawnColours.add("YELLOW");
		pawnColours.add("BLUE");
		pawnColours.add("GREEN");
		return pawnColours.contains(colour.toUpperCase());
	}
	
	/**
	 * Converts pawnColour to a Color object
	 * @param pawnColour PawnColour object to convert
	 * @return Returns a color.
	 */
	public static Color toColor(PawnColour pawnColour) {
		if(pawnColour == RED) return Color.red;
		else if(pawnColour == BLUE) return Color.blue;
		else if(pawnColour == GREEN) return Color.green;
		else return Color.yellow;
	}
}