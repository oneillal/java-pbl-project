import java.util.Scanner;

public class Morra {


	
	public Morra(String player, String computer) {

		NoGenerator randomNo = new NoGenerator();
		Scanner keyboard = new Scanner(System.in);
		
		boolean exit, roundOver;
		
		int round = 0;
		int roundScore = 0;
		int oddsPlayerTurn = 0;
		int evensPlayerTurn = 0;
		int turn = 0;
		int compFingers = 0,
		    gameNo = 0,
		    yourFingers = 0;
		//int[] games = new games[10];
		String youPlayAs = player,
		       compPlayAs = computer,
		       roundResult;

		exit = false;
		
		do {
			roundScore = 0;
			
			Game game = new Game(youPlayAs, gameNo++);
			
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


	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		Morra[] play = new Morra[5];

		System.out.println("\n\t********************************************");
		System.out.println("\t***** Welcome to Morra Odds and Evens! *****");
		System.out.println("\t********************************************\n");

		int userChoice = 0,
		    count      = 0;
		String youPlayAs,
		       compPlayAs;

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
					//Morra[] play = new Morra[5];
					play[count] = new Morra(youPlayAs,compPlayAs);
					count++;
					//Morra morraEvens = new Morra(youPlayAs,compPlayAs);
					break;
				case 1:
					System.out.println("You've chosen ODDS!");
					youPlayAs = "ODDS";
					compPlayAs = "EVENS";
					//Morra[] play = new Morra[5];
					play[count] = new Morra(youPlayAs,compPlayAs);
					count++;
					//Morra morraOdds = new Morra(youPlayAs,compPlayAs);
					break;
				case 2:
					System.out.println("Exiting...");
					break;
				default:
					break;
			}
		}

		//for(Morra test : play) {
			System.out.println(play[0].round);
//}
/*
		// Print statistics of each game
		for(int i=0; i > count; i++) {
			System.out.println(">>>> Game number " + i+1 + " <<<<");

			System.out.println("\nNumber of rounds won by you: " + play[i].game.getNumberRoundsWonByPlayer());
			System.out.println("Number of rounds won by the computer: " + (play[i].game.getNumberRoundsWonByPlayer() - play[i].game.getNumberOfTurns));
			
			System.out.println("\nNumber of Even numbers shown by you: " + play[i].game.getPlayerNumberOfEven());
			System.out.println("Number of Odds numbers shown by you: " + play[i].game.getPlayerNumberOfOdd());

			System.out.println("\nNumber of Even numbers shown by the computer: " + play[i].game.getCompNumberOfEven());
			System.out.println("Number of Odds numbers shown by the computer: " + play[i].game.getCompNumberOfOdd());

			System.out.println("\nNumber of Bonus points you received: " + play[i].game.getPlayerBonusPoints());
			System.out.println("Number of Bonus points the computer received: " + play[i].game.getCompBonusPoints());
			
			System.out.println("\n");
		}
*/

	}
}
