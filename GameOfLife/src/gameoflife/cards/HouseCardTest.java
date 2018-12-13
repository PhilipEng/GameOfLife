package gameoflife.cards;

import static org.junit.Assert.*;

import org.junit.Test;

public class HouseCardTest {

	@Test
	public void test_Even_Spinner_Value_gives_Black_Sale_Price() {
		HouseCard ranch = new HouseCard("Ranch", 600000, 600000, 750000);
		
		assertEquals("Even Spinner Value will give the Black Sale Price", ranch.getSalePrice(4), ranch.getSalePriceBlack());
	}
	
	@Test
	public void test_Odd_Spinner_Value_gives_Red_Sale_Price() {
		HouseCard ranch = new HouseCard("Ranch", 600000, 600000, 750000);
		
		assertEquals("Even Spinner Value will give the Red Sale Price", ranch.getSalePrice(5), ranch.getSalePriceRed());
	}
}
