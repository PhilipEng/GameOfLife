package gameoflife.game.run;

import java.util.ArrayList;
import java.util.Scanner;

import gameoflife.cards.ActionCard;
import gameoflife.cards.Deck;
import gameoflife.player.Player;

public class PlayerAction {
	
	/**
	 * PlayerAction constructor
	 */
	public PlayerAction() {
		
	}
	
	/**
	 * actionSpace() details what will happen in the case where a player lands on an Action space.
	 * 
	 * Draws Action Cards from Deck. Prints details of Action Card. Executes the action of the Action Space with executeAction()
	 * @param players List of Player objects
	 * @param currPlayerIndex index of current play in list Players
	 * @param actionDeck Deck of Action Cards
	 * @param careerDeck Deck if Career Cards
	 * @param collegeDeck Deck of College Career Cards
	 */
	public void actionSpace(ArrayList<Player> players, int currPlayerIndex, Deck actionDeck, Deck careerDeck, Deck collegeDeck) {
		ActionCard cardDrawn = drawActionCard(actionDeck);
		
		cardDrawn.printDetails();
		
		executeAction(cardDrawn, players, currPlayerIndex, careerDeck, collegeDeck);
	}
	
	/**
	 * Draws an Action Card from the deck
	 * @param actionDeck Deck of Action Cards
	 * @return Returns the Action card that was drawn from the deck
	 */
	private ActionCard drawActionCard(Deck actionDeck) {
		return (ActionCard)actionDeck.drawFromDeck();
	}
	
	/**
	 * executeAction() will perform the action described by the Action Card
	 * 
	 * Switch statement based on the CardType of the ActionCard
	 * @param card Action Card to be executed
	 * @param players List of Player objects
	 * @param currPlayerIndex Index of current Player in list Players
	 * @param careerDeck Deck of Career Cards
	 * @param collegeDeck Deck of College Career Cards
	 */
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
