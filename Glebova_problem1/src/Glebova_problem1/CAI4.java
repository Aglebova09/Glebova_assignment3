package Glebova_problem1;

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI4 {

	SecureRandom rand = new SecureRandom();
	Scanner scanner = new Scanner(System.in);
	
	//generates two random num
	int randInt1;
	int randInt2;
	
	int difLevel;
	
	int counterC = 0;
	
	String continueP = "";

	public static void main(String[] args) 
	{	
		//call quiz
		new CAI4().quiz();
	}
	
	//program logic
	public void quiz()
	{
		int response;

		//ask question
		
		for (int j = 0; j < 1; j++) {
			
			readDifficulty();
			
			for (int i = 0; i < 10; i++)
			{
				generateQuestionArgument();
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
				j--; //makes the i for loop go again
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
	
	//counts up the correct number of responses
	public void correctCounterUp()
	{
		counterC++;
	}
	
	//calculates percentage
	public double getPercentage(int counter)
	{
		double percentage;
		
		percentage = (counter/10.0) * 100.0;
		
		return percentage;
	}
	
	//reads in if user wants to do another set
	public void readContinue()
	{
		System.out.printf("Would you like to solve another problem set? If yes enter Y, if not enter N\n");
		continueP = scanner.nextLine();
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
	
	//read the difficulty level
	public void readDifficulty()
	{
		System.out.println("Chose your difficulty. Enter 1 for 1 digit numbers, 2 for 2 digit numbers and so on. Highest difficulty is 4");
		difLevel = scanner.nextInt();
	}
	
	//based on level difficulty alters random num scope
	public void generateQuestionArgument()
	{
		if (difLevel == 1)
		{
			randInt1 = rand.nextInt(10);
			randInt2 = rand.nextInt(10);
		}
		else if (difLevel == 2)
		{
			randInt1 = rand.nextInt(100);
			randInt2 = rand.nextInt(100);
		}
		else if (difLevel == 3)
		{
			randInt1 = rand.nextInt(1000);
			randInt2 = rand.nextInt(1000);
		}
		else if (difLevel == 4)
		{
			randInt1 = rand.nextInt(10000);
			randInt2 = rand.nextInt(10000);
		}
	}
}
