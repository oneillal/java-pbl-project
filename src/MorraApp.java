import java.util.Scanner;

public class MorraApp {

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

	public MorraApp(String player, String computer) {

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
		// generates random numbers
		//NoGenerator randomNo = new NoGenerator();

		// user input
		//Scanner keyboard = new Scanner(System.in);

		// create object game
		//Game game = new Game(youPlayAs);

		//exit = false;
	}

	public void play(){//String player, String computer) {

		/*String youPlayAs  = player,
		       compPlayAs = computer;

		boolean exit;

		int round = 0,
		    turn = 0,
		    compFingers = 0,
		    yourFingers = 0;

		exit = false; */

		// generates random numbers
		NoGenerator randomNo = new NoGenerator();

		// user input
		Scanner keyboard = new Scanner(System.in);

		// create object game
		Game game = new Game(youPlayAs);

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
					game.setNumberRoundsWonByPlayer();
				}
				else {
					System.out.println("\nThe **COMPUTER** has WON round " + round + "\n");
					game.setNumberRoundsWonByComputer();
				}
				System.out.println("Points summary - round " + round + ":");
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

		//System.out.println("Printing game history...");
		this.numberRoundsWonByPlayer = game.getNumberRoundsWonByPlayer();
	    	this.numberRoundsWonByComputer = game.getNumberRoundsWonByComputer();
	    	this.playerNumberOfEven = game.getPlayerNumberOfEven();
	    	this.playerNumberOfOdd = game.getPlayerNumberOfOdd();
	    	this.compNumberOfEven = game.getCompNumberOfEven();
	    	this.compNumberOfOdd = game.getCompNumberOfOdd();
	    	this.playerBonusPoints = game.getPlayerBonusPoints();
	    	this.compBonusPoints = game.getCompBonusPoints();

		//System.out.println("Exiting game...");

	}
}
