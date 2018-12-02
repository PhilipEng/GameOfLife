package gameoflife.game.run;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import gameoflife.board.objects.Spinner;
import gameoflife.board.spaces.Space;
import gameoflife.board.spaces.SpaceType;
import gameoflife.game.initialise.BoardInit;
import gameoflife.game.initialise.CardInit;
import gameoflife.game.util.EnterDetect;
import gameoflife.game.util.OfferChoice;
import gameoflife.player.Player;

public class Spaces {
	
	private Set<SpaceType> stopSpace;
	
	public Spaces() {
		stopSpace = new HashSet<SpaceType>(); //Add all stop space types to list
		stopSpace.add(SpaceType.STOP_GRADUATE);
		stopSpace.add(SpaceType.STOP_MARRIAGE);
		stopSpace.add(SpaceType.STOP_SCHOOL);
		stopSpace.add(SpaceType.STOP_FAMILY);
		stopSpace.add(SpaceType.STOP_BABY);
		stopSpace.add(SpaceType.STOP_HOLIDAY);
		
	}
	
	public Space getSpace(int spaceNum, ArrayList<Space> spacesList) {
		//Return space
		for(int i = 0; i < spacesList.size(); i++) {
			if(spaceNum == spacesList.get(i).getSpaceNum()) {
				return  spacesList.get(i);
			}
		}
		return null;
	}
	
	public int findStart(ArrayList<Space> spacesList) {
		for(int i = 0; i < spacesList.size(); i++) {
			if(spacesList.get(i).getType() == SpaceType.START_CAREER) {
				return  spacesList.get(i).getSpaceNum();
			}
		}
		return 1;
	}
	
	public int findCollegeStart(ArrayList<Space> spacesList) {
		for(int i = 0; i < spacesList.size(); i++) {
			if(spacesList.get(i).getType() == SpaceType.START_COLLEGE) {
				return  spacesList.get(i).getSpaceNum();
			}
		}
		return 1; //If cannot find college start
	}
	
	public boolean checkForStop(Space space){
		// Check if space is a stop space
		if(stopSpace.contains(space.getType())) {
			return true;
		} else {
			return false;
		}
	}
	
	public void executeCurrentSpace(ArrayList<Player> players, int currPlayerIndex, CardInit gameCards, Spinner spinner,  ArrayList<Space> spaceList, BoardInit gameBoard) {
		OfferChoice choice = new OfferChoice();
		Spaces spaces = new Spaces();
		Space currSpace = spaces.getSpace(players.get(currPlayerIndex).getPawn().getSpaceNum(), spaceList);
		
		switch(currSpace.getType()) {
		case PAYDAY:
			System.out.println("Landed on Payday! Get €100,000 payday bonus!");
			players.get(currPlayerIndex).getBankAccount().increaseBalance(100000);
			break;
		case ACTION:
			System.out.println("You landed on an Action Space!");
			PlayerAction actionSpace = new PlayerAction();
			//actionSpace.actionSpace(gameCards.getActionDeck(), players, playerIndex, careerDeck, collegeDeck);
			break;
		case HOLIDAY:
			System.out.println("You are on Holiday!");
			break;
		case SPIN_TO_WIN:
			System.out.println("You landed on a Spin To Win space!");
			//Execute
			break;
		case BABY:
			System.out.println("Congratulations! You have a new baby!");
			players.get(currPlayerIndex).getStatistics().addChildren(1);
			break;
		case TWINS:
			System.out.println("Congratulations! You had twins!");
			players.get(currPlayerIndex).getStatistics().addChildren(2);
			break;
		case HOUSE:
			System.out.println("You landed on a House space!");
			PlayerHouse  houseSpace = new PlayerHouse();
			players.get(currPlayerIndex).getInventory().addHouse(houseSpace.chooseHouse(gameCards.getHouseDeck())); 	//Need to add option if player does not want a house.
																								//Need to add option if player wants to take out loan or sell a house
			break;
		case STOP_GRADUATE:
			System.out.println("Congratulations! You have graduated!");
			PlayerCareers playerCareer = new PlayerCareers();
			playerCareer.choosePlayerCareer(players.get(currPlayerIndex), gameCards.getCareerDeck(), gameCards.getCollegeCareerDeck());
			executeStop(players, currPlayerIndex, gameCards, false, spinner, spaceList, gameBoard);
			break;
		case STOP_MARRIAGE:
			System.out.println("Congratulations! You are married!");
			players.get(currPlayerIndex).getStatistics().getMarried();
			executeMarriageGift(players, currPlayerIndex, spinner);
			executeStop(players, currPlayerIndex, gameCards, false, spinner, spaceList, gameBoard);			
			break;
		case STOP_SCHOOL:
			System.out.println("Would you like to go to night school?");
			boolean school = choice.yesOrNo();
			if(school) {
				PlayerCareers playercareer = new PlayerCareers();
				playercareer.educatePlayer(players.get(currPlayerIndex));
				playercareer.choosePlayerCareer(players.get(currPlayerIndex), gameCards.getCareerDeck(), gameCards.getCollegeCareerDeck());
			}
			executeStop(players, currPlayerIndex, gameCards, school, spinner, spaceList, gameBoard);		
			break;
		case STOP_FAMILY:
			System.out.println("Would you like to follow the family path?");
			boolean family = choice.yesOrNo();
			executeStop(players, currPlayerIndex, gameCards, family, spinner, spaceList, gameBoard);		
			break;
		case STOP_BABY:
			System.out.println("Congratulations! You are having children!");
			System.out.println("Spin for the number of children!");
			System.out.println("Press ENTER to Spin for children:");
			EnterDetect enterDetect = new EnterDetect();
			enterDetect.detectEnter();
			
			int num = spinner.spin();
			if(num < 4) {
				System.out.println("You did not have any children...");
			} else if(num < 7) {
				System.out.println("Congratulations! You have a new baby!");
				players.get(currPlayerIndex).getStatistics().addChildren(1);
			} else if(num < 9) {
				System.out.println("Congratulations! You had twins!");
				players.get(currPlayerIndex).getStatistics().addChildren(2);
			} else {
				System.out.println("Congratulations! You had triplets!");
				players.get(currPlayerIndex).getStatistics().addChildren(3);
			}
			executeStop(players, currPlayerIndex, gameCards, false, spinner, spaceList, gameBoard);
			break;
		case STOP_HOLIDAY:
			System.out.println("You are on Holiday!");
			executeStop(players, currPlayerIndex, gameCards, false, spinner, spaceList, gameBoard);
			break;
		case RETIRE:
			System.out.println("Congratulations! You have reached retirement!");
			players.get(currPlayerIndex).getStatistics().Retire();
			break;
		default:
			break;	
		}
	}
	
	private void executeStop(ArrayList<Player> players, int currPlayerIndex, CardInit gameCards, boolean branch, Spinner spinner,  ArrayList<Space> spaceList, BoardInit gameBoard) {
		PlayerMove move = new PlayerMove();
		move.spinMove(players, currPlayerIndex, spinner, spaceList, branch);
		
		gameBoard.getBoardGen().redrawBoard(gameBoard.getBoardData(), players, spaceList); //Redraw the board after moving
		
		executeCurrentSpace(players, currPlayerIndex, gameCards, spinner, spaceList, gameBoard);
	}
	
	private void executeMarriageGift(ArrayList<Player> players, int currPlayerIndex, Spinner spinner) {
		//All players must spin spinner. If odd number, player gifts 100K. If even, player gifts 50k.
		for(int i = 0; i < players.size(); i++) {
			if(i == currPlayerIndex) {
				continue;
			}else {
				System.out.println();
				System.out.println(players.get(i).getName() + ": Press ENTER to Spin:");
				EnterDetect enterDetect = new EnterDetect();
				enterDetect.detectEnter();
				int value;
				if((spinner.spin() % 2) == 1) {
					value = 100000;
				} else {
					value = 50000;
				}
				System.out.println(players.get(i).getName() + ", you gift " + players.get(currPlayerIndex).getName() + " €" + value);
				players.get(i).getBankAccount().decreaseBalance(value);
				players.get(currPlayerIndex).getBankAccount().increaseBalance(value);
			}
		}
	}
}
