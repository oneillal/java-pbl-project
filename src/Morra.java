import java.util.Scanner;

public class Morra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner keyboard = new Scanner(System.in);
		
		boolean player, exit;
		
		int numberOfGames = 0;

		System.out.println("Welcome to Morra Odds and Evens!");

		System.out.println("Choose ODDS [0] or EVENS [1]. Enter your choice [0 or 1]: ");
		player = Boolean.valueOf(keyboard.nextLine());

		Player p = new Player("Alan", true, player);
		Player c = new Player("Computer", false, !player);
		
		System.out.println(p.getName() + "," + p.isType() + "," + p.isChoice());
		System.out.println(c.getName() + "," + c.isType() + "," + c.isChoice() + "," + c.playerTurn() + "\n");
		
		exit = false;
		
		int cnt = 0;
		do {
			System.out.println("Starting game " + ++numberOfGames);
			
			System.out.println(p.getName() + " rolled a " + p.playerTurn());
			System.out.println(c.getName() + " rolled a " + p.playerTurn() + "\n");
			
			if(cnt > 6)
				exit = true;
			
			cnt++;
		} while (!exit); // loop condition
		System.out.println("Printing game history...");	
		System.out.println("Exiting game...");
	}

}
