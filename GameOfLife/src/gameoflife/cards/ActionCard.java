package gameoflife.cards;

public class ActionCard extends Card {
	final private ActionType cardType;	// Type of action card
	private int value = 0;					// Value on the card if applicable
	
	// Variables of each card are decided at initialization and cannot be changed after
	public ActionCard(ActionType cardType) {
		this.cardType = cardType;
	}
	public ActionCard(ActionType cardType, int value) {
		this.cardType = cardType;
		this.value = value;
	}
	
	// Method prints details of the career card to the screen
	public void printDetails() {
		System.out.println("---------------------------");
		System.out.println("  Action Card Details  ");
		System.out.println("---------------------------");
		System.out.println("Card Type:    " + this.cardType);
		if(this.cardType != ActionType.CareerChange) {
			System.out.println("Card Value:      " + this.value);
		}
		System.out.println();
	}
	
	// Getters
	
	public ActionType getCardType() {
		return cardType;
	}

	public int getValue() {
		// if(this.cardType == ActionType.CareerChange) return ERROR;
		return value;
	}
}
