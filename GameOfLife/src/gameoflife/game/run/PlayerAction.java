package gameoflife.game.run;

import java.util.ArrayList;
import java.util.Scanner;

import gameoflife.cards.ActionCard;
import gameoflife.cards.Deck;
import gameoflife.player.Player;

public class PlayerAction {
	
	public PlayerAction() {
		
	}
	
	public void actionSpace(ArrayList<Player> players, int currPlayerIndex, Deck actionDeck, Deck careerDeck, Deck collegeDeck) {
		ActionCard cardDrawn = drawActionCard(actionDeck);
		
		cardDrawn.printDetails();
		
		executeAction(cardDrawn, players, currPlayerIndex, careerDeck, collegeDeck);
	}
	
	private ActionCard drawActionCard(Deck actionDeck) {
		return (ActionCard)actionDeck.drawFromDeck();
	}
	
	private void executeAction(ActionCard card, ArrayList<Player> players, int currPlayerIndex, Deck careerDeck, Deck collegeDeck) {
		switch(card.getCardType()) {
		case CAREER_CHANGE:
			PlayerCareers playercareer = new PlayerCareers();
			playercareer.choosePlayerCareer(players.get(currPlayerIndex), careerDeck, collegeDeck);
			break;
		case PLAYERS_PAY:
			System.out.println("Which player would you like to pay you �" + card.getValue() + "?");
			for(int i = 0; i < players.size(); i++) {
				if(i == currPlayerIndex) {
					continue;
				}else {
					System.out.println(players.get(i).getName());
				}
			}
			Scanner scanner = new Scanner( System.in );
			String name = scanner.nextLine().toLowerCase();
			Boolean playerPresentBoolean = true;
			while(playerPresentBoolean) {
				for(int i = 0; i < players.size(); i++) {
					if(i == currPlayerIndex) {
						continue;
					}else {
						if(name.equals(players.get(i).getName().toLowerCase())) {
							players.get(i).getBankAccount().decreaseBalance(card.getValue()); //Need to have option if player does not have sufficient funds > Take loan or sell house
							players.get(currPlayerIndex).getBankAccount().increaseBalance(card.getValue());
							playerPresentBoolean = false;
							break;
						}
					}
				}
				if(playerPresentBoolean) {
					System.out.println("The value you entered is not a player's name, enter a players name:");
					name = scanner.nextLine().toLowerCase();
				}
			}
			break;
		case PAY_BANK:
			if(!players.get(currPlayerIndex).getBankAccount().decreaseBalance(card.getValue())) {
				//player does not have sufficient funds > Take loan or sell house
				// getMoneyOptions
			}
			break;
		case GET_CASH:
			players.get(currPlayerIndex).getBankAccount().increaseBalance(card.getValue());
			break;
		}
	}
}
