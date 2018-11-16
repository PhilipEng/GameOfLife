package gameoflife.game.run;

import java.util.ArrayList;
import java.util.Scanner;

import gameoflife.cards.ActionCard;
import gameoflife.cards.Deck;
import gameoflife.player.Player;

public class PlayerAction {
	
	public PlayerAction() {
		
	}
	
	public void actionSpace(Deck deck, ArrayList<Player> players, int playerIndex, Deck careerDeck, Deck collegeDeck) {
		ActionCard cardDrawn = drawActionCard(deck);
		
		cardDrawn.printDetails();
		
		executeAction(cardDrawn, players, playerIndex, careerDeck, collegeDeck);
	}
	
	private ActionCard drawActionCard(Deck deck) {
		return (ActionCard)deck.drawFromDeck();
	}
	
	private void executeAction(ActionCard card, ArrayList<Player> players, int playerIndex, Deck careerDeck, Deck collegeDeck) {
		switch(card.getCardType()) {
		case CAREER_CHANGE:
			PlayerCareers playercareer = new PlayerCareers();
			playercareer.choosePlayerCareer(players.get(playerIndex), careerDeck, collegeDeck);
			break;
		case PLAYERS_PAY:
			System.out.println("Which player would you like to pay you €" + card.getValue() + "?");
			for(int i = 0; i < players.size(); i++) {
				if(i == playerIndex) {
					continue;
				}else {
					System.out.println(players.get(i).getName());
				}
			}
			Scanner scanner = new Scanner( System.in );
			String name = scanner.nextLine().toLowerCase();
			for(int i = 0; i < players.size(); i++) {
				if(i == playerIndex) {
					continue;
				}else {
					if(name.equals(players.get(i).getName().toLowerCase())) {
						players.get(i).getBankAccount().decreaseBalance(card.getValue()); //Need to have option if player does not have sufficient funds > Take loan or sell house
						players.get(playerIndex).getBankAccount().increaseBalance(card.getValue());
						break;
					}
				}
			}
			break;
		case PAY_BANK:
			players.get(playerIndex).getBankAccount().decreaseBalance(card.getValue());//Need to have option if player does not have sufficient funds > Take loan or sell house
			break;
		case GET_CASH:
			players.get(playerIndex).getBankAccount().increaseBalance(card.getValue());
			break;
		}
	}
}
