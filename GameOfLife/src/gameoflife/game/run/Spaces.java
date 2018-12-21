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

	
	/**
	 * Spaces constructor, adds all stop spaces to stopSpace set
	 */
	public Spaces() {
		stopSpace = new HashSet<SpaceType>(); //Add all stop space types to list
		stopSpace.add(SpaceType.STOP_GRADUATE);
		stopSpace.add(SpaceType.STOP_MARRIAGE);
		stopSpace.add(SpaceType.STOP_SCHOOL);
		stopSpace.add(SpaceType.STOP_FAMILY);
		stopSpace.add(SpaceType.STOP_BABY);
		stopSpace.add(SpaceType.STOP_HOLIDAY);
		
	}
	
	/**
	 * getSpace() returns the space that is indicated by the spaceNum in the list spacesList
	 * 
	 * @param spaceNum Number of the Space to find
	 * @param spacesList List of all Spaces
	 * @return return the space that was found with Space Number matching spaceNum
	 */
	public Space getSpace(int spaceNum, ArrayList<Space> spacesList) { //Return space
		for(int i = 0; i < spacesList.size(); i++) {
			if(spaceNum == spacesList.get(i).getSpaceNum()) {
				return  spacesList.get(i);
			}
		}
		return null;
	}
	
	/**
	 * findStart() method looks for the Career Path start space in the spacesList
	 * @param spacesList List of all Spaces
	 * @return returns int index of SpaceNum of start space
	 */
	public int findStart(ArrayList<Space> spacesList) {
		for(int i = 0; i < spacesList.size(); i++) {
			if(spacesList.get(i).getType() == SpaceType.START_CAREER) {
				return  spacesList.get(i).getSpaceNum();
			}
		}
		return 1;
	}
	
	/**
	 * findStart() method looks for the College Career Path start space in the spacesList
	 * @param spacesList List of all Spaces
	 * @return returns int index of SpaceNum of start space
	 */
	public int findCollegeStart(ArrayList<Space> spacesList) {
		for(int i = 0; i < spacesList.size(); i++) {
			if(spacesList.get(i).getType() == SpaceType.START_COLLEGE) {
				return  spacesList.get(i).getSpaceNum();
			}
		}
		return 1; //If cannot find college start
	}
	
	/**
	 * checkForStop() method checks whether a given space is a stop space
	 * @param space Space to be checked for stop type
	 * @return Returns true if the space is a stop space
	 */
	public boolean checkForStop(Space space){
		// Check if space is a stop space
		if(stopSpace.contains(space.getType())) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * executeCurrentSpace() determines what action should be performed based on the space that the player has landed on.
	 * 
	 * Contains switch statement where the spacetype of the current space is the condition.
	 * Executes a different action based on that SpaceType.
	 * Some basic spaces like Payday Spaces have all their action included in the switch case, but more complicated spaces, like Spin2Win space has its own method executeSpinToWin().
	 * Some stop spaces share an executeStop() method, that allows the player to respin.
	 * @param players List of Player objects playing the game
	 * @param currPlayerIndex Index of the current player in players, whose turn it is
	 * @param gameCards Contains all the Cards/Decks needed
	 * @param spinner Spinner
	 * @param spaceList List of Spaces
	 * @param gameBoard Game Board Visualisation
	 */
	public void executeCurrentSpace(ArrayList<Player> players, int currPlayerIndex, CardInit gameCards, Spinner spinner,  ArrayList<Space> spaceList, BoardInit gameBoard) {
		OfferChoice choice = new OfferChoice();
		Spaces spaces = new Spaces();
		Space currSpace = spaces.getSpace(players.get(currPlayerIndex).getPawn().getSpaceNum(), spaceList);
		
		switch(currSpace.getType()) {
		case PAYDAY:
			System.out.println(players.get(currPlayerIndex).getName() + ": You landed on Payday! Get €100,000 payday bonus!");
			players.get(currPlayerIndex).getBankAccount().increaseBalance(100000);
			break;
		case ACTION:
			System.out.println(players.get(currPlayerIndex).getName() + ": You landed on an Action Space!");
			players.get(currPlayerIndex).getInventory().increaseActionCards();
			PlayerAction actionSpace = new PlayerAction();
			actionSpace.actionSpace(players, currPlayerIndex, gameCards.getActionDeck(), gameCards.getCareerDeck(), gameCards.getCollegeCareerDeck());
			break;
		case HOLIDAY:
			System.out.println(players.get(currPlayerIndex).getName() + ": You are on Holiday!");
			break;
		case SPIN_TO_WIN:
			System.out.println(players.get(currPlayerIndex).getName() + ": You landed on a Spin To Win space!");
			executeSpinToWin(players, currPlayerIndex, spinner);
			break;
		case BABY:
			System.out.println(players.get(currPlayerIndex).getName() + ": Congratulations! You have a new baby!");
			players.get(currPlayerIndex).getStatistics().addChildren(1);
			break;
		case TWINS:
			System.out.println(players.get(currPlayerIndex).getName() + ": Congratulations! You had twins!");
			players.get(currPlayerIndex).getStatistics().addChildren(2);
			break;
		case HOUSE:
			System.out.println(players.get(currPlayerIndex).getName() + ": You landed on a House space!");
			String answer = choice.houseSpaceOptions();
			PlayerHouse  houseSpace = new PlayerHouse();
			if(answer.contentEquals("SELL")) {
				houseSpace.chooseAndSellHouse(gameCards.getHouseDeck(), players.get(currPlayerIndex), spinner);
			}
			else if(answer.contentEquals("BUY")) {
				houseSpace.chooseHouse(gameCards.getHouseDeck(), players.get(currPlayerIndex));
			}
			break;
		case STOP_GRADUATE:
			System.out.println(players.get(currPlayerIndex).getName() + ": Congratulations! You have graduated!");
			PlayerCareers playerCareer = new PlayerCareers();
			players.get(currPlayerIndex).getStatistics().educate();
			playerCareer.choosePlayerCareer(players.get(currPlayerIndex), gameCards.getCareerDeck(), gameCards.getCollegeCareerDeck());
			//executeStop(players, currPlayerIndex, gameCards, false, spinner, spaceList, gameBoard);
			break;
		case STOP_MARRIAGE:
			System.out.println(players.get(currPlayerIndex).getName() + ": Congratulations! You are married!");
			players.get(currPlayerIndex).getStatistics().getMarried();
			executeMarriageGift(players, currPlayerIndex, spinner);
			executeStop(players, currPlayerIndex, gameCards, false, spinner, spaceList, gameBoard);			
			break;
		case STOP_SCHOOL:
			System.out.println(players.get(currPlayerIndex).getName() + ": Would you like to go to night school?");
			System.out.println("You currently have " + players.get(currPlayerIndex).getBankAccount().printBalance() + ". College will cost you €100,000.");
			boolean school = choice.yesOrNo();
			if(school) {
				PlayerCareers playercareer = new PlayerCareers();
				players.get(currPlayerIndex).getBankAccount().decreaseBalance(100000);
				players.get(currPlayerIndex).getStatistics().educate();
				playercareer.choosePlayerCareer(players.get(currPlayerIndex), gameCards.getCareerDeck(), gameCards.getCollegeCareerDeck());
			}
			executeStop(players, currPlayerIndex, gameCards, school, spinner, spaceList, gameBoard);		
			break;
		case STOP_FAMILY:
			System.out.println(players.get(currPlayerIndex).getName() + ": Would you like to follow the family path?");
			boolean family = choice.yesOrNo();
			executeStop(players, currPlayerIndex, gameCards, family, spinner, spaceList, gameBoard);		
			break;
		case STOP_BABY:
			System.out.println(players.get(currPlayerIndex).getName() + ": Congratulations! You are having children!");
			System.out.println(players.get(currPlayerIndex).getName() + ": Press ENTER to Spin for children:");
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
			break;
		case STOP_HOLIDAY:
			System.out.println(players.get(currPlayerIndex).getName() + ": You are on Holiday!");
			break;
		case RETIRE:
			System.out.println(players.get(currPlayerIndex).getName() + ": Congratulations! You have reached retirement!");
			players.get(currPlayerIndex).getStatistics().Retire();
			setRetirementPos(players, currPlayerIndex);
			break;
		default:
			break;	
		}
	}
	
	/**
	 * setRetirementPos() is a method that sets the Retirement position that a player comes in when they retire. Eg, 1st player to finish gets retirement position 1.
	 * @param players List of Player object playing the game
	 * @param currPlayerIndex Index of the current player in players list
	 */
	private void setRetirementPos(ArrayList<Player> players, int currPlayerIndex) {
		int maxPos = 0;
		int pos;
		for(int i = 0; i<players.size(); i++) {
			pos = players.get(i).getStatistics().getRetirementPos();
			if(pos>maxPos) maxPos = pos;
		}
		players.get(currPlayerIndex).getStatistics().setRetirementPos(maxPos+1);
	}

	/**
	 * executeSpinToWin() method determines game logic for Spin2Win spaces.
	 * 
	 * Current player chooses 2 unique numbers, then every other player picks 1 unique number each, then current player spins the spinner until one of the chosen numbers appear.
	 * The player that guessed the correct number then gets awarded a bonus
	 * @param players List of Player objects playing the game
	 * @param currPlayerIndex Index of the current player in players, whose turn it is
	 * @param spinner Spinner
	 */
	private void executeSpinToWin(ArrayList<Player> players, int currPlayerIndex, Spinner spinner) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		ArrayList<Player> playersSpinToWin = new ArrayList<Player>();
		
		System.out.println(players.get(currPlayerIndex).getName() + ": Choose a number from 1 to 10: ");
		nums.add(getValue(nums));
		playersSpinToWin.add(players.get(currPlayerIndex));
		System.out.println(players.get(currPlayerIndex).getName() + ": Choose another number from 1 to 10: ");
		nums.add(getValue(nums));
		playersSpinToWin.add(players.get(currPlayerIndex));
		
		for(int i = currPlayerIndex+1; i < players.size(); i++) {
			System.out.println(players.get(i).getName() + ": Choose a number from 1 to 10: ");
			nums.add(getValue(nums));
			playersSpinToWin.add(players.get(i));
		}
		for(int i = 0; i < currPlayerIndex; i++) {
			System.out.println(players.get(i).getName() + ": Choose a number from 1 to 10: ");
			nums.add(getValue(nums));
			playersSpinToWin.add(players.get(i));
		}
		
		int value;
		
		while(true) {
			System.out.println(players.get(currPlayerIndex).getName() + ": Press ENTER to Spin:");
			EnterDetect enterDetect = new EnterDetect();
			enterDetect.detectEnter();
			
			value = spinner.spin();
			System.out.println("Spin Value: " + value);
			
			if(nums.contains(value)) {
				break;
			} else {
				System.out.println("No winner!");
			}
		}
		
		System.out.println("Congratulations " + playersSpinToWin.get(nums.indexOf(value)).getName() + ", you win €200,000!");
		playersSpinToWin.get(nums.indexOf(value)).getBankAccount().increaseBalance(200000);
		
	}

	/**
	 * getValue() is a method used by the executeSpinToWin() method to select a number and determine whether number selected has already been selected
	 * @param nums List of numbers already chosen
	 * @return Returns the number chosen by the player
	 */
	private Integer getValue(ArrayList<Integer> nums) {
		int num;
		OfferChoice choice = new OfferChoice();
		while(true) {
			num = choice.getNumInput();
			if((num < 1) || (num > 10)) {
				System.out.println("Invalid number! Choose a number from 1 to 10: ");
			} else if(nums.contains(num)) {
				System.out.println("Number already chosen! Choose again: ");
			} else {
				return num;
			}
		}
	}

	/**
	 * executeStop() is a method that allows the player to respin have another turn if they land on certain stop spaces. Respins, regenerates gameBoard and executes current space
	 * @param players List of Player objects playing the game
	 * @param currPlayerIndex Index of current Player in players, whose turn it is
	 * @param gameCards Contains all Cards/Decks needed in game
	 * @param branch True if the player is branching
	 * @param spinner Spinner
	 * @param spaceList List of Spaces
	 * @param gameBoard Board Game Visualisation
	 */
	private void executeStop(ArrayList<Player> players, int currPlayerIndex, CardInit gameCards, boolean branch, Spinner spinner,  ArrayList<Space> spaceList, BoardInit gameBoard) {
		PlayerMove move = new PlayerMove();
		move.spinMove(players, currPlayerIndex, spinner, spaceList, branch);
		
		gameBoard.getBoardGen().redrawBoard(gameBoard.getBoardData(), players, spaceList); //Redraw the board after moving
		
		executeCurrentSpace(players, currPlayerIndex, gameCards, spinner, spaceList, gameBoard);
	}
	
	/**
	 * executeMarriageGift() controls what happens when a player gets married.
	 * 
	 * Other players must spin to determine how much money they will give to the married player as their marriage gift.
	 * @param players List of Player object playing the game
	 * @param currPlayerIndex Index of the current Player in players
	 * @param spinner Spinner
	 */
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
				System.out.println();
				System.out.println(players.get(i).getName() + ":");
				players.get(i).getBankAccount().decreaseBalance(value);
				System.out.println(players.get(currPlayerIndex).getName() + ":");
				players.get(currPlayerIndex).getBankAccount().increaseBalance(value);
			}
		}
	}
}
