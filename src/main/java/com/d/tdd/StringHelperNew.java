package com.d.tdd;

import java.util.function.BooleanSupplier;

public class StringHelperNew {

	public String replaceAInFirst2Place(String str) {
		
		if(str.length() <= 2)
			return str.replaceAll("A", "");
		
		String first2Characters = str.substring(0,2);
		
		String replacedString = first2Characters.replaceAll("A", "");
		
		return replacedString + str.substring(2);
	}

	public boolean checkFirst2AndLast2Characters(String str) {
		
		if(str.length() < 2)
			return false;
		
		String first2Chars = str.substring(0, 2);
		
		String last2Chars = str.substring(str.length() - 2);
		
		return first2Chars.equals(last2Chars);
	}

}
