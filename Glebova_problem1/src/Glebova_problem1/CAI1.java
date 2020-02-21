package Glebova_problem1;

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI1 {
	
	SecureRandom rand = new SecureRandom();
	Scanner scanner = new Scanner(System.in);
	
	//generates two random num
	int randInt1 = rand.nextInt(10);
	int randInt2 = rand.nextInt(10);

	public static void main(String[] args) 
	{	
		//call quiz
		new CAI1().quiz();
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
	
	//message Very Good!
	public void displayCorrectResponse()
	{
		System.out.println("Very Good!");
	}
	
	//message No. Please try again.
	public void displayIncorrectResponse()
	{
		System.out.println("No. Please try again.");
	}
}
