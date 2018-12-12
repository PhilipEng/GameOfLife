package gameoflife.bank;

import java.text.DecimalFormat;

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
		System.out.println("New Balance: " +this.printBalance());
		System.out.println(); //Skip Line
	}
	
	public void decreaseBalance(int amount) {
		if(this.balance < amount) {
			System.out.println("***INSUFFICIENT FUNDS***");
			System.out.println("Current Balance: " +this.printBalance());

			while(this.balance < amount) {
				takeOutLoan();
			}
		}
		this.balance -= amount;
		System.out.println("€" +amount+ " withdrawn from bank account");
		System.out.println("New Balance: " +this.printBalance());
		System.out.println(); //Skip Line

	}
	
	public void payday() {
		increaseBalance(this.salary);
	}
	
	public void takeOutLoan() {
		this.numberLoans++;
		System.out.println("***You are taking out a loan from the bank***");
		increaseBalance(Loan.LOANAMOUNT);
	}
	
	public void repayLoans() {
		while(this.numberLoans != 0) {
			System.out.println("***Repaying Bank Loan***");
			this.balance -= Loan.LOANREPAYAMOUNT;
		}
	}
	
	public int getBalance() {
		return balance;
	}
	
	public Integer getIntegerBalance() {
		return new Integer(balance);
	}
	
	public int getSalary() {
		return this.salary;
	}
	
	public int getNumLoans() {
		return this.numberLoans;
	}
	
	// Print the balance in string format with € sign and comma separators
	public String printBalance() {
		DecimalFormat decimalFormat = new DecimalFormat("###,###,##0");
		String stringBalance = "€" + decimalFormat.format(this.balance);
		
		return stringBalance;
	}
}
