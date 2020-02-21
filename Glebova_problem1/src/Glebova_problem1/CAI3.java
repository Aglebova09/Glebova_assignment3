package Glebova_problem1;

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI3 {

	SecureRandom rand = new SecureRandom();
	Scanner scanner = new Scanner(System.in);
	
	//generates two random num
	int randInt1;
	int randInt2;
	
	//counter to see how many they get right
	int counterC = 0;
	
	//string to continue the application
	String continueP = "";

	public static void main(String[] args) 
	{	
		//call quiz
		new CAI3().quiz();
	}
	
	//program logic
	public void quiz()
	{
		int response;
		
		//j loop for reseting the whole program
		for (int j = 0; j < 1; j++) {
			
			for (int i = 0; i < 10; i++)
			{
				randInt1 = rand.nextInt(10);
				randInt2 = rand.nextInt(10);
				
				askQuestion();
				
				//read response
				response = readResponse();
					
				//check if answer is correct and add to corresponding counter
				if(isAnswerCorrect(response))
				{
					displayCorrectResponse();
					correctCounterUp();
				}
				else
				{
					displayIncorrectResponse();
				}
			}
			
			displayCompletionMessage();
			
			if (continueP.equalsIgnoreCase("Y"))
			{
				j--;
			}
			else if (continueP.equalsIgnoreCase("N"))
			{
				System.exit(1);
			}
		}
	}
	
	//prints problem on screen
	public void askQuestion()
	{
		System.out.printf("How much is %d times %d?\n", randInt1, randInt2);
	}
	
	//read in response
	public int readResponse()
	{
		int response = scanner.nextInt();
		return response;
	}
	
	//check correct answer 
	public boolean isAnswerCorrect(int response)
	{
		int ans = randInt1 * randInt2;
		
		//checks if the response is correct and returns true(1)
		if (ans == response)
		{
			return true;
		}
		else //returns false(0)
		{
			return false;
		}
	}
	
	//message if correct response
	public void displayCorrectResponse()
	{
		int max = 4, min = 1;
		int num = rand.nextInt((max - min)+1)+min;
		switch (num)
		{
		case 1:
			System.out.println("Very good!");
			break;
		case 2:
			System.out.println("Excellent!");
			break;
		case 3:
			System.out.println("Nice work!");
			break;
		case 4:
			System.out.println("Keep up the good work!");
			break;
		}

	}
	
	//message if incorrect response
	public void displayIncorrectResponse()
	{
		int max = 4, min = 1;
		int num = rand.nextInt((max - min)+1)+min;
		switch (num)
		{
		case 1:
			System.out.println("No. Please try again.");
			break;
		case 2:
			System.out.println("Wrong. Try once more.");
			break;
		case 3:
			System.out.println("Don't give up!");
			break;
		case 4:
			System.out.println("No. Keep trying.");
			break;
		}
	}
	
	public void correctCounterUp()
	{
		counterC++;
	}
	
	public double getPercentage(int counter)
	{
		double percentage;
		
		percentage = (counter/10.0) * 100.0;
		
		return percentage;
	}
	
	public void readContinue()
	{
		System.out.printf("Would you like to solve another problem set? If yes enter Y, if not enter N\n");
		continueP = scanner.nextLine(); //eliminates the problem that it counts the space after question as next line
		continueP = scanner.nextLine();
	}
	
	public void displayCompletionMessage()
	{
		//compares percentage if bellow 75
		if (getPercentage(counterC) < 75)
		{
			System.out.printf("Your score is %.2f. Please ask your teacher for extra help.\n", getPercentage(counterC));
			readContinue();
		}
		else
		{
			System.out.printf("Your score is %.2f. Congratulations, you are ready to go to the next level!\n", getPercentage(counterC));
			readContinue();
		}
	}

}
