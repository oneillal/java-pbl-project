import java.util.Random;
import java.util.Scanner;

public class Morra {
	
	private static final int MIN = 0;
	private static final int MAX = 10;
	
	public static int playerTurn() {
		Random rn = new Random();;
		
		return MIN + rn.nextInt(MAX - MIN + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner keyboard = new Scanner(System.in);
		
		boolean player, exit, roundOver;
		
		int numberOfRounds = 0;
		int roundScore = 0;
		int oddsPlayerTurn = 0;
		int evensPlayerTurn = 0;
		int turn = 0;

		System.out.println("Welcome to Morra Odds and Evens!");

		System.out.println("Choose ODDS [0] or EVENS [1]. Enter your choice [0 or 1]: ");
		player = Boolean.valueOf(keyboard.nextLine());
		
		exit = false;
		
		do {
			roundScore = 0;
			System.out.println("Starting round " + ++numberOfRounds);
			
			Round round = new Round(numberOfRounds, false);
			
			do {
				// Start of turn
				oddsPlayerTurn = Morra.playerTurn();
				evensPlayerTurn = Morra.playerTurn();
				
				System.out.println("Even player rolled a " + evensPlayerTurn);
				System.out.println("Odd player rolled a " + oddsPlayerTurn + "\n");
				
				round.turn(oddsPlayerTurn, evensPlayerTurn);
				
				System.out.println(round.getEvensPlayerScore());
				System.out.println(round.getOddsPlayerScore());
				
			} while (!round.isRoundOver()); // if nobody has won continue with another turn
			
			exit = true; // record the details of the round in an Array of Round objects to maintain a history
			
			
		} while (!exit); // loop condition
		
		System.out.println("Printing game history...");	
		System.out.println("Exiting game...");
	}

}
