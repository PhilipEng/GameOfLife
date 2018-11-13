package gameoflife.bank;

import gameoflife.cards.HouseCard;

public class BankAccount {
	private int balance;
	private int numberLoans;
	private int salary;
	
	public BankAccount() {
		numberLoans = 0;
		balance = Balance.INITIALBALANCE;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public void increaseBalance(int amount) {
		this.balance += amount;
		System.out.println("€" +amount+ " lodged in bank account");
	}
	
	public boolean decreaseBalance(int amount) {
		if(this.balance >= amount) {
			this.balance -= amount;
			System.out.println("€" +amount+ " withdrawn from bank account");
			return true;
		} else {
			System.out.println("***INSUFFICIENT FUNDS***");
			System.out.println("Balance: €" +this.balance);
			return false;
		}
			/*if (this.balance - decrement < 0) {
			this.balance -= decrement;
			while(this.balance < 0) {
				this.balance += Loan.LOANAMOUNT;
				this.numberLoans += 1;
			}
		}*/
	}
	
	public void payday() {
		System.out.println("PAYDAY:");
		increaseBalance(this.salary);
	}
	
	public void takeOutLoan() {
		this.numberLoans++;
		System.out.println("Taking out a loan from the bank:");
		increaseBalance(Loan.LOANAMOUNT);
	}
	
	public boolean repayLoan() {
		if(this.numberLoans == 0) {
			System.out.println("***No loans to repay***");
			return false;
		}
		else if(decreaseBalance(Loan.LOANREPAYAMOUNT)) {
			this.numberLoans--;
			System.out.println("Loan repaid");
			return true;
		} else {
			System.out.println("***INSUFFICIENT FUNDS***");
			System.out.println("Balance: €" +this.balance);
			return false;
		}
	}
	
	public int sellHouse(HouseCard house, int spinnerVal) {
		this.increaseBalance(house.getSalePrice(spinnerVal));
		return house.getSalePrice(spinnerVal);
	}
	
	
	public int getBalance() {
		return balance;
	}
	
	public int getSalary() {
		return this.salary;
	}
	
	public int getNumLoans() {
		return this.numberLoans;
	}
	

	/*public void paydayPassed() {
		this.increaseBalanceBy(this.career.getSalary());
	}
	
	public void paydayLanded() {
		this.increaseBalanceBy(this.career.getSalary() + 100000);
	}*/

}
