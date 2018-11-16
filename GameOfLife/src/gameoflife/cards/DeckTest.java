package gameoflife.cards;

public class DeckTest {

	public static void main(String[] args) {
		
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
		Deck careerDeck = new Deck();
		careerDeck.addToDeck(actor);
		careerDeck.addToDeck(inventor);
		careerDeck.addToDeck(singer);
		careerDeck.addToDeck(raceCarDriver);
		careerDeck.addToDeck(athlete);
		careerDeck.addToDeck(policeOfficer);
		careerDeck.addToDeck(chef);
		careerDeck.addToDeck(dancer);
		
		System.out.println("Total cards in career deck: " + careerDeck.getTotalCards());
		careerDeck.shuffle();
		
		// Test
		CareerCard test1 = (CareerCard)careerDeck.drawFromDeck();
		test1.printDetails();
		System.out.println("Total cards in career deck: " + careerDeck.getTotalCards());
		test1 = (CareerCard)careerDeck.drawFromDeck();
		test1.printDetails();
		
		
		// Initialize Action Cards
		HouseCard ranch = new HouseCard("Ranch", 600000, 600000, 750000);
		HouseCard cityPenthouse = new HouseCard("City Penthouse", 600000, 650000, 700000);
		HouseCard islandHolidayHome = new HouseCard("Island Holiday Home", 600000, 550000, 800000);
		HouseCard dreamVilla = new HouseCard("Dream Villa", 300000, 250000, 380000);
		HouseCard farmhouse = new HouseCard("Farmhouse", 300000, 250000, 380000);
		HouseCard windmill = new HouseCard("Windmill", 350000, 300000, 500000);
		HouseCard familyHouse = new HouseCard("Family House", 250000, 200000, 300000);
		HouseCard luxuryFlat = new HouseCard("Luxury Flate", 250000, 200000, 300000);
		HouseCard ecoHouse = new HouseCard("Eco House", 200000, 180000, 300000);
		HouseCard studioFlat = new HouseCard("Studio Flat", 100000, 80000, 150000);
		HouseCard houseboat = new HouseCard("Houseboat", 200000, 180000, 300000);
		HouseCard teepee = new HouseCard("Teepee", 100000, 80000, 150000);
		HouseCard cosyCottage = new HouseCard("Cosy Cottage", 150000, 120000, 200000);
		HouseCard beachHut = new HouseCard("Beach Hut", 100000, 80000, 150000);
		
		// Initialize Career Card Deck
		Deck houseDeck = new Deck();
		houseDeck.addToDeck(ranch);
		houseDeck.addToDeck(cityPenthouse);
		houseDeck.addToDeck(islandHolidayHome);
		houseDeck.addToDeck(dreamVilla);
		houseDeck.addToDeck(farmhouse);
		houseDeck.addToDeck(windmill);
		houseDeck.addToDeck(familyHouse);
		houseDeck.addToDeck(luxuryFlat);
		houseDeck.addToDeck(ecoHouse);
		houseDeck.addToDeck(studioFlat);
		houseDeck.addToDeck(houseboat);
		houseDeck.addToDeck(teepee);
		houseDeck.addToDeck(cosyCottage);
		houseDeck.addToDeck(beachHut);
		
		System.out.println("Total cards in house deck: " + houseDeck.getTotalCards());
		houseDeck.shuffle();
		
		// Test
		HouseCard test2 = (HouseCard)houseDeck.drawFromDeck();
		test2.printDetails();
		System.out.println("Total cards in house deck: " + houseDeck.getTotalCards());
		test2 = (HouseCard)houseDeck.drawFromDeck();
		test2.printDetails();		
		
		
		// Initialize Action Cards
		ActionCard card1 = new ActionCard(ActionType.CareerChange);
		ActionCard card2 = new ActionCard(ActionType.PlayersPay, 20000);
		ActionCard card3 = new ActionCard(ActionType.PayBank, 50000);
		ActionCard card4 = new ActionCard(ActionType.GetCash, 100000);
		
		Deck actionDeck = new Deck();
		actionDeck.addToDeck(card1);
		actionDeck.addToDeck(card2);
		actionDeck.addToDeck(card3);
		actionDeck.addToDeck(card4);
		
		System.out.println("Total cards in action deck: " + actionDeck.getTotalCards());
		actionDeck.shuffle();
		
		// Test
		ActionCard test3 = (ActionCard)actionDeck.drawFromDeck();
		test3.printDetails();
		System.out.println("Total cards in action deck: " + actionDeck.getTotalCards());
		test3 = (ActionCard)actionDeck.drawFromDeck();
		test3.printDetails();

	}

}
