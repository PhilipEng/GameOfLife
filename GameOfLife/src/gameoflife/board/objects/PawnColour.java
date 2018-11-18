package gameoflife.board.objects;

import java.awt.Color;
import java.util.ArrayList;

import java.util.List;

public enum PawnColour {
	RED, YELLOW, BLUE, GREEN;
	
	public static boolean contains(String colour) {
		List<String> pawnColours = new ArrayList<String>();
		pawnColours.add("RED");
		pawnColours.add("YELLOW");
		pawnColours.add("BLUE");
		pawnColours.add("GREEN");
		return pawnColours.contains(colour.toUpperCase());
	}
	public static Color toColor(PawnColour pawnColour) {
		if(pawnColour == RED) return Color.red;
		else if(pawnColour == BLUE) return Color.blue;
		else if(pawnColour == GREEN) return Color.green;
		else return Color.yellow;
	}
}