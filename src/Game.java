// instantiable class that implements Player and Computer game stats and features
// Coded by Jonas Stein (Student ID 16136306)


public class Game {
	int roundNumber;
	int numberOfTurns;
	int playerScore;
	int computerScore;
	boolean gameOver,
		gameDraw = false;
	String playAs;
	int[] pFingers = new int[20],
	      cFingers   = new int[20];
	int fingers;
	int gameNumber,
	    pBonusPoints,
	    cBonusPoints,
	    computerNoEven,
	    playerNoEven,
	    computerNoOdd,
	    playerNoOdd,
	    roundWonByPlayer,
	    roundWonByComputer;
	String[] roundWinner = new String[10];
	String gameWinner;

	// Instantiate the class setting the following values
	// PlayerChoice is either EVENS or ODDS
	public Game(String playerChoice) {
		this.roundNumber = 0;
		this.playAs = playerChoice;
		this.gameOver = false;
		this.numberOfTurns = 0;
		this.playerScore = 0;
		this.computerScore = 0;
		this.pFingers[0] = 0;
		this.cFingers[0] = 0;
		this.pBonusPoints = 0;
		this.roundWonByPlayer = 0;
		this.playerNoEven = 0;
		this.playerNoOdd = 0;
		this.computerNoEven = 0;
		this.computerNoOdd = 0;
	}

	// tracks if game has ended
	public boolean isGameOver() {
		return gameOver;
	}
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	// tracks the round number
	public int getRoundNumber() {
		return roundNumber;
	}
	public void setRoundNumber(int roundNumber) {
		this.roundNumber = roundNumber;
	}

	// tracks how many fingers were shown by player and computer each round
	public int getPlayerFingers(int roundNumber) {
		return pFingers[roundNumber-1];
	}
	public void setPlayerFingers(int fingers, int roundNumber) {
		this.pFingers[roundNumber-1] = fingers;
	}
	public int getCompFingers(int roundNumber) {
		return cFingers[roundNumber-1];
	}

	public void setCompFingers(int fingers, int roundNumber) {
		this.cFingers[roundNumber-1] = fingers;
	}

	// tracks bonus points received by each player
	public int getPlayerBonusPoints() {
		return pBonusPoints;
	}
	public void setPlayerBonusPoints(int bonusPoint) {
		this.pBonusPoints = bonusPoint;
	}
	public int getCompBonusPoints() {
		return cBonusPoints;
	}
	public void setCompBonusPoints(int bonusPoint) {
		this.cBonusPoints = bonusPoint;
	}

	// number of rounds played
	public int getNumberOfTurns() {
		return numberOfTurns;
	}
	public void setNumberOfTurns(int numberOfTurns) {
		this.numberOfTurns = numberOfTurns;
	}

	// scores for each player
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

	// tracks if game is draw
	public boolean isGameDraw() {
		return gameDraw;
	}
	public void setisGameDraw(boolean gameDraw) {
		this.gameDraw = gameDraw;
	}

	// tracks the game winner
	public String getGameWinner() {
		return gameWinner;
	}
	public void setGameWinner(String gameWinner) {
		this.gameWinner = gameWinner;
	}

	// tracks the round winner
	public String getRoundWinner(int round) {
		return roundWinner[round-1];
	}
	public void setRoundWinner(String roundWinner, int round) {
		this.roundWinner[round-1] = roundWinner;
	}

	// number of rounds won by player and computer
	public int getNumberRoundsWonByPlayer() {
		return roundWonByPlayer;
	}
	public void setNumberRoundsWonByPlayer() {
		this.roundWonByPlayer++;
	}
	public int getNumberRoundsWonByComputer() {
		return roundWonByComputer;
	}
	public void setNumberRoundsWonByComputer() {
		this.roundWonByComputer++;
	}

	// tracks the number of even and odd fingers shown by player and computer
	public int getPlayerNumberOfEven() {
		return playerNoEven;
	}
	public void setPlayerNumberOfEven(int playerNoEven) {
		this.playerNoEven = playerNoEven;
	}
	public int getPlayerNumberOfOdd() {
		return playerNoOdd;
	}
	public void setPlayerNumberOfOdd(int playerNoOdd) {
		this.playerNoOdd = playerNoOdd;
	}
	public int getCompNumberOfEven() {
		return computerNoEven;
	}
	public void setCompNumberOfEven(int computerNoEven) {
		this.computerNoEven = computerNoEven;
	}
	public int getCompNumberOfOdd() {
		return computerNoOdd;
	}
	public void setCompNumberOfOdd(int computerNoOdd) {
		this.computerNoOdd = computerNoOdd;
	}

	// gets score for player and computer
	public int getRoundStats(String player) {
                if(player == "player")
			return getPlayerScore();
		else
			return getComputerScore();
        }


	// method to compute each round's stats
	public void turn(int playerFingers, int compFingers, int round) {

		// Number of rounds played
		numberOfTurns++;

		// account for the number of fingers shown per round, per user
		pFingers[round-1] = playerFingers;
		cFingers[round-1] = compFingers;

		// EVENS result
		if((playerFingers + compFingers) % 2 == 0) {
			// check if player is EVENS, if it is then the player gets the points
			if(playAs == "EVENS")
				playerScore += 2;
			else
				computerScore += 2;

			roundWinner[round-1] = "EVENS";
		}
		// ODDS result
		else {
			// check if player is ODDS, if it is then the player gets the points
			if(playAs == "ODDS")
				playerScore += 2;
			else
				computerScore += 2;

			roundWinner[round-1] = "ODDS";
		}

		// check the number of fingers shown by the player is an even number
		if(playerFingers % 2 == 0)
			playerNoEven++;
		// if not then it's an odd number of fingers
		else
			playerNoOdd++;

		// check the number of fingers shown by the computer is an even number
		if(compFingers % 2 == 0)
			computerNoEven++;
		// if not then it's an odd number of fingers
		else
			computerNoOdd++;

		// Bonus point for both if the same number of fingers
		if(playerFingers == compFingers) {
			computerScore++;
			playerScore++;
			System.out.println("\nYou got 1 extra point!");
			System.out.println("The computer got 1 extra point!");
			pBonusPoints++;
			cBonusPoints++;
		}
		// Bonus point for Computer if it showed more fingers (i.e. closer to sum)
		else if(compFingers > playerFingers){
			computerScore++;
			System.out.println("\nThe computer got 1 extra point!");
			cBonusPoints++;
		}
		// Bonus point for Player if it showed more fingers (i.e. closer to sum)
		else if(playerFingers > compFingers) {
			playerScore++;
			System.out.println("\nYou got 1 extra point!");
			pBonusPoints++;
		}

		// if score is 6 or higher, set boolean to true to end game
		if(playerScore >= 6 || computerScore >= 6) {

			// set who the winner of the game is
			if(playerScore > computerScore) {
				gameWinner = "YOU";
				gameDraw = false;
				gameOver = true;
			} else if(computerScore > playerScore) {
				gameWinner = "COMPUTER";
				gameDraw = false;
				gameOver = true;
			}
			// It's a DRAW - One more round
			else {
				gameDraw = true;
			}
		}
	}
}
