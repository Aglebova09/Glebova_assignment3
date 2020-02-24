package Glebova_problem2;

public class SavingsAccountTest {

	public static void main(String[] args) {
		SavingsAccount saver1 = new SavingsAccount(2000.0);
		SavingsAccount saver2 = new SavingsAccount(3000.0);
		
		SavingsAccount.modifyInterestRate(0.04);
		System.out.println("Saver 1:                     Saver 2:");
		for(int i = 0; i < 12; i++)
		{
			System.out.printf("Month %d. %.2f             Month %d. %.2f\n", i+1,saver1.calculateMonthlyInterest(), i+1, saver2.calculateMonthlyInterest());
		}
		
		
		SavingsAccount.modifyInterestRate(0.05);
		System.out.println("\nSaver 1:                     Saver 2:");
		for(int i = 0; i < 12; i++)
		{
			System.out.printf("Month %d. %.2f             Month %d. %.2f\n", i+1,saver1.calculateMonthlyInterest(), i+1, saver2.calculateMonthlyInterest());
		}
	}

}
