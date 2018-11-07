package gameoflife.game;

import gameoflife.cards.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GameInit {

	public GameInit() {

	}

	public CareerCardDeck buildCareerDeck(String filePath) {
		CareerCardDeck careerDeck = new CareerCardDeck();
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

		System.out.println("GameInit: Total cards in career deck: " + careerDeck.getTotalCards());
		careerDeck.shuffle();

		return careerDeck;
	}

	private static CareerCard createCareerCard(String[] data) {
		String career = data[0];
		int salary = Integer.parseInt(data[1]);
		int bonusNumber = Integer.parseInt(data[2]); 
		// Create and return new career card
		return new CareerCard(career, salary, bonusNumber);									
	}
	
	public HouseCardDeck buildHouseDeck(String filePath) {
		HouseCardDeck houseDeck = new HouseCardDeck();
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

		System.out.println("GameInit: Total cards in house deck: " + houseDeck.getTotalCards());
		houseDeck.shuffle();

		return houseDeck;
	}
	
	private static HouseCard createHouseCard(String[] data) {
		String type = data[0];
		int price = Integer.parseInt(data[1]);
		int saleRed = Integer.parseInt(data[2]); 
		int saleBlack = Integer.parseInt(data[3]);
		// Create and return new career card
		return new HouseCard(type, price, saleRed, saleBlack);									
	}
	
	public ActionCardDeck buildActionDeck(String filePath) {
		ActionCardDeck actionDeck = new ActionCardDeck();
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

		System.out.println("GameInit: Total cards in action deck: " + actionDeck.getTotalCards());
		actionDeck.shuffle();

		return actionDeck;
	}
	
	private static ActionCard createActionCard(String[] data) {
		
		ActionType type = ActionType.whichAction(data[1]);
		
		if(type != ActionType.CareerChange) {
			int value = Integer.parseInt(data[2]); 
			return new ActionCard(type, value);	
		} else {
			return new ActionCard(type);	
		}								
	}

}
