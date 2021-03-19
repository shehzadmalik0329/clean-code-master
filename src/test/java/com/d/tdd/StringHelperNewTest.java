package com.d.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class StringHelperNewTest {
	
	// "ABCD" => "BCD", "AACD"=> "CD", "BACD"=>"BCD", "AAAA" => "AA", "MNAA"=>"MNAA"
	// "", "A", "AA", "B", "BC"
	StringHelperNew helper = new StringHelperNew();
	@Test
	public void testReplaceAInFirst2Place() {
		assertEquals("BCD", helper.replaceAInFirst2Place("ABCD"));
		assertEquals("CD", helper.replaceAInFirst2Place("AACD"));
		assertEquals("BCD", helper.replaceAInFirst2Place("BACD"));
		assertEquals("AA", helper.replaceAInFirst2Place("AAAA"));
		assertEquals("MNAA", helper.replaceAInFirst2Place("MNAA"));
		
		assertEquals("", helper.replaceAInFirst2Place(""));
		assertEquals("", helper.replaceAInFirst2Place("A"));
		assertEquals("", helper.replaceAInFirst2Place("AA"));
		assertEquals("B", helper.replaceAInFirst2Place("B"));
		assertEquals("BC", helper.replaceAInFirst2Place("BC"));
	}
	
	// ""=>false, "A"=>false, "AB"=>true, "ABC"=>false, "AAA"=>true, "ABCAB"=>true, "ABCDEBA"=>false
	@Test
	public void testFirst2AndLast2Characters() {
		assertFalse(helper.checkFirst2AndLast2Characters(""));
		assertFalse(helper.checkFirst2AndLast2Characters("A"));
		assertTrue(helper.checkFirst2AndLast2Characters("AB"));
		assertFalse(helper.checkFirst2AndLast2Characters("ABC"));
		assertTrue(helper.checkFirst2AndLast2Characters("AAA"));
		assertTrue(helper.checkFirst2AndLast2Characters("ABCAB"));
		assertFalse(helper.checkFirst2AndLast2Characters("ABCDEBA"));
	}
}
