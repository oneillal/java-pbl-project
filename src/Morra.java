import java.util.Scanner;

public class Morra {


	
/*	public Morra(String player, String computer) {

		boolean exit;
		
		int round = 0,
		    turn = 0,
		    compFingers = 0,
		    yourFingers = 0;
		//int[] games = new games[10];

		String youPlayAs  = player,
		       compPlayAs = computer;
		
		NoGenerator randomNo = new NoGenerator();
		Scanner keyboard = new Scanner(System.in);
		Game game = new Game(youPlayAs);

		exit = false;
		
		do {
			do {
				round++;

				System.out.println("\n######## STARTING ROUND " + round + " ########");
	
				System.out.println("\nHow many fingers will you show? [1-10]");
				yourFingers = keyboard.nextInt();
				
				System.out.println("\nYou[" + youPlayAs  + "]: " + yourFingers);

				compFingers = randomNo.gen();

				System.out.println("Computer[" + compPlayAs  + "]: " + compFingers);
				
				game.turn(yourFingers, compFingers, round);
				
				if(game.getRoundWinner(round) == youPlayAs) {
					System.out.println("\n**YOU** have WON round " + round + "\n");
					game.setNumberRoundsWonByPlayer(1);
				}
				else
					System.out.println("\nThe **COMPUTER** has WON round " + round + "\n");

				System.out.println("Points summary for round " + round + ":");
				System.out.println("You: " + game.getRoundStats("player"));
				System.out.println("Computer: " + game.getRoundStats("computer") + "\n");
				
				if(game.isGameDraw())
					System.out.println("It's a DRAW - One more round!\n");

			} while (!game.isGameOver()); // if nobody has won continue with another round
			
			System.out.println("\n\t##########################");
			System.out.println("\tThe WINNER of the game is: " + game.getGameWinner());
			System.out.println("\t##########################\n\n");

			System.out.println("\t++++++ Fingers Statistics +++++++");
			for(int i=1; i<=round; i++) {
				System.out.println("# Round " + i);
				System.out.println("You: " + game.getPlayerFingers(i));
				System.out.println("Computer: " + game.getCompFingers(i) + "\n");
			}
			System.out.println("++++++++++++++++++++++++++++++");
			exit = true; // record the details of the round in an Array of Round objects to maintain a history

		} while (!exit); // loop condition
		
		System.out.println("Printing game history...");	
		System.out.println("Exiting game...");

	}

*/
	public static void main(String[] args) {
		
		// to get input from users
		Scanner keyboard = new Scanner(System.in);

		// Creates an array of MorraApp objects
		MorraApp[] morra = new MorraApp[5];
		
		System.out.println("\n\t********************************************");
		System.out.println("\t***** Welcome to Morra Odds and Evens! *****");
		System.out.println("\t********************************************\n");

		int userChoice = 0,
		    count      = 0;
		
		String youPlayAs,
		       compPlayAs;

		String[] test = new String[10];

		// will loop until user inputs 2
		while(userChoice != 2){

			/*if(count > 0){
				System.out.println("Would you like to play again? yes/no");
				String input = keyboard.next();
			
				if(input == "No" || input == "N" || input == "no" || input == "n" || count > 5) {
					System.exit(0);
				}
			}*/

			System.out.println("Choose EVENS [0] or ODDS [1]. Enter your choice [0 or 1]: (2 to exit)");
			userChoice = keyboard.nextInt();
			switch(userChoice){
				case 0:
					System.out.println("You've chosen EVENS!");
					youPlayAs = "EVENS";
					compPlayAs = "ODDS";
					morra[count] = new MorraApp(youPlayAs,compPlayAs);
					morra[count].play();//youPlayAs,compPlayAs);
					count++;
					break;
				case 1:
					System.out.println("You've chosen ODDS!");
					youPlayAs = "ODDS";
					compPlayAs = "EVENS";
					morra[count] = new MorraApp(youPlayAs,compPlayAs);
					morra[count].play();//youPlayAs,compPlayAs);
					count++;
					break;
				case 2:
					System.out.println("Exiting...");
					break;
				default:
					break;
			}
		}


		// Print statistics of each game
		for(int i = 0; i < count; i++) {
			System.out.println(">>>> Game number " + (i+1) + " <<<<");

			System.out.println("\nNumber of rounds won by you: " + morra[i].numberRoundsWonByPlayer);
			System.out.println("Number of rounds won by the computer: " + morra[i].numberRoundsWonByComputer);
			
			System.out.println("\nNumber of Even numbers shown by you: " + morra[i].playerNumberOfEven);
			System.out.println("Number of Odds numbers shown by you: " + morra[i].playerNumberOfOdd);

			System.out.println("\nNumber of Even numbers shown by the computer: " + morra[i].compNumberOfEven);
			System.out.println("Number of Odds numbers shown by the computer: " + morra[i].compNumberOfOdd);

			System.out.println("\nNumber of Bonus points you received: " + morra[i].playerBonusPoints);
			System.out.println("Number of Bonus points the computer received: " + morra[i].compBonusPoints);
			
			System.out.println("\n");
		}

	}

}
