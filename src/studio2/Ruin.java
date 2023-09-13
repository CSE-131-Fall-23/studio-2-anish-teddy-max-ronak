package studio2;

import java.util.Scanner;

public class Ruin {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.print("Enter starting amount: ");
		double startAmount = in.nextDouble();
		 

		System.out.print("Enter win probability: ");
		double winChance = in.nextDouble();

		System.out.print("Enter max winnings: ");
		double winLimit = in.nextDouble();

		System.out.print("How many day's you'll gamble: ");
		int totalSimulations =in.nextInt();


		int currentSimulation = 1;
		int numLosses = 0;

		for(int i = 0; i < totalSimulations; i++)
		{
			double amount = startAmount;
			int currentRound = 1;
			while (amount > 0 && amount < winLimit) {
				double roll = Math.random();

				if (roll < winChance) {
					amount++;

				}
				else {
					amount--;
				}
				currentRound++;

			}
			if (amount == 0) {
				System.out.println("Simulation " + currentSimulation + ": " + currentRound + " LOSE");
				numLosses++;
			}
			if (amount == winLimit) {
				System.out.println("Simulation " + currentSimulation + ": " + currentRound + " WIN");
			}

			currentSimulation++;

		}
		double expectedRuin;
		if (winChance == 0.5)
		{
			expectedRuin = 1-(startAmount/winLimit);
		}
		else
		{
			double alpha = (1-winChance)/winChance;
			expectedRuin = ((Math.pow(alpha, startAmount)- Math.pow(alpha, winLimit))/(1-Math.pow(alpha, winLimit)));
		}
		System.out.println("Losses: " + numLosses + " Simulations: " + totalSimulations);
		System.out.println("Ruin rate from Simulation: " + (double) numLosses/totalSimulations);
		System.out.println("Expected Ruin Rate: " + expectedRuin);
		 
		
	}
}

