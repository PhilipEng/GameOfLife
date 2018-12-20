package gameoflife.cards;

public enum ActionType {
	CAREER_CHANGE, PLAYERS_PAY, PAY_BANK, GET_CASH;
	
	/**
	 * Returns Action Type corresponding to the String input
	 * @param input String input to check which action type it is
	 * @return Returns Action Type
	 */
	public static ActionType whichAction(String input) {
		if (input.equalsIgnoreCase("CareerChange")) {
			return ActionType.CAREER_CHANGE;
		} else if (input.equalsIgnoreCase("PlayersPay")) {
			return ActionType.PLAYERS_PAY;
		} else if (input.equalsIgnoreCase("PayBank")) {
			return ActionType.PAY_BANK;
		} else {
			return ActionType.GET_CASH;
		}
	}
}
