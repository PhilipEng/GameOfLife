package gameoflife.board.objects;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;


public class PawnTest {

	@Test
	public void test_PawnColour_toColor_method() {
		PawnColour pawnColour = PawnColour.RED;
		Color expectedColor = Color.RED;
		
		assertEquals("Test PawnColour.toColor outputs correct Color value", PawnColour.toColor(pawnColour), expectedColor);
	}
	
	@Test
	public void test_String_input_equals_PawnColour_Valid_Color() {
		String input = "red";
		
		Boolean expected = true;
		
		assertEquals("Test contains() method for valid PawnColour string", PawnColour.contains(input), expected);
	}
	
	@Test
	public void test_String_input_equals_PawnColour_Invalid_Color() {
		String input = "purple";
		
		Boolean expected = false;
		
		assertEquals("Test contains() method for valid PawnColour string", PawnColour.contains(input), expected);
	}

}
