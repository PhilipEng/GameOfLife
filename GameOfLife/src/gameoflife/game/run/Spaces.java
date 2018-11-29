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
		return 1;
	}
	
	public boolean checkForStop(Space space){
		// Check if space is a stop space
		if(stopSpace.contains(space.getType())) {
			return true;
		} else {
			return false;
		}

	}
	
	public void executeCurrentSpace(Player player, CardInit gameCards, ArrayList<Space> spacesList, ArrayList<Player> players, Spinner spinner, Space space) {

		// STOP - if school/family stop, offer branch options  - if they choose to take the branch, set branch = true
		//		- else execute stop space rule
		//		- then call spinMove(player, gameCards, gameBoard, spinner, players, spaceList, branch);
		// PAYDAY - pay land-on-payday bonus (100,000?)
		// ACTION - draw action card use PlayerAction methods
		// RETIRE - player.getStatistics().Retire();
		// HOLIDAY - do nothing
		// HOUSE - use PlayerHouse methods
		// BABY - add babies to playerStatistics
		
		switch(space.getType()) {
		case PAYDAY:
			System.out.println("Landed on Payday! Get €100,000 payday bonus!");
			player.getBankAccount().increaseBalance(100000);
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
			player.getStatistics().addChildren(1);
			break;
		case TWINS:
			System.out.println("Congratulations! You had twins!");
			player.getStatistics().addChildren(2);
			break;
		case HOUSE:
			System.out.println("You landed on a House space!");
			PlayerHouse  houseSpace = new PlayerHouse();
			player.getInventory().addHouse(houseSpace.chooseHouse(gameCards.getHouseDeck())); 	//Need to add option if player does not want a house.
																								//Need to add option if player wants to take out loan or sell a house
			break;
		case STOP_GRADUATE:
			System.out.println("Congratulations! You have graduated!");
			PlayerCareers playerCareer = new PlayerCareers();
			playerCareer.choosePlayerCareer(player, gameCards.getCareerDeck(), gameCards.getCollegeCareerDeck());
			PlayerMove move = new PlayerMove();
			//move.spinMove(player, gameCards, gameBoard, spinner, players, spaceList, false);
			break;
		case STOP_MARRIAGE:
			System.out.println("Congratulations! You are married!");
			player.getStatistics().getMarried();
			//All players must spin spinner. If odd number, player gifts 100K. If even, player gifts 50k.
			//move
			break;
		case STOP_SCHOOL:
			System.out.println("Would you like to go to night school?");
			//Offer branch option
			//move
			break;
		case STOP_FAMILY:
			System.out.println("Would you like to follow the family path?");
			//Offer branch option
			//move
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
				player.getStatistics().addChildren(1);
			} else if(num < 9) {
				System.out.println("Congratulations! You had twins!");
				player.getStatistics().addChildren(2);
			} else {
				System.out.println("Congratulations! You had triplets!");
				player.getStatistics().addChildren(3);
			}
			//move
			break;
		case STOP_HOLIDAY:
			System.out.println("You are on Holiday!");
			//move
			break;
		case RETIRE:
			System.out.println("Congratulations! You have reached retirement!");
			player.getStatistics().Retire();
			break;
		default:
			break;	
		}
	}
}
