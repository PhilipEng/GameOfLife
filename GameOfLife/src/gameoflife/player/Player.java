package gameoflife.player;

import gameoflife.bank.BankAccount;
import gameoflife.board.objects.Pawn;

public class Player {
	
	private String name;
	private Pawn pawn;
	
	private BankAccount bankAccount;
	private Inventory inventory;
	private Statistics statistics;
	
	//Constructor
	public Player(String name, Pawn pawn) {
		this.name = name;
		this.pawn = pawn;
		
		this.bankAccount = new BankAccount();
		this.inventory = new Inventory();
		this.statistics = new Statistics();
	}
	
	
	//Methods
	public String getName(){
		return this.name;
	}
	
	public Pawn getPawn() {
		return this.pawn;
	}
	
	public BankAccount getBankAccount(){
		return this.bankAccount;
	}
	
	public Inventory getInventory(){
		return this.inventory;
	}
	
	public Statistics getStatistics(){
		return this.statistics;
	}
	
	public void printDetails() {
		System.out.println("---------------------------------------------------------------");
		System.out.println("---    Player Information: " +this.name);
		System.out.println("---------------------------------------------------------------");

		System.out.println(this.name +"'s pawn is " + this.pawn.getColour().toString());
		
		System.out.println("\nFinances:");
		System.out.println("Bank Account Balance: " + this.bankAccount.printBalance());
		System.out.println("Number of Loans:      " + this.bankAccount.getNumLoans());
		
		System.out.println("\nFamily:");
		if(!this.statistics.isMarried()) System.out.println(this.name +" is not Married.");
		else System.out.println(this.name +" is Married with " + this.statistics.getNumChildren() + " children.");
		
		System.out.println("\nAction Cards:");
		System.out.println("Number of Action Cards Collected: " + this.inventory.getNumberActionCards());
		
		System.out.println("\nCareer & Education:");
		if(!this.statistics.isWorking()) {
			System.out.println(this.name +" does not have a job yet.");
		} else if(this.statistics.isEducated()) {
			System.out.println(this.name +" has a college education.");
			this.inventory.getCareer().printDetails();
		} else {
			System.out.println(this.name +" does not have a college education.");
			this.inventory.getCareer().printDetails();
		}
		
		System.out.println("\nHouses: ");
		System.out.println(this.name +" has " + this.inventory.getNumHouses() +" houses.");
		if(this.inventory.getNumHouses() > 0) {
			for(int house = 0; house < this.inventory.getNumHouses(); house++) {
				this.inventory.getHouse(house).printDetails();
			}
		}

		System.out.println("---------------------------------------------------------------");
		System.out.println();
	}
	
}


