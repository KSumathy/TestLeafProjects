package week5.day1;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class DigitSort {

	public static void main(String[] args) 
	{
		Scanner scr  = new Scanner(System.in);
		System.out.println("Enter number :");
		long input =  scr.nextLong();
		Set<Long> inputList = new TreeSet<Long>();
		while(input!=0)
		{
			inputList.add(input%10);
			input=input/10;
		}
		long output =0;
		for (Long digit : inputList) 
		{
			output = (output*10)+digit;
		}
		System.out.println(output);
	}

}
