package gameoflife.cards;

public enum ActionType {
	CareerChange, PlayersPay, PayBank, GetCash;
	
	public static ActionType whichAction(String input) {
		if (input.equalsIgnoreCase(CareerChange.toString())) {
			return ActionType.CareerChange;
		} else if (input.equalsIgnoreCase(PlayersPay.toString())) {
			return ActionType.PlayersPay;
		} else if (input.equalsIgnoreCase(PayBank.toString())) {
			return ActionType.PayBank;
		} else {//if (input.equalsIgnoreCase(PlayersPay.toString())) {
			return ActionType.GetCash;
		}
		//else return ERROR
	}
}
