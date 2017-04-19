
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
	    roundWonByPlayer;
	String[] roundWinner = new String[10];
	String gameWinner;
	
	public Game(String playerChoice, int gameNo) {
		this.roundNumber = 0;
		this.playAs = playerChoice;
		this.gameOver = false;
		this.numberOfTurns = 0;
		this.playerScore = 0;
		this.computerScore = 0;
		this.oddsPlayerBonusPts = 0;
		this.evensPlayerBonusPts = 0;
		this.pFingers[0] = 0;
		this.cFingers[0] = 0;
		this.gameNumber = gameNo;
		this.pBonusPoints = 0;
		this.roundWonByPlayer = 0;
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

	public int getPlayerFingers(int roundNumber) {
		return pFingers[roundNumber-1];
	}

	public void setPlayerFingers(int fingers, int roundNumber) {
		this.pFingers[roundNumber-1] = fingers;
	}

	public int getPlayerBonusPoints(int roundNumber) {
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

	public int getCompFingers(int roundNumber) {
		return cFingers[roundNumber-1];
	}

	public void setCompFingers(int fingers, int roundNumber) {
		this.cFingers[roundNumber-1] = fingers;
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

	public String getRoundWinner(int round) {
		return roundWinner[round-1];
	}

	public void setRoundWinner(String roundWinner, int round) {
		this.roundWinner[round-1] = roundWinner;
	}

	public int getNumberRoundsWonByPlayer() {
		return roundWonByPlayer;
	}

	public void setNumberRoundsWonByPlayer(int roundWonByPlayer) {
		this.roundWonByPlayer = roundWonByPlayer;
	}

	public int getEvensPlayerBonusPts() {
		return evensPlayerBonusPts;
	}

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

	public void setGameWinner(int playerNoEven) {
		this.playerNoEven = playerNoEven;
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

	public void turn(int playerFingers, int compFingers, int round) {

		// Number of rounds played
		numberOfTurns++;

		// account for the number of fingers shown per round, per user
		pFingers[round-1] = playerFingers;
		cFingers[round-1] = compFingers;

		// EVENS result
		if((playerFingers + compFingers) % 2 == 0) {
			if(playAs == "EVENS"){
				playerScore += 2;
				playerNoEven++;
			}
			else{
				computerScore += 2;
				computerNoEven++;
			}
			roundWinner[round-1] = "EVENS";
		}
		// ODDS result
		else {
			if(playAs == "ODDS"){
				playerScore += 2;
				playerNoOdd++;
			}
			else{
				computerScore += 2;
				computerNoOdd++;
			}
			roundWinner[round-1] = "ODDS";
		}

		// Bonus point for both if the same number of fingers
		if(playerFingers == compFingers) {
			computerScore++;
			playerScore++;
			System.out.println("\nYou got 1 extra point!");
			System.out.println("The computer got 1 extra point!");
			pBonusPoints++;
			cBonusPoints++;
		}
		// Bonus point for Computer if it showed more fingers
		else if(compFingers > playerFingers){
			computerScore++;
			System.out.println("\nThe computer got 1 extra point!");
			cBonusPoints++;
		}
		// Bonus point for Player if it showed more fingers
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
