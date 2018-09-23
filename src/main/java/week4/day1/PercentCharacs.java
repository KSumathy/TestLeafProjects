package week4.day1;

import java.text.DecimalFormat;

public class PercentCharacs {

	public static void main(String[] args) 
	{
		String inputString = "Tiger Runs @ The Speed Of 100km/hour. ";
		char[] inputCharArray = inputString.toCharArray();
		int stringLength = inputCharArray.length;
		int upperCaseCount =0;
		int lowerCaseCount =0;
		int specialCharCount = 0;
		int digitCount =0;
		double upperCasePercent, lowerCasePercent, specialCharPercent,digitPercent;
		DecimalFormat objDf =  new DecimalFormat(".##");
		for (Character eachChar : inputCharArray) 
		{
			if(Character.isUpperCase(eachChar))
			{
				upperCaseCount++;
				
			}
			else if(Character.isLowerCase(eachChar))
			{
				lowerCaseCount++;
				
			}
			else if(Character.isDigit(eachChar))
			{
				digitCount++;
				
			}
			else
			{
				specialCharCount++;
				
			}
		}
		
		upperCasePercent = (double) (upperCaseCount*100)/stringLength;
		lowerCasePercent = (double) (lowerCaseCount*100)/stringLength;
		digitPercent = (double) (digitCount*100)/stringLength;
		specialCharPercent = (double) (specialCharCount*100)/stringLength;
		
		
		System.out.println("Number of Upper Case Characters is :"+ upperCaseCount+" . So the percentage is :"+objDf.format(upperCasePercent)+"%.");
		System.out.println("Number of Lower Case Characters is :"+ lowerCaseCount+" . So the percentage is :"+objDf.format(lowerCasePercent)+"%.");
		System.out.println("Number of Digits Characters is :"+ digitCount+" . So the percentage is :"+objDf.format(digitPercent)+"%.");
		System.out.println("Number of Special Characters is :"+ specialCharCount+" . So the percentage is :"+objDf.format(specialCharPercent)+"%.");
		

	}

}
