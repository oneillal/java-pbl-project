// instantiable class that interfaces with the user in a game


import java.util.Scanner;

public class Morra {

	String youPlayAs,
	       compPlayAs;

	boolean exit;

	int round = 0,
	    turn = 0,
	    compFingers = 0,
	    yourFingers = 0,
	    numberRoundsWonByPlayer,
	    numberRoundsWonByComputer,
	    playerNumberOfEven,
	    playerNumberOfOdd,
	    compNumberOfEven,
	    compNumberOfOdd,
	    playerBonusPoints,
	    compBonusPoints;

	// Instantiate the class setting the following values
	// player and computer are either EVENS or ODDS
	public Morra(String player, String computer) {

		this.exit = false;
		this.round = 0;
		this.turn = 0;
		this.compFingers = 0;
		this.yourFingers = 0;
		this.numberRoundsWonByPlayer = 0;
	    	this.numberRoundsWonByComputer = 0;
	    	this.playerNumberOfEven = 0;
	    	this.playerNumberOfOdd = 0;
	    	this.compNumberOfEven = 0;
	    	this.compNumberOfOdd = 0;
	    	this.playerBonusPoints = 0;
	    	this.compBonusPoints = 0;
		this.youPlayAs  = player;
		this.compPlayAs = computer;

	}

	public void play(){

		// generates random numbers
		NoGenerator randomNo = new NoGenerator();

		// user input
		Scanner keyboard = new Scanner(System.in);

		// create object game
		Game game = new Game(youPlayAs);

		// loops until exit=true
		do {
			// loops until game.isGameOver() returns true
			do {
				round++;

				System.out.println("\n######## STARTING ROUND " + round + " ########");

				System.out.println("\nHow many fingers will you show? [1-10]");
				// ask input from user
				yourFingers = keyboard.nextInt();

				System.out.println("\nYou[" + youPlayAs  + "]: " + yourFingers);

				// generates a number 1 to 10 for the computer
				compFingers = randomNo.gen();

				System.out.println("Computer[" + compPlayAs  + "]: " + compFingers);

				// computer the choices made by the user and computer in this round
				game.turn(yourFingers, compFingers, round);

				// find the round winner
				if(game.getRoundWinner(round) == youPlayAs) {
					System.out.println("\n**YOU** have WON round " + round + "\n");
					game.setNumberRoundsWonByPlayer();
				}
				else {
					System.out.println("\nThe **COMPUTER** has WON round " + round + "\n");
					game.setNumberRoundsWonByComputer();
				}

				System.out.println("Points summary - round " + round + ":");
				System.out.println("You: " + game.getRoundStats("player"));
				System.out.println("Computer: " + game.getRoundStats("computer") + "\n");

				// check if both computer and player have 6 points at the end of a round
				if(game.isGameDraw())
					System.out.println("It's a DRAW - One more round!\n");

			} while (!game.isGameOver()); // if nobody has won continue with another round

			System.out.println("\n\t##########################");
			System.out.println("\tThe WINNER of the game is: " + game.getGameWinner());
			System.out.println("\t##########################\n\n");

			// prints Fingers stats
			System.out.println("\t++++++ Fingers Statistics +++++++");
			for(int i=1; i<=round; i++) {
				System.out.println("# Round " + i);
				System.out.println("You: " + game.getPlayerFingers(i));
				System.out.println("Computer: " + game.getCompFingers(i) + "\n");
			}
			System.out.println("++++++++++++++++++++++++++++++");

			// to exit loop
			exit = true;


		// loop stops when exit = true
		} while (!exit); 

		// Set game history. MorraApp will need these values to print history of each game
		this.numberRoundsWonByPlayer = game.getNumberRoundsWonByPlayer();
	    	this.numberRoundsWonByComputer = game.getNumberRoundsWonByComputer();
	    	this.playerNumberOfEven = game.getPlayerNumberOfEven();
	    	this.playerNumberOfOdd = game.getPlayerNumberOfOdd();
	    	this.compNumberOfEven = game.getCompNumberOfEven();
	    	this.compNumberOfOdd = game.getCompNumberOfOdd();
	    	this.playerBonusPoints = game.getPlayerBonusPoints();
	    	this.compBonusPoints = game.getCompBonusPoints();

	}
}
