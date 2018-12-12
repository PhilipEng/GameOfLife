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
			System.out.println(players.get(currPlayerIndex).getName() + ": Which player would you like to pay you €" + card.getValue() + "?");
			for(int i = 0; i < players.size(); i++) {
				if(i == currPlayerIndex) {
					continue;
				}else {
					System.out.println("   " + players.get(i).getName() + " - Current Balance: " + players.get(i).getBankAccount().printBalance());
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
							System.out.println();
							System.out.println(players.get(i).getName() + ": ");
							players.get(i).getBankAccount().decreaseBalance(card.getValue()); 
							System.out.println(players.get(currPlayerIndex).getName() + ": ");
							players.get(currPlayerIndex).getBankAccount().increaseBalance(card.getValue());
							playerPresentBoolean = false;
							break;
						}
					}
				}
				if(playerPresentBoolean) {
					System.out.println("The value you entered is not a player's name, enter a player's name:");
					name = scanner.nextLine().toLowerCase();
				}
			}
			break;
		case PAY_BANK:
			players.get(currPlayerIndex).getBankAccount().decreaseBalance(card.getValue());
			break;
		case GET_CASH:
			players.get(currPlayerIndex).getBankAccount().increaseBalance(card.getValue());
			break;
		}
	}
}
