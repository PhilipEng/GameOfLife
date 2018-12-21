package gameoflife.player;

import java.util.ArrayList;
import java.util.List;

import gameoflife.cards.CareerCard;
import gameoflife.cards.HouseCard;

public class Inventory {
	
	private CareerCard career;
	private List<HouseCard> houses;
	private int numActionCards;
	
	/**
	 * Inventory Constructor
	 */
	public Inventory() {
		this.numActionCards = 0;
		this.houses = new ArrayList<HouseCard>();
	}
	
	/**
	 * setCareer() sets the players career to the Career choseCareer
	 * @param chosenCareer Career the player has chosen
	 */
	public void setCareer(CareerCard chosenCareer) {
		this.career = chosenCareer;
	}
	
	/**
	 * newHouse() adds a new House to the players List of Houses
	 * @param newHouse House to be added to List of Houses
	 */
	public void addHouse(HouseCard newHouse) {
		this.houses.add(newHouse);
	}
	
	/**
	 * removeHouse() removes a house from the players List of houses
	 * @param index Index to the house the player is removing
	 * @return Returns the House Card so it can be added back to the deck
	 */
	public HouseCard removeHouse(int index) {
		return this.houses.remove(index);
	}
	
	/**
	 * Iterates number of Action Cards possessed by Player
	 */
	public void increaseActionCards() {
		this.numActionCards++;
	}
	
	
	/**
	 * Career getter
	 * @return Returns Career Card
	 */
	public CareerCard getCareer() {
		return this.career;
	}
	
	/** 
	 * House Card getter. Gets a house from house list
	 * @param index Index of the House in House List to retrieve
	 * @return Returns the HouseCard
	 */
	public HouseCard getHouse(int index) {
		return this.houses.get(index);
	}
	
	/**
	 * Getter for number of houses possessed  by Player
	 * @return Returns number of houses the PLayer owns
	 */
	public int getNumHouses() {
		return this.houses.size();
	}
	
	/**
	 * Returns number of Action Cards held by the Player
	 * @return Returns number of Action Cards held by the Player
	 */
	public int getNumberActionCards() {
		return this.numActionCards;
	}

	
}
