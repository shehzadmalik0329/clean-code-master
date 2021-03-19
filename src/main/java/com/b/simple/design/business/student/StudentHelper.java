package com.b.simple.design.business.student;
public class StudentHelper {

	private static final int DEFAULT_EXTRA_LIMIT = 0;
	private static final int SUBJECT_UPPER_LIMIT = 80;
	private static final int SUBJECT_LOWER_LIMIT = 20;
	private static final int EXTRA_LIMIT_FOR_MATH = 5;
	private static final int LOWER_LIMIT_FOR_GRADE_B = 50;
	private static final int LOWER_LIMIT_FOR_GRADE_A = 90;
	private static final String GRADE_B = "B";
	private static final String GRADE_A = "A";
	private static final String GRADE_C = "C";
	private static final int EXTRA_FOR_MATHS = 10;
	private static final int GRADE_B_UPPER_LIMIT = 80;
	private static final int GRADE_B_LOWER_LIMIT = 51;

	/* PROBLEM 1 */	
	/*
	* You get a grade B if marks are between 51 and 80 (both inclusive). Except for Maths where the upper limit is increased by 10.
	*/
	public boolean isGradeB(int marks, boolean isMaths) {
		
		int extraLimit = isMaths ? EXTRA_FOR_MATHS : DEFAULT_EXTRA_LIMIT;
		
		int upperLimit = GRADE_B_UPPER_LIMIT + extraLimit;
		
		return marks>=GRADE_B_LOWER_LIMIT && marks<=upperLimit; 
	}

	/* PROBLEM 2 */
	/*
	You are awarded a grade based on your marks.
	Grade A = 91 to 100, Grade B = 51 to 90, Otherwise Grade C
	Except for Maths where marks to get a Grade are 5 higher than required for other subjects.
	*/

	public String getGrade(int mark, boolean isMaths) {
		
		int extraLowerLimitForMath = isMaths ? EXTRA_LIMIT_FOR_MATH : DEFAULT_EXTRA_LIMIT;
		
		if (mark > LOWER_LIMIT_FOR_GRADE_A + extraLowerLimitForMath)
			return GRADE_A;
		
		if (mark > LOWER_LIMIT_FOR_GRADE_B + extraLowerLimitForMath) {
			return GRADE_B;
		}
		return GRADE_C;
	}


    /*  PROBLEM 3
     * You and your Friend are planning to enter a Subject Quiz.
     * However, there is a marks requirement that you should attain to qualify.
     * 
     * Return value can be YES, NO or MAYBE.
     * 
     * YES If either of you are very good at the subject(has 80 or more marks)
     * However, there is an exception that if either of you is not good in the subject(20 or less marks), it is NO.
     * In all other conditions, return MAYBE.
     * 
     * However, the definition for good and not good are 5 marks higher if the subject is Mathematics.
     * 
     * marks1 - your marks
     * marks2 - your friends marks
    */
        
    public String willQualifyForQuiz(int marks1, int marks2, boolean isMaths) {
    	
    	int extraLimit = isMaths ? EXTRA_LIMIT_FOR_MATH : DEFAULT_EXTRA_LIMIT;
    	
    	int lowerLimitForSubject = SUBJECT_LOWER_LIMIT + extraLimit;
    	
    	int upperLimitForSubject = SUBJECT_UPPER_LIMIT + extraLimit;
    	
        if (isNotGood(marks1, lowerLimitForSubject)
                || isNotGood(marks2, lowerLimitForSubject)) 
        	return "NO";
        
        if (isGood(marks1, upperLimitForSubject)
                || isGood(marks2, upperLimitForSubject)) 
        	return "YES";
        
        return "MAYBE";
    }

	private boolean isGood(int marks, int upperLimitForSubject) {
		return marks >= upperLimitForSubject;
	}

	private boolean isNotGood(int marks, int lowerLimitForSubject) {
		return marks <= lowerLimitForSubject;
	}	

}