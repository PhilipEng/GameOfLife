package gameoflife.bank;

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
	//TODO:bank methods, decreaseby, increaseby, paydaypassed, paydaylanded, takeoutloan, repayloan, gets
}
