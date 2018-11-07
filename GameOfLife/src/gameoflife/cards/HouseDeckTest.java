package gameoflife.cards;

public class HouseDeckTest {

	public static void main(String[] args) {
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
		HouseCardDeck houseDeck = new HouseCardDeck();
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
		HouseCard test = houseDeck.drawFromDeck();
		test.printDetails();
		System.out.println("Total cards in house deck: " + houseDeck.getTotalCards());
		test = houseDeck.drawFromDeck();
		test.printDetails();
		
		test = houseDeck.chooseHouse();
		test.printDetails();



	}

}
