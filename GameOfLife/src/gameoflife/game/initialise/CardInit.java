package gameoflife.game.initialise;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import gameoflife.cards.*;

public class CardInit {
	
	private Deck careerDeck;
	private Deck collegeCareerDeck;
	private Deck houseDeck;
	private Deck actionDeck;
	
	/**
	 * CardInit constructor, constructs all of the game decks used in the game
	 * @param pathToCareerCards Path to the CareerCards CSV file
	 * @param pathToCollegeCareerCards Path to the CollegeCareerCards CSV file
	 * @param pathToHouseCards Path to the HouseCards CSV file
	 * @param pathToActionCards Path to the ActionCards CSV file
	 */
	public CardInit(String pathToCareerCards, String pathToCollegeCareerCards, String pathToHouseCards, String pathToActionCards) {
		// Create Career card decks
		careerDeck = buildCareerDeck(pathToCareerCards);
		collegeCareerDeck = buildCareerDeck(pathToCollegeCareerCards);
		
		// Create House card deck
		houseDeck = buildHouseDeck(pathToHouseCards);
		
		// Create Action card deck
		actionDeck = buildActionDeck(pathToActionCards);
	}
	
	
	/**
	 * Gets Career Card Deck
	 * @return Returns Career Card Deck
	 */
	public Deck getCareerDeck() {
		return careerDeck;
	}

	/**
	 * Gets College Career Card Deck
	 * @return Returns CollegeCareerCardDeck
	 */
	public Deck getCollegeCareerDeck() {
		return collegeCareerDeck;
	}

	/**
	 * Gets HouseCardDeck
	 * @return Returns HouseDeck
	 */
	public Deck getHouseDeck() {
		return houseDeck;
	}

	/**
	 * Gets ActionCardDeck
	 * @return Returns ActionDeck
	 */
	public Deck getActionDeck() {
		return actionDeck;
	}


	/**
	 * Builds Career Card Deck given filepath.
	 * 
	 * Parses the CSV file and constructs Career Cards from the CSV file information.
	 * Shuffles Deck after deck is created
	 * @param filePath path to Career Card CSV file
	 * @return Returns Career Card Deck
	 */
	public Deck buildCareerDeck(String filePath) {
		Deck careerDeck = new Deck();
		Path pathToCSV = Paths.get(filePath);

		// Open file using BufferedReader
		try (BufferedReader br = Files.newBufferedReader(pathToCSV)) {
			// Read and ignore the 1st 2 lines of the text file
			String line = br.readLine();
			line = br.readLine();
			line = br.readLine();
			// loop until all lines are read
			while (line != null) {
				String[] data = line.split(","); //Split the line into card data 
				CareerCard careerCard = createCareerCard(data); //Create a career card
				careerDeck.addToDeck(careerCard); //Add card to the deck
				line = br.readLine();	//If null, loop is exited
			}
		} catch (IOException ioe) {	//Catch exception 
			ioe.printStackTrace();
		}

		careerDeck.shuffle();

		return careerDeck;
	}

	/**
	 * Generates a new Career Card based on the String[] data which is provided by the CSV file
	 * @param data Data for the Career Card to be generated, from CSV file
	 * @return Returns the newly generated Career Card
	 */
	private static CareerCard createCareerCard(String[] data) {
		String career = data[0];
		int salary = Integer.parseInt(data[1]);
		int bonusNumber = Integer.parseInt(data[2]); 
		// Create and return new career card
		return new CareerCard(career, salary, bonusNumber);									
	}
	
	/**
	 * Builds House Deck given filepath
	 * 
	 * House Deck is generated given the CSV file specified in the filepath.
	 * Deck is shuffled after generation
	 * @param filePath Path to HouseCard CSV file
	 * @return returns Deck of HouseCards
	 */
	public Deck buildHouseDeck(String filePath) {
		Deck houseDeck = new Deck();
		Path pathToCSV = Paths.get(filePath);

		// Open file using BufferedReader
		try (BufferedReader br = Files.newBufferedReader(pathToCSV)) {
			// Read and ignore the 1st 2 lines of the text file
			String line = br.readLine();
			line = br.readLine();
			line = br.readLine();
			// loop until all lines are read
			while (line != null) {
				String[] data = line.split(","); //Split the line into card data 
				HouseCard houseCard = createHouseCard(data); //Create a career card
				houseDeck.addToDeck(houseCard); //Add card to the deck
				line = br.readLine();	//If null, loop is exited
			}
		} catch (IOException ioe) {	//Catch exception 
			ioe.printStackTrace();
		}

		//System.out.println("CardInit: Total cards in house deck: " + houseDeck.getTotalCards());
		houseDeck.shuffle();

		return houseDeck;
	}
	
	/**
	 * Generates a new HouseCard based on the String[] data which is provided by the CSV file
	 * @param data Data for the HouseCard to be generated, from CSV file
	 * @return Returns the newly generated HouseCard
	 */
	private static HouseCard createHouseCard(String[] data) {
		String type = data[0];
		int price = Integer.parseInt(data[1]);
		int saleRed = Integer.parseInt(data[2]); 
		int saleBlack = Integer.parseInt(data[3]);
		// Create and return new career card
		return new HouseCard(type, price, saleRed, saleBlack);									
	}
	
	/**
	 * Builds ActionCard Deck given filepath
	 * 
	 * Action Card Deck is generated given the CSV file specified in the filepath.
	 * Deck is shuffled after generation
	 * @param filePath Path to ActionCard CSV file
	 * @return returns Deck of ActionCards
	 */
	public Deck buildActionDeck(String filePath) {
		Deck actionDeck = new Deck();
		Path pathToCSV = Paths.get(filePath);
		int i;

		// Open file using BufferedReader
		try (BufferedReader br = Files.newBufferedReader(pathToCSV)) {
			// Read and ignore the 1st 2 lines of the text file
			String line = br.readLine();
			line = br.readLine();
			line = br.readLine();
			// loop until all lines are read
			while (line != null) {
				
				String[] data = line.split(","); //Split the line into card data 
				
				int numCards = Integer.parseInt(data[0]);
				
				for(i = 0; i < numCards; i++) {
					ActionCard actionCard = createActionCard(data); //Create an Action card
					actionDeck.addToDeck(actionCard); //Add card to the deck
				}

				line = br.readLine();	//If null, loop is exited
			}
		} catch (IOException ioe) {	//Catch exception 
			ioe.printStackTrace();
		}

		actionDeck.shuffle();

		return actionDeck;
	}
	
	/**
	 * Generates a new Action based on the String[] data which is provided by the CSV file
	 * @param data Data for the Action Card to be generated, from CSV file
	 * @return Returns the newly generated Action Card
	 */
	private static ActionCard createActionCard(String[] data) {
		
		ActionType type = ActionType.whichAction(data[1]);
		
		if(type != ActionType.CAREER_CHANGE) {
			int value = Integer.parseInt(data[2]); 
			return new ActionCard(type, value);	
		} else {
			return new ActionCard(type);	
		}								
	}
}
