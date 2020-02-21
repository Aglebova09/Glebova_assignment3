package Glebova_problem1;

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI2 {
	
	SecureRandom rand = new SecureRandom();
	Scanner scanner = new Scanner(System.in);
	
	//generates two random num
	int randInt1 = rand.nextInt(10);
	int randInt2 = rand.nextInt(10);

	public static void main(String[] args) 
	{	
		//call quiz
		new CAI2().quiz();
	}
	
	//program logic
	public void quiz()
	{
		int response;
		//ask question
		askQuestion();
		
		for (int i = 0; i < 1; i++)
		{
			//read response
			response = readResponse();
			
			//is answer correct if not ask again
			if(isAnswerCorrect(response))
			{
				displayCorrectResponse();
				System.exit(1);
			}
			else
			{
				displayIncorrectResponse();
				i--;
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
}
