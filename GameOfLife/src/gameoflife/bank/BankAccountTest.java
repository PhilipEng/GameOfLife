package gameoflife.bank;

import static org.junit.Assert.*;

import org.junit.Test;

public class BankAccountTest {

	@Test	// Ensure money can be lodged in the account
	public void test_Balance_Increase() {
		BankAccount bankAccount = new BankAccount();
		bankAccount.increaseBalance(50000);
		
		int expected = Balance.INITIALBALANCE + 50000;
		
		assertEquals("Balance gets successfully increased", bankAccount.getBalance(), expected);
	}
	
	@Test	// Ensure money can be withdrawn from the account
	public void test_Balance_Decrease_with_Sufficient_Funds() {
		BankAccount bankAccount = new BankAccount();
		bankAccount.decreaseBalance(50000);
		
		int expected = Balance.INITIALBALANCE - 50000;
		
		assertEquals("Balance gets successfully decreased", bankAccount.getBalance(), expected);
	}
	
	@Test 	// Ensure loans are added to balance if insufficient funds
	public void test_Balance_Decrease_without_Sufficient_Funds_Balance_Check() {
		BankAccount bankAccount = new BankAccount();
		bankAccount.decreaseBalance(260000);
		
		int expected = Balance.INITIALBALANCE - 260000 + 2*Loan.LOAN_AMOUNT;
		
		assertEquals("Insufficient funds in account so loans will be taken out so the balance can be decreased", bankAccount.getBalance(), expected);
	}
	
	@Test	// Ensure number of loans taken out is tracked when insufficient funds
	public void test_Balance_Decrease_without_Sufficient_Funds_Loan_Check() {
		BankAccount bankAccount = new BankAccount();
		bankAccount.decreaseBalance(260000);
		
		assertEquals("Insufficient funds in account so 2 loans will be taken out", bankAccount.getNumLoans(), 2);
	}
	
	@Test	// Ensure loan increases by correct amount
	public void test_Take_out_loan_Balance_Check() {
		BankAccount bankAccount = new BankAccount();
		bankAccount.takeOutLoan();
		
		int expected = Balance.INITIALBALANCE + Loan.LOAN_AMOUNT;
		
		assertEquals("Balance is increased by loan amount", bankAccount.getBalance(), expected);
	}
	
	@Test 	// Ensure number of loans taken out is tracked 
	public void test_Take_out_loan_Loan_Check() {
		BankAccount bankAccount = new BankAccount();
		bankAccount.takeOutLoan();
		
		assertEquals("Number of loans is increased by 1", bankAccount.getNumLoans(), 1);
	}
	
	@Test 	// Ensure number of loans does not decrease below zero
	public void test_RepayLoansButLoans0_LoanCheck() {
		BankAccount bankAccount = new BankAccount();
		
		bankAccount.repayLoans();
		
		assertEquals("Number of loans should remain 0", bankAccount.getNumLoans(), 0);
	}
	
	@Test	// Ensure balance does not decrease if no loans to pay
	public void test_RepayLoansButLoans0_BalanceCheck() {
		BankAccount bankAccount = new BankAccount();
		
		bankAccount.repayLoans();
		
		assertEquals("Balance should not decrease as no loans to repay", bankAccount.getBalance(), Balance.INITIALBALANCE);
	}
	
	@Test	// Ensure all loans are removed from bank account
	public void test_RepayLoans_LoanCheck() {
		BankAccount bankAccount = new BankAccount();
		bankAccount.takeOutLoan();
		bankAccount.takeOutLoan();
		bankAccount.takeOutLoan();
		
		bankAccount.repayLoans();
		
		assertEquals("Number of loans should be reduced to 0", bankAccount.getNumLoans(), 0);
	}
	
	@Test	// Ensure all loans are correctly paid off
	public void test_RepayLoans_BalanceCheck() {
		BankAccount bankAccount = new BankAccount();
		bankAccount.takeOutLoan();
		bankAccount.takeOutLoan();
		bankAccount.takeOutLoan();
		
		bankAccount.repayLoans();
		
		int expected = Balance.INITIALBALANCE + (3*Loan.LOAN_AMOUNT) - (3*Loan.LOAN_REPAY_AMOUNT);
		
		assertEquals("Balance should be decrease after repaying loans", bankAccount.getBalance(), expected);
	}

}
