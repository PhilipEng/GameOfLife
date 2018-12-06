package gameoflife.player;

import java.util.ArrayList;
import java.util.List;

import gameoflife.board.objects.Spinner;
import gameoflife.cards.CareerCard;
import gameoflife.cards.HouseCard;

public class Inventory {
	
	private CareerCard career;
	private List<HouseCard> houses;
	private int numActionCards;
	
	public Inventory() {
		this.numActionCards = 0;
		this.houses = new ArrayList<HouseCard>();
	}
	
	public void setCareer(CareerCard chosenCareer) {
		this.career = chosenCareer;
	}
	
	public void addHouse(HouseCard newHouse) {
		this.houses.add(newHouse);
	}
	
	public HouseCard removeHouse(int index) {
		return this.houses.remove(index);
	}
	
	public void increaseActionCards() {
		this.numActionCards++;
	}
	
	
	public CareerCard getCareer() {
		return this.career;
	}
	
	public HouseCard getHouse(int index) {
		return this.houses.get(index);
	}
	
	public int getNumHouses() {
		return this.houses.size();
	}
	
	public int getNumberActionCards() {
		return this.numActionCards;
	}
	
	public int sellAllHouses(Spinner spinner) {
		int totalSaleAmount = 0;
		int salePrice;
		
		for(int house = 0; house < houses.size(); house++) {
			salePrice = houses.get(house).getSalePrice(spinner.spin());
			totalSaleAmount += salePrice;
			System.out.println("The " +houses.get(house).getHouseType() +" was sold for €" +salePrice);
			houses.remove(house);
		}
		return totalSaleAmount;
	}
	
}
