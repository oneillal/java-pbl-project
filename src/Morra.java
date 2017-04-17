import java.util.Scanner;

public class Morra {



	public Morra(String player, String computer) {
	//}
	//public void play(){
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
		//ArrayList games = new ArrayList();
		String youPlayAs = player,
		       compPlayAs = computer,
		       roundResult;



		exit = false;
		
		do {
			roundScore = 0;
			
			Game game = new Game(youPlayAs, gameNo++);

			//Round round = new Round(numberOfRounds, false);
			
			do {
				// Start of turn
				//oddsPlayerTurn = Morra.playerTurn();
				//oddsPlayerTurn = randomNo.gen();
				//evensPlayerTurn = Morra.playerTurn();
				//evensPlayerTurn = randomNo.gen();
				round++;
				System.out.println("\n######## STARTING ROUND " + round + " ########");
	
				System.out.println("\nHow many fingers will you show? [1-10]");
				yourFingers = keyboard.nextInt();
				
				System.out.println("\nYou[" + youPlayAs  + "]: " + yourFingers);

				compFingers = randomNo.gen();
				//compFingers = keyboard.nextInt();

				System.out.println("Computer[" + compPlayAs  + "]: " + compFingers);
				
				game.turn(yourFingers, compFingers);
				
				if(game.getRoundWinner() == youPlayAs)
					//roundResult = "WON";
					System.out.println("\n**YOU** have WON round " + round + "\n");
				//else if(game.getRoundWinner() == compPlayAs)
				else
					//roundResult = "LOST";
					System.out.println("\nThe **COMPUTER** has WON round " + round + "\n");

				//System.out.println("\nYou've **" + roundResult  + "** round " + round + "\n");
				System.out.println("Points summary for round " + round + ":");
				System.out.println("You: " + game.getRoundStats("player"));
				System.out.println("Computer: " + game.getRoundStats("computer") + "\n");
				
				if(game.isGameDraw())
					System.out.println("It's a DRAW - One more round!\n");

			} while (!game.isGameOver()); // if nobody has won continue with another turn
			
			System.out.println("\n\t##########################");
			System.out.println("\tThe WINNER of the game is: " + game.getGameWinner());
			System.out.println("\t##########################\n\n");
			exit = true; // record the details of the round in an Array of Round objects to maintain a history

		} while (!exit); // loop condition
		
		System.out.println("Printing game history...");	
		System.out.println("Exiting game...");

	}
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);

		System.out.println("\n\t********************************************");
		System.out.println("\t***** Welcome to Morra Odds and Evens! *****");
		System.out.println("\t********************************************\n");

		int userChoice = 0;
		String youPlayAs,
		       compPlayAs;

		while(userChoice != 2){
		System.out.println("Choose EVENS [0] or ODDS [1]. Enter your choice [0 or 1]: (2 to exit)");
		userChoice = keyboard.nextInt();
		//userChoice = Morra.Play();
			switch(userChoice){
				case 0:
					System.out.println("You've chosen EVENS!");
					youPlayAs = "EVENS";
					compPlayAs = "ODDS";
					//morra.play();
					Morra morraEvens = new Morra(youPlayAs,compPlayAs);
					break;
				case 1:
					System.out.println("You've chosen ODDS!");
					youPlayAs = "ODDS";
					compPlayAs = "EVENS";
					//morra.play();
					Morra morraOdds = new Morra(youPlayAs,compPlayAs);
					break;
				case 2:
					System.out.println("Exiting...");
					//System.exit(0);
					break;
				default:
					break;
			}
			
		}
	}
}
