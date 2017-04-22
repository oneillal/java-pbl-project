
// Main class that interacts with the user when initiating the game

/*
	JAVA PROJECT - CYBERSECURITY - 2017

	Group Members:
	Alan O'Neill - 16134427
	Jonas Stein  - 16136306
	Mark Hanlon  - 16135571

*/

// input from user 
import java.util.Scanner;

public class MorraApp {

	public static void main(String[] args) {
		
		// get input from users
		Scanner keyboard = new Scanner(System.in);

		// Creates an array of Morra objects. Up to five games is allowed per run
		Morra[] morra = new Morra[5];
		
		System.out.println("\n\t********************************************");
		System.out.println("\t***** Welcome to Morra Odds and Evens! *****");
		System.out.println("\t********************************************\n");

		// userChoice => 0 = EVENS; 1 = ODDS; 2 = EXIT;
		int userChoice = 0,
		// used in the morra array
		    count      = 0;
		
		// to set who the player and computer will play as
		String youPlayAs,
		       compPlayAs;

		// will loop until user inputs 2
		while(userChoice != 2){

			System.out.println("Choose EVENS [0] or ODDS [1]. Enter your choice [0 or 1]: (2 to exit)");
			userChoice = keyboard.nextInt();
			switch(userChoice){
				case 0:
					System.out.println("You've chosen EVENS!");
					youPlayAs = "EVENS";
					compPlayAs = "ODDS";
					// instantiates Morra class
					morra[count] = new Morra(youPlayAs,compPlayAs);
					morra[count].play();
					count++;
					break;
				case 1:
					System.out.println("You've chosen ODDS!");
					youPlayAs = "ODDS";
					compPlayAs = "EVENS";
					// instantiates Morra class
					morra[count] = new Morra(youPlayAs,compPlayAs);
					morra[count].play();
					count++;
					break;
				case 2:
					// EXIT the loop
					System.out.println("Exiting...");
					break;
				default:
					break;
			}
		}


		// Print statistics of each game
		for(int i = 0; i < count; i++) {
			System.out.println(">>>> Game number " + (i+1) + " <<<<");

			// Number of rounds won by player and computer
			System.out.println("\nNumber of rounds won by you: " + morra[i].numberRoundsWonByPlayer);
			System.out.println("Number of rounds won by the computer: " + morra[i].numberRoundsWonByComputer);
			
			// Number of Even numbers shown by player
			System.out.println("\nNumber of Even numbers shown by you: " + morra[i].playerNumberOfEven);
			System.out.println("Number of Odds numbers shown by you: " + morra[i].playerNumberOfOdd);

			// Number of Even numbers shown by the computer
			System.out.println("\nNumber of Even numbers shown by the computer: " + morra[i].compNumberOfEven);
			System.out.println("Number of Odds numbers shown by the computer: " + morra[i].compNumberOfOdd);

			// Number of Bonus points the player and computer received
			System.out.println("\nNumber of Bonus points you received: " + morra[i].playerBonusPoints);
			System.out.println("Number of Bonus points the computer received: " + morra[i].compBonusPoints);
			
			System.out.println("\n");
		}
	// close main
	}
// close MorraApp
}
