package gameoflife.player;

import static org.junit.Assert.*;

import org.junit.Test;

public class StatisticsTest {

	@Test
	public void test_IncreaseNumChildren() {
		Statistics stats = new Statistics();
		
		stats.getMarried();
		
		stats.addChildren(2);
		
		assertEquals("Number of children increased by 2", stats.getNumChildren(), 2);
	}
	
	@Test
	public void test_IncreaseNumBabiesPast4() {
		Statistics stats = new Statistics();
		
		stats.getMarried();
		
		stats.addChildren(5);
		
		assertEquals("Number of children increased by 5 so should be set to max of 4", stats.getNumChildren(), 4);
	}

}
