package gameoflife.cards;

import static org.junit.Assert.*;

import org.junit.Test;

public class ActionCardTest {

	@Test
	public void test_CAREER_CHANGE_card_value_is_0() {
		ActionCard card1 = new ActionCard(ActionType.CAREER_CHANGE);
		assertEquals("Card 'value' return value", card1.getValue(), 0);
	}

}
