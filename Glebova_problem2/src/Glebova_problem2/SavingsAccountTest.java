package Glebova_problem2;

public class SavingsAccountTest {

	public static void main(String[] args) {
		SavingsAccount saver1 = new SavingsAccount(2000.0);
		SavingsAccount saver2 = new SavingsAccount(3000.0);
		
		SavingsAccount.modifyInterestRate(0.04);
		System.out.printf("%.2f\n%.2f\n", saver1.calculateMonthlyInterest(), saver2.calculateMonthlyInterest());
		
		SavingsAccount.modifyInterestRate(0.05);
		System.out.printf("%.2f\n%.2f", saver1.calculateMonthlyInterest(), saver2.calculateMonthlyInterest());

	}

}
