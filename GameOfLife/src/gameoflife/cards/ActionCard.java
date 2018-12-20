package gameoflife.cards;

public class ActionCard extends Card {
	final private ActionType cardType;	// Type of action card
	private int value = 0;					// Value on the card if applicable
	
	// Variables of each card are decided at initialization and cannot be changed after
	
	/**
	 * ActionCard constructor.
	 * @param cardType Card Type of the Action Card
	 */
	public ActionCard(ActionType cardType) {
		this.cardType = cardType;
	}
	
	/**
	 * ActionCard constructor.
	 * 
	 * @param cardType Card Type of the Action Card
	 * @param value Value of card
	 */
	public ActionCard(ActionType cardType, int value) {
		this.cardType = cardType;
		this.value = value;
	}
	
	/**
	 * Method prints details of the career card to the screen
	 */
	public void printDetails() {
		System.out.println("---------------------------");
		System.out.println("  Action Card Details  ");
		System.out.println("---------------------------");
		System.out.println("Card Type:    " + this.cardType);
		if(this.cardType != ActionType.CAREER_CHANGE) {
			System.out.println("Card Value:   €" + this.value);
		}
		System.out.println();
	}
	
	
	/**
	 * Gets ActionType of Action Card
	 * @return Returns Action Type
	 */
	public ActionType getCardType() {
		return cardType;
	}

	/**
	 * Returns value of ActionCard
	 * @return Returns Value
	 */
	public int getValue() {
		return value;
	}
}
