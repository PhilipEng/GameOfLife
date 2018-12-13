package gameoflife.bank;

import static org.junit.Assert.*;

import org.junit.Test;

public class BankAccountTest {

	@Test
	public void test_Balance_Increase() {
		BankAccount bankAccount = new BankAccount();
		bankAccount.increaseBalance(50000);
		
		int expected = Balance.INITIALBALANCE + 50000;
		
		assertEquals("Balance gets successfully increased", bankAccount.getBalance(), expected);
	}
	
	@Test
	public void test_Balance_Decrease_with_Sufficient_Funds() {
		BankAccount bankAccount = new BankAccount();
		bankAccount.decreaseBalance(50000);
		
		int expected = Balance.INITIALBALANCE - 50000;
		
		assertEquals("Balance gets successfully decreased", bankAccount.getBalance(), expected);
	}
	
	@Test
	public void test_Balance_Decrease_without_Sufficient_Funds_Balance_Check() {
		BankAccount bankAccount = new BankAccount();
		bankAccount.decreaseBalance(260000);
		
		int expected = Balance.INITIALBALANCE - 260000 + 2*Loan.LOANAMOUNT;
		
		assertEquals("Insufficient funds in account so loans will be taken out so the balance can be decreased", bankAccount.getBalance(), expected);
	}
	
	@Test
	public void test_Balance_Decrease_without_Sufficient_Funds_Loan_Check() {
		BankAccount bankAccount = new BankAccount();
		bankAccount.decreaseBalance(260000);
		
		assertEquals("Insufficient funds in account so 2 loans will be taken out", bankAccount.getNumLoans(), 2);
	}
	
	@Test
	public void test_Take_out_loan_Balance_Check() {
		BankAccount bankAccount = new BankAccount();
		bankAccount.takeOutLoan();
		
		int expected = Balance.INITIALBALANCE + Loan.LOANAMOUNT;
		
		assertEquals("Balance is increased by loan amount", bankAccount.getBalance(), expected);
	}
	
	@Test
	public void test_Take_out_loan_Loan_Check() {
		BankAccount bankAccount = new BankAccount();
		bankAccount.takeOutLoan();
		
		assertEquals("Number of loans is increased by 1", bankAccount.getNumLoans(), 1);
	}
	
	@Test
	public void test_RepayLoansButLoans0_LoanCheck() {
		BankAccount bankAccount = new BankAccount();
		
		bankAccount.repayLoans();
		
		assertEquals("Number of loans should remain 0", bankAccount.getNumLoans(), 0);
	}
	
	@Test
	public void test_RepayLoansButLoans0_BalanceCheck() {
		BankAccount bankAccount = new BankAccount();
		
		bankAccount.repayLoans();
		
		assertEquals("Balance should not decrease as no loans to repay", bankAccount.getBalance(), Balance.INITIALBALANCE);
	}
	
	@Test
	public void test_RepayLoans_LoanCheck() {
		BankAccount bankAccount = new BankAccount();
		bankAccount.takeOutLoan();
		bankAccount.takeOutLoan();
		bankAccount.takeOutLoan();
		
		bankAccount.repayLoans();
		
		assertEquals("Number of loans should be reduced to 0", bankAccount.getNumLoans(), 0);
	}
	
	@Test
	public void test_RepayLoans_BalanceCheck() {
		BankAccount bankAccount = new BankAccount();
		bankAccount.takeOutLoan();
		bankAccount.takeOutLoan();
		bankAccount.takeOutLoan();
		
		bankAccount.repayLoans();
		
		int expected = Balance.INITIALBALANCE + (3*Loan.LOANAMOUNT) - (3*Loan.LOANREPAYAMOUNT);
		
		assertEquals("Balance should be decrease after repaying loans", bankAccount.getBalance(), expected);
	}

}
