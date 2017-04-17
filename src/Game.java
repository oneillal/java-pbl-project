
public class Game {
	int roundNumber;
	int numberOfTurns;
	int playerScore;
	int computerScore;
	int oddsPlayerBonusPts;
	int evensPlayerBonusPts;
	boolean gameOver,
		gameDraw = false;
	String playAs;
	//int[] fingers = new int[10];
	int fingers;
	int gameNumber;
	String roundWinner,
	       gameWinner;
	
	public Game(String playerChoice, int gameNo) {
		this.roundNumber = 0;
		this.playAs = playerChoice;
		this.gameOver = false;
		this.numberOfTurns = 0;
		this.playerScore = 0;
		this.computerScore = 0;
		this.oddsPlayerBonusPts = 0;
		this.evensPlayerBonusPts = 0;
		this.fingers = 0;
		this.gameNumber = gameNo;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	public int getRoundNumber() {
		return roundNumber;
	}

	public void setRoundNumber(int roundNumber) {
		this.roundNumber = roundNumber;
	}

	public int getFingers(int roundNumber) {
		//return fingers[roundNumber];
		return fingers;
	}

	public void setFingers(int fingers, int roundNumber) {
		//this.fingers[roundNumber] = fingers;
		this.fingers = fingers;
	}

	public int getNumberOfTurns() {
		return numberOfTurns;
	}

	public void setNumberOfTurns(int numberOfTurns) {
		this.numberOfTurns = numberOfTurns;
	}

	public int getPlayerScore() {
		return playerScore;
	}

	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}

	public int getComputerScore() {
		return computerScore;
	}

	public void setComputerScore(int computerScore) {
		this.computerScore = computerScore;
	}

	public int getOddsPlayerBonusPts() {
		return oddsPlayerBonusPts;
	}

	public void setOddsPlayerBonusPts(int oddsPlayerBonusPts) {
		this.oddsPlayerBonusPts = oddsPlayerBonusPts;
	}

	public boolean isGameDraw() {
		return gameDraw;
	}

	public void setisGameDraw(boolean gameDraw) {
		this.gameDraw = gameDraw;
	}

	public String getGameWinner() {
		return gameWinner;
	}

	public void setGameWinner(String gameWinner) {
		this.gameWinner = gameWinner;
	}

	public String getRoundWinner() {
		return roundWinner;
	}

	public void setRoundWinner(String roundWinner) {
		this.roundWinner = roundWinner;
	}

	public int getEvensPlayerBonusPts() {
		return evensPlayerBonusPts;
	}

	public int getRoundStats(String player) {
                if(player == "player")
			return getPlayerScore();
		else
			return getComputerScore();
        }

	public void setEvensPlayerBonusPts(int evensPlayerBonusPts) {
		this.evensPlayerBonusPts = evensPlayerBonusPts;
	}

	public void turn(int playerFingers, int compFingers) {
		numberOfTurns++;

		// EVENS result
		if((playerFingers + compFingers) % 2 == 0) {
			if(playAs == "EVENS"){
				//System.out.println("-----EVENS----player +2");
				playerScore += 2;}
			else{
				//System.out.println("-----EVENS----comp +2");
				computerScore += 2;}
			//System.out.println("EVENS won round " + roundNumber);
			roundWinner = "EVENS";
		}
		// ODDS result
		else {
			if(playAs == "ODDS"){
				//System.out.println("------ODDS---player +2");
				playerScore += 2;}
			else{
				//System.out.println("-----ODDS----comp +2");
				computerScore += 2;}
			//playerScore += 2;
			roundWinner = "ODDS";
			//System.out.println("ODDS won round " + roundNumber);
		}
		//System.out.println("COMP FINGERS: " + compFingers);	
		// Bonus point for both if the same number of fingers
		if(playerFingers == compFingers) {
			//System.out.println("BOTH++");
			computerScore++;
			playerScore++;
			System.out.println("\nYou got 1 extra point!");
			System.out.println("The computer got 1 extra point!");
		}
		// Bonus point for EVENS if it showed more fingers
		else if(compFingers > playerFingers){
			//System.out.println("COMPUTER++");
			computerScore++;
			System.out.println("\nThe computer got 1 extra point!");
		}
		// Bonus point for ODDS if it showed more fingers
		else if(playerFingers > compFingers) {
			//System.out.println("PLAYER++");
			playerScore++;
			System.out.println("\nYou got 1 extra point!");
		}

		// if score is 6 or higher, set boolean to true to end game
		if(playerScore >= 6 || computerScore >= 6) {
			//gameOver = true;
			// set who the winner of the game is
			if(playerScore > computerScore) {
				gameWinner = "YOU";
				gameDraw = false;
				gameOver = true;
			} else if(computerScore > playerScore) {
				gameWinner = "COMPUTER";
				gameDraw = false;
				gameOver = true;
			} else {
				//System.out.println("It's a DRAW - One more round!");
				gameDraw = true;
			}
		}
	}
}
