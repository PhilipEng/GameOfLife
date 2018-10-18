package gameoflife.player;
import gameoflife.cards.*;
import gameoflife.finance.Loan;
import gameoflife.board.*;


import java.util.ArrayList;
import java.util.List;

public class Player {
	
	
	public String name;
	
	public Pawn pawn;
	
	private int balance;
	
	private boolean education;
	
	private boolean isMarried;
	
	private int children;
	
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
		this.children = 0;
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
				this.balance += Loan.LOANAMOUNT;
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
	
	public void addChildren(int numberBabies) {
		if(this.checkMarriage()) {
			this.children += numberBabies;
			if( this.children > 4) this.children = 4;
		}
	}
	
	public int getNumberChildren() {
		return this.children;
	}
	
	public void updatePawn() {
		this.pawn.updatePawn(this.checkMarriage(), this.getNumberChildren());
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
	
	public boolean checkRetirementStatus() {
		return this.isRetired;
	}
	
	public void getRetired() {
		this.isRetired = true;
	}
	
	public CareerCard getCareer() {
		return this.career;
	}
	
	public void payOffLoans(int loansToPay) {
		if(loansToPay > this.numberLoans) loansToPay = this.numberLoans;
		
		int totalRepayment = loansToPay*Loan.LOANREPAYAMOUNT;
		
		if(totalRepayment < getBalance()) {
			System.out.println("ERROR: Cannot repay loans without sufficient balance.");
		}
		else {
			this.numberLoans -= loansToPay;
			decreaseBalanceBy(totalRepayment);
		}
	}
	
	public void printDetails() {
		System.out.println("---------------------------------------------");
		System.out.println("Printing information for " +this.name);
		System.out.println("---------------------------------------------");

		System.out.println("\nFinances:");
		System.out.println("Balance = " +this.getBalance());
		System.out.println("Loans   = " +this.numberLoans);
		
		System.out.println("\nFamily:");
		if(!this.isMarried) System.out.println(this.name +" is not Married.");
		else System.out.println(this.name +" is Married with " +this.getNumberChildren() + " children.");
		
		System.out.println(this.name +"'s pawn is " +this.pawn.colour.toString());
		
		System.out.println("\nHouses: ");
		System.out.println(this.name +" has " + this.houses.size() +" houses.");
		if(this.houses.size() > 0) {
			for(int house = 0; house<=this.houses.size(); house++) {
				this.houses.get(house).printDetails();
			}
		}

		
		System.out.println("\nCareer & Education:");
		if(this.checkEducation()) System.out.println(this.name +" has a college education.");
		else System.out.println(this.name +" does not have a college education.");
		
		this.career.printDetails();
		System.out.println("---------------------------------------------");

	}
	
}


