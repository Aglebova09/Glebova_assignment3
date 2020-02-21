package Glebova_problem2;

public class SavingsAccount {
	
	private static double annualInterestRate;
	private double savingsBalance;
	
	public SavingsAccount(double balance)
	{
		savingsBalance = balance;
	}
	
	public double calculateMonthlyInterest()
	{
		savingsBalance += (savingsBalance * annualInterestRate)/12.0;
		
		return savingsBalance;
	}
	
	public static void modifyInterestRate(double newRate)
	{
		annualInterestRate = newRate;
	}

}
