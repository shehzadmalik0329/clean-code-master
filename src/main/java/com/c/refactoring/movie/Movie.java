package com.c.refactoring.movie;

import java.util.Arrays;
import java.util.List;

import com.c.refactoring.StringUtils;

public class Movie {

	private static final List<String> VALID_B_RATING_LIST = Arrays.asList("B1", "B2", "B3", "B4");
	String rating;

	public Movie(String rating) {
		super();
		this.rating = rating;
	}

	public String getRating() {
		return rating;
	}

	/*Axx or By
    Where x represents any digit between 0 and 9, and y represents 
    any digit between 1 and 4*/
	public boolean isValidRating() {

		if(rating == null)
			return false;
		
		if (isValidARating())
			return true;

		if(isValidBRating())
			return true;
		
		return false;
	}

	private boolean isValidBRating() {
		
		return VALID_B_RATING_LIST.contains(rating);
		
	}

	private boolean isValidARating() {
		String firstChar = rating.substring(0, 1);
		
		return firstChar.equalsIgnoreCase("A")
				&& rating.length() == 3
				&& StringUtils.isNumeric(rating.substring(1, 3));
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
}
