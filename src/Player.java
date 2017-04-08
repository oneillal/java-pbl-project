import java.util.Random;

public class Player {

	private static final int MIN = 0;
	private static final int MAX = 10;
	
	private String name;
	private boolean type; // true = Human   false = Computer
	private boolean choice; // true = Evens   false = Odds
	

	
	public Player(String name, boolean type, boolean choice) {
		super();
		this.name = name;
		this.type = type;
		this.choice = choice;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public boolean isType() {
		return type;
	}



	public void setType(boolean type) {
		this.type = type;
	}



	public boolean isChoice() {
		return choice;
	}



	public void setChoice(boolean choice) {
		this.choice = choice;
	}



	public int playerTurn() {
		
		Random rn = new Random();;
		
		return MIN + rn.nextInt(MAX - MIN + 1);
	}
	
}
