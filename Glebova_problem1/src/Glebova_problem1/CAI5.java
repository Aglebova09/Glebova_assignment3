package Glebova_problem1;

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI5 {

	SecureRandom rand = new SecureRandom();
	Scanner scanner = new Scanner(System.in);
	
	//generates two random num
	int randInt1;
	int randInt2;
	
	int difLevel;
	int problemType;
	int firstProbType;
	
	int counterC = 0;
	
	String continueP = "";

	public static void main(String[] args) 
	{	
		//call quiz
		new CAI5().quiz();
	}
	
	//program logic
	public void quiz()
	{
		double response;

		//ask question
		
		for (int j = 0; j < 1; j++) {
			
			readDifficulty();
			readProblemType();
			
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
	
	//puts together the question
	public void askQuestion()
	{
		String problemTypeS;
		
		if(problemType == 5)
		{
			firstProbType = 5;
		}
		
		if(firstProbType == 5)
		{
			problemType = 5;
			problemTypeS = getProbType();
		}
		else
		{
			problemTypeS = getProbType();
		}
		
		if (problemTypeS == "divided by" && randInt2 == 0) //makes sure we dont divide by 0
		{
			generateQuestionArgument();
		}
		
		System.out.printf("How much is %d %s %d? Answer up to 2 decimal points.\n", randInt1, problemTypeS, randInt2); //Concatenates 
	}
	
	
	public String getProbType()
	{
		int max = 4, min = 1;
		
		for (int i = 0; i < 1; i++)
		{
			if(problemType == 1)
			{
				return "plus";
			}
			else if(problemType == 2)
			{
				return "times";
			}
			else if(problemType == 3)
			{
				return "minus";
			}
			else if(problemType == 4)
			{
				return "divided by";
			}
			else
			{
				problemType = rand.nextInt((max - min)+1)+min; //runs the if statement again but now with a random problemType 1-4
				i--;
			}
		}
		return "Is bad if this returns";
	}
	
	//read in response
	public double readResponse()
	{
		double response = scanner.nextDouble();
		return response;
	}
	
	//check correct answer 
	public boolean isAnswerCorrect(double response)
	{
		double ans = calcAns();
		
		//checks if the response is correct and returns true(1)
		if (Math.abs(ans - response) < .001)
		{
			return true;
		}
		else //returns false(0)
		{
			return false;
		}
	}
	
	public double calcAns()
	{
		double ans = 0;
		if (problemType == 1)
		{
			ans = randInt1 + randInt2;
		}
		else if (problemType == 2)
		{
			ans = randInt1 * randInt2;
		}
		else if (problemType == 3)
		{
			ans = randInt1 - randInt2;
		}
		else if (problemType == 4)
		{
			ans = (1.0*(randInt1))/ randInt2; //makes it a double
		}
		return ans;
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
			System.out.printf("Your score is %.1f%%. Please ask your teacher for extra help.\n", getPercentage(counterC));
			readContinue();
		}
		else
		{
			System.out.printf("Your score is %.1f%%. Congratulations, you are ready to go to the next level!\n", getPercentage(counterC));
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
	
	public void readProblemType()
	{
		System.out.println("Enter 1 for addition problems, 2 for multiplication, 3 for subtraction, 4 for division, and 5 for a mix of all");
		problemType = scanner.nextInt();
	}

}
