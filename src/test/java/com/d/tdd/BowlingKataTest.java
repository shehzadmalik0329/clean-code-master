package com.d.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

// 0 20
// 1 20
// 1 10, 2 10
//spare 5 2, 1 18
// 2,2|4,5|4,5|4,5|2,5 ==> 2+2+4+5+4+5+4+5+2+5 = 38
// 5,5|4,6|3, 7|6,4|1,1  ==> 5+9+4+9+3+13+6+5+1+1 = 56
// 10|10|10|10|1,1 ==> 30+30+21+12+2 = 95
public class BowlingKataTest {

	BowlingKata game = new BowlingKata();
	
	@Test
	public void testAllZeros() {
		rollMultipleTimes(0, 20);
		
		assertEquals(0, game.score());
	}

	@Test
	public void testAllOnes() {
		rollMultipleTimes(1, 20);
		
		assertEquals(20, game.score());
	}
	
	@Test
	public void test10OnesAnd10Twos() {
		rollMultipleTimes(1, 10);
		rollMultipleTimes(2, 10);
		
		assertEquals(30, game.score());
	}
	
	@Test
	public void testSpare() {
		rollSpare();
		rollMultipleTimes(1, 18);
		
		//5,5|1,1|1,1|1,1|1,1|1,1|1,1|1,1|1,1|1,1|
		//5+6+ 1+1+ 1+1+ 1+1+ 1+1+ 1+1+ 1+1+ 1+1+ 1+1+ 1+1 = 29
		
		assertEquals(29, game.score());
	}

	@Test
	public void testNoSpareNoStrike() {
		rollMultipleTimes(2, 1);
		rollMultipleTimes(2, 1);
		rollMultipleTimes(4, 1);
		rollMultipleTimes(5, 1);
		rollMultipleTimes(4, 1);
		rollMultipleTimes(5, 1);
		rollMultipleTimes(4, 1);
		rollMultipleTimes(5, 1);
		rollMultipleTimes(2, 1);
		rollMultipleTimes(5, 1);
		
		
		assertEquals(38, game.score());
	}
	
	@Test
	public void testSpares() {
		rollMultipleTimes(5, 1);
		rollMultipleTimes(5, 1);
		rollMultipleTimes(4, 1);
		rollMultipleTimes(6, 1);
		rollMultipleTimes(3, 1);
		rollMultipleTimes(7, 1);
		rollMultipleTimes(6, 1);
		rollMultipleTimes(4, 1);
		rollMultipleTimes(1, 1);
		rollMultipleTimes(1, 1);
		
		
		assertEquals(56, game.score());
	}
	
	@Test
	public void testStrike() {
		rollMultipleTimes(10, 1);
		rollMultipleTimes(10, 1);
		rollMultipleTimes(10, 1);
		rollMultipleTimes(10, 1);
		rollMultipleTimes(1, 1);
		rollMultipleTimes(1, 1);
		
		
		assertEquals(95, game.score());
	}
	
	@Test
	public void testStrike2() {
		rollMultipleTimes(10, 1);
		rollMultipleTimes(10, 1);
		rollMultipleTimes(10, 1);
		rollMultipleTimes(1, 1);
		rollMultipleTimes(1, 1);
		assertEquals(65, game.score());
	}
	
	@Test
	public void testStrike3() {
		rollMultipleTimes(10, 1);
		rollMultipleTimes(10, 1);
		rollMultipleTimes(10, 1);
		rollMultipleTimes(6, 1);
		rollMultipleTimes(4, 1);
		rollMultipleTimes(1, 1);
		rollMultipleTimes(1, 1);
		assertEquals(89, game.score());
	}

	private void rollSpare() {
		rollMultipleTimes(5, 2);
	}
	
	private void rollMultipleTimes(int pinsKnockedDown, int noOfTimes) {
		for(int i=1; i<=noOfTimes; i++)
			game.roll(pinsKnockedDown);
	}
}
