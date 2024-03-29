package gameoflife.bank;

import java.text.DecimalFormat;

public class BankAccount {
	private int balance;		// Bank account current balance
	private int numberLoans;	// Number of loans taken out
	private int salary;			// Bank account owner's salary
	
	/**
	 * Initialise new bank account with 0 loans and an initial balance.
	 */
	public BankAccount() {		
		numberLoans = 0;
		balance = Balance.INITIALBALANCE;
	}
	
	/**
	 * Sets Salary of a Player's Bank Account
	 * @param salary Salary of Player
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	/**
	 * Increases the Balance of an account by "amount"
	 * @param amount Amount to increase Balance by
	 */
	public void increaseBalance(int amount) {	
		this.balance += amount;
		System.out.println("�" +amount+ " lodged in bank account");
		System.out.println("New Balance: " +this.printBalance());
		System.out.println(); 
	}

	/**
	 * Attempts to remove "amount" from the Balance of Bank Account
	 * 
	 * If the bank account has insufficient funds, a loan has to be taken out to complete the transaction
	 * @param amount Amount to decrease Balance by.
	 */
	public void decreaseBalance(int amount) {	
		if(this.balance < amount) {
			System.out.println("***INSUFFICIENT FUNDS***");
			System.out.println("Current Balance: " +this.printBalance());

			while(this.balance < amount) {
				takeOutLoan();
			}
		}
		this.balance -= amount;
		System.out.println("�" +amount+ " withdrawn from bank account");
		System.out.println("New Balance: " +this.printBalance());
		System.out.println();
	}
	
	/**
	 * Increases the Bank Account Balance by the salary.
	 */
	public void payday() {
		increaseBalance(this.salary);
	}
	
	/**
	 * Takes out a loan from the bank worth LOAN_AMOUNT
	 */
	public void takeOutLoan() {
		this.numberLoans++;
		System.out.println("***You are taking out a loan from the bank***");
		increaseBalance(Loan.LOAN_AMOUNT);
	}
	
	/**
	 *Repays all loans for the bank account. The user can go into negative balance
	 */
	public void repayLoans() {		
		while(this.numberLoans != 0) {
			System.out.println("***Repaying Bank Loan***");
			this.balance -= Loan.LOAN_REPAY_AMOUNT;
			this.numberLoans --;
		}
	}
	
	/**
	 * Returns Bank Account Balance
	 * @return Balance returned
	 */
	public int getBalance() {
		return balance;
	}
	
	/**
	 * Return bank account balance in Integer form
	 * @return Integer Balance returned
	 */
	public Integer getIntegerBalance() {	
		return new Integer(balance);
	}
	
	/**
	 * Returns salary associated with this Bank Account
	 * @return Salary returned
	 */
	public int getSalary() {
		return this.salary;
	}
	
	/**
	 * Returns the number of Loans on this Bank Account
	 * @return Number of Loans returned
	 */
	public int getNumLoans() {
		return this.numberLoans;
	}
	
	/**
	 * Print the balance in string format with � sign and comma separators
	 * @return Return Bank Balance in string format
	 */
	public String printBalance() {
		DecimalFormat decimalFormat = new DecimalFormat("###,###,##0");
		String stringBalance = "�" + decimalFormat.format(this.balance);
		return stringBalance;
	}
}
