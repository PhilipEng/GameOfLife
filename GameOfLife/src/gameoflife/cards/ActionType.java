package gameoflife.cards;

public enum ActionType {
	CAREER_CHANGE, PLAYERS_PAY, PAY_BANK, GET_CASH;
	
	public static ActionType whichAction(String input) {
		if (input.equalsIgnoreCase("CareerChange")) {
			return ActionType.CAREER_CHANGE;
		} else if (input.equalsIgnoreCase("PlayersPay")) {
			return ActionType.PLAYERS_PAY;
		} else if (input.equalsIgnoreCase("PayBank")) {
			return ActionType.PAY_BANK;
		} else {//if (input.equalsIgnoreCase("GetCash")) {
			return ActionType.GET_CASH;
		}
		//else return ERROR
	}
}
