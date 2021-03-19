package com.d.tdd;

public class BowlingKata {
	

	
	int[] rolls = new int[21];
	
	int rollIndex = 0;
	
	public void roll(int pinsKnockedDown) {
		rolls[rollIndex++] = pinsKnockedDown;
	}
	
	public int score() {
		int score = 0;
		
		int rollCount = 0;
		
		for(int frame=0; frame<10; frame++) {
			
			if(isStrike(rollCount)) {
				score += 10 + bonusForStrike(rollCount);
				rollCount +=1;
			} else if (isSpare(rollCount)) {
				score += 10 + bonusForSpare(rollCount);
				rollCount +=2;
			} else {
				score += rolls[rollCount] + rolls[rollCount+1];
				rollCount +=2;
			}
		}
		
		return score;
	}

	private int bonusForSpare(int rollCount) {
		return rolls[rollCount+2];
	}

	private int bonusForStrike(int rollCount) {
		return rolls[rollCount+1] + bonusForSpare(rollCount);
	}

	private boolean isSpare(int rollCount) {
		return rolls[rollCount] + rolls[rollCount+1] == 10;
	}

	private boolean isStrike(int rollCount) {
		return rolls[rollCount] == 10;
	}
}
