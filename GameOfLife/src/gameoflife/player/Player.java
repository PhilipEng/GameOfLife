package gameoflife.player;
import gameoflife.cards.*;
import gameoflife.board.*;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	
	public String name;
	
	//TODO: Create Pawn class
	public Pawn pawn;
	
	private int balance;
	
	private boolean education;
	
	private boolean isMarried;
	
	//TODO: children shouldn't be an int, probably an enum
	private int children;
	
	//TODO: Create Career class
	private CareerCard career;
	
	//TODO: Cards should probably becomes its own class HouseCards
	private List<HousesCards[]> houses;
	
	//TODO: Similarly maybe Cards should be ActionCards
	private List<ActionCards[]> actionCards;
	
	private boolean isRetired;
	
	//Constructor
	public Player(String name, int balance, Pawn pawn) {
		this.name = name;
		this.balance = balance;
		
		this.education = false;
		this.isMarried = false;
		this.children = 0;
		this.pawn = pawn;
		this.isRetired = false;
		//TODO: change theses to <ActionCards> and <HouseCards> 
		this.actionCards = new ArrayList<ActionCards[]>();
		this.houses = new ArrayList<HousesCards[]>();
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
	
	public void increaseBalance(int increment) {
		this.balance += increment;
	}
	
	public void decreaseBalance(int decrement) {
		if(this.balance - decrement < 0) this.balance -= decrement;
		//TODO: Revise what happens if money goes below zero, might need to 
		else this.balance = 0;
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
	
	
	//TODO: create payday method, increment balance by salary
	public void paydayPassed() {
		this.balance += this.career.salary;
	}
	
	public void paydayLanded() {
		this.balance += this.career.salary + 100000;
	}
	
	//TODO: Choose Career method
	//
}

