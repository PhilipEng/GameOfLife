package gameoflife.cards;

public class ActionDeckTest {

	public static void main(String[] args) {
		
		// Initialize Career Cards
		ActionCard card1 = new ActionCard(ActionType.CareerChange);
		ActionCard card2 = new ActionCard(ActionType.PlayersPay, 20000);
		ActionCard card3 = new ActionCard(ActionType.PayBank, 50000);
		ActionCard card4 = new ActionCard(ActionType.GetCash, 100000);
		
		ActionCardDeck actionDeck = new ActionCardDeck();
		actionDeck.addToDeck(card1);
		actionDeck.addToDeck(card2);
		actionDeck.addToDeck(card3);
		actionDeck.addToDeck(card4);
		
		System.out.println("Total cards in action deck: " + actionDeck.getTotalCards());
		actionDeck.shuffle();
		System.out.println("Total cards in action deck: " + actionDeck.getTotalCards());
		
		// Test
		ActionCard test = actionDeck.drawFromDeck();
		test.printDetails();
		System.out.println(actionDeck.getTotalCards());
		test = actionDeck.drawFromDeck();
		test.printDetails();
	}

}
