package com.b.simple.design.business.text;

public class TextHelper {

	public String swapLastTwoCharacters(String str) {
		
		if(null == str)
			return null;
		
		int length = str.trim().length();
		
		if(length == 0 || length < 2)
			return str;

		String firstPart = str.substring(0, length - 2);
		char lastChar = str.charAt(length - 1);
		char secondLastChar = str.charAt(length - 2);
		
		return firstPart+lastChar+secondLastChar;
	}

	public String truncateAInFirst2Positions(String str) {
		
		if(null == str)
			return null;
		
		if(str.length() < 2)
			return str.replaceAll("A", "");
		
		String first2Characters = str.substring(0,2);
		
		String first2CharactersUpdated = first2Characters.replaceAll("A", "");
		
		return first2CharactersUpdated + str.substring(2);
		
	}
}
