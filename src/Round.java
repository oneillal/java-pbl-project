
public class Round {
	int roundNumber;
	int numberOfTurns;
	int oddsPlayerScore;
	int evensPlayerScore;
	int oddsPlayerBonusPts;
	int evensPlayerBonusPts;
	boolean roundOver;
	
	public Round(int roundNumber, boolean roundOver) {		
		this.roundNumber = roundNumber;
		this.roundOver = roundOver;
		
		this.numberOfTurns = 0;
		this.oddsPlayerScore = 0;
		this.evensPlayerScore = 0;
		this.oddsPlayerBonusPts = 0;
		this.evensPlayerBonusPts = 0;
	}

	public boolean isRoundOver() {
		return roundOver;
	}

	public void setRoundOver(boolean roundOver) {
		this.roundOver = roundOver;
	}

	public int getRoundNumber() {
		return roundNumber;
	}
	public void setRoundNumber(int roundNumber) {
		this.roundNumber = roundNumber;
	}
	public int getNumberOfTurns() {
		return numberOfTurns;
	}
	public void setNumberOfTurns(int numberOfTurns) {
		this.numberOfTurns = numberOfTurns;
	}
	public int getOddsPlayerScore() {
		return oddsPlayerScore;
	}
	public void setOddsPlayerScore(int oddsPlayerScore) {
		this.oddsPlayerScore = oddsPlayerScore;
	}
	public int getEvensPlayerScore() {
		return evensPlayerScore;
	}
	public void setEvensPlayerScore(int evensPlayerScore) {
		this.evensPlayerScore = evensPlayerScore;
	}
	public int getOddsPlayerBonusPts() {
		return oddsPlayerBonusPts;
	}
	public void setOddsPlayerBonusPts(int oddsPlayerBonusPts) {
		this.oddsPlayerBonusPts = oddsPlayerBonusPts;
	}
	public int getEvensPlayerBonusPts() {
		return evensPlayerBonusPts;
	}
	public void setEvensPlayerBonusPts(int evensPlayerBonusPts) {
		this.evensPlayerBonusPts = evensPlayerBonusPts;
	}
	
	public void turn(int oddsPlayerTurn, int evensPlayerTurn) {
		numberOfTurns++;
		if((oddsPlayerTurn + evensPlayerTurn) % 2 == 0) {
			evensPlayerScore++;
		}
		else {
			oddsPlayerScore++;
		}
		
		if(oddsPlayerScore == 6 || evensPlayerScore == 6) {
			roundOver = true;
		}
	}
}
