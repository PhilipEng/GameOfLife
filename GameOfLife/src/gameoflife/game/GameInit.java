package gameoflife.game;

import gameoflife.cards.*;

public class GameInit {
	
	public GameInit() {
		
	}
	
	public CareerCardDeck buildCareerDeck() {
		// Initialize Career Cards
		CareerCard actor = new CareerCard("Actor", 100000, 5);
		CareerCard inventor = new CareerCard("Inventor", 80000, 4);
		CareerCard singer = new CareerCard("Singer", 70000, 3);
		CareerCard raceCarDriver = new CareerCard("Race Car Driver", 60000, 2);
		CareerCard athlete = new CareerCard("Athlete", 50000, 1);
		CareerCard policeOfficer = new CareerCard("Police Officer", 50000, 4);
		CareerCard chef = new CareerCard("Chef", 50000, 3);
		CareerCard dancer = new CareerCard("Dancer", 50000, 2);
		
		// Initialize Career Card Deck
		CareerCardDeck careerDeck = new CareerCardDeck();
		careerDeck.addToDeck(actor);
		careerDeck.addToDeck(inventor);
		careerDeck.addToDeck(singer);
		careerDeck.addToDeck(raceCarDriver);
		careerDeck.addToDeck(athlete);
		careerDeck.addToDeck(policeOfficer);
		careerDeck.addToDeck(chef);
		careerDeck.addToDeck(dancer);
		
		System.out.println("GameInit: Total cards in career deck: " + careerDeck.getTotalCards());
		careerDeck.shuffle();
		
		return careerDeck;
	}
	
	public CareerCardDeck buildCollegeCareerDeck() { //This can be removed if we use a file to read in card data > public CareerCardDeck buildCareerDeck(dataFile)
		// Initialize College Career Cards
		CareerCard doctor = new CareerCard("Doctor", 130000, 10);
		CareerCard lawyer = new CareerCard("Lawyer", 120000, 9);
		CareerCard videoGameDesigner = new CareerCard("Video Game Designer", 110000, 8);
		CareerCard vet = new CareerCard("Vet", 100000, 7);
		CareerCard teacher = new CareerCard("Teacher", 100000, 6);
		CareerCard scientist = new CareerCard("Scientist", 100000, 9);
		CareerCard secretAgent = new CareerCard("Secret Agent", 100000, 8);
		CareerCard fashionDesigner = new CareerCard("Fashion Designer", 80000, 7);
		
		// Initialize College Career Card Deck
		CareerCardDeck collegeCareerDeck = new CareerCardDeck();
		collegeCareerDeck.addToDeck(doctor);
		collegeCareerDeck.addToDeck(lawyer);
		collegeCareerDeck.addToDeck(videoGameDesigner);
		collegeCareerDeck.addToDeck(vet);
		collegeCareerDeck.addToDeck(teacher);
		collegeCareerDeck.addToDeck(scientist);
		collegeCareerDeck.addToDeck(secretAgent);
		collegeCareerDeck.addToDeck(fashionDesigner);

		System.out.println("GameInit: Total cards in college career deck: " + collegeCareerDeck.getTotalCards());
		collegeCareerDeck.shuffle();
		
		return collegeCareerDeck;
	}
	
	
}
