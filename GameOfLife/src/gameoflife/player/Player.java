package gameoflife.player;
import gameoflife.cards.*;
import gameoflife.board.*;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	
	public String name;
	
	public Pawn pawn;
	
	private int balance;
	
	private boolean education;
	
	private boolean isMarried;
	
	private Children children;
	
	private CareerCard career;
	
	private List<HouseCard> houses;
	
	private int numberActionCards;
	
	private boolean isRetired;
	
	private int numberLoans;
	
	
	//Constructor
	public Player(String name, int balance, Pawn pawn) {
		this.name = name;
		this.balance = balance;
		this.education = false;
		this.isMarried = false;
		this.children = Children.NONE;
		this.pawn = pawn;
		this.isRetired = false;
		this.numberActionCards = 0;
		this.houses = new ArrayList<HouseCard>();
		//TODO: When assigning pawn, create pawn then pass it as argument to player constructor
		this.pawn = pawn;
	}
	
	
	//Methods
	public String getName(){
		return name;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void increaseBalanceBy(int increment) {
		this.balance += increment;
	}
	
	public void decreaseBalanceBy(int decrement) {
		if(this.balance - decrement >= 0) this.balance -= decrement;
		
		else if (this.balance - decrement < 0) {
			this.balance -= decrement;
			while(this.balance < 0) {
				this.balance += 50000;
				this.numberLoans += 1;
			}
		}
	}
	
	public boolean checkEducation() {
		return this.education;
	}
	
	public void giveEducation() {
		this.education = true;
	}
	
	public boolean checkMarriage() {
		return this.isMarried;
	}
	
	public void getMarried() {
		this.isMarried = true;
	}
	
	
	public void paydayPassed() {
		this.increaseBalanceBy(this.career.getSalary());
	}
	
	public void paydayLanded() {
		this.increaseBalanceBy(this.career.getSalary() + 100000);
	}
	
	public void increaseActionCards(int increment) {
		this.numberActionCards += increment;
	}
	
	public int getNumberActionCards() {
		return numberActionCards;
	}
	
	public void addHouse(HouseCard newHouse) {
		this.houses.add(newHouse);
	}
	
	public HouseCard sellHouse(int index, int spinnerVal) {
		this.increaseBalanceBy(houses.get(index).getSale_price(spinnerVal));
		HouseCard removedHouseCard = houses.get(index);
		houses.remove(index);
		return removedHouseCard;
	}
	
	//This method will only be for Non-College Careers
	//TODO: Create new method for College Careers
	//Because I cannot access the object CareerCardDeck 
	
	public void setCareer(CareerCard chosenCareer) {
		this.career = chosenCareer;
	}
	
}


