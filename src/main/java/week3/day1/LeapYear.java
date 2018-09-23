package week3.day1;

import java.util.Scanner;

public class LeapYear {

	public static void main(String[] args)
	{
		Scanner scr = new Scanner(System.in);
		System.out.println("Enter year :");
		int inputYear = scr.nextInt();
		if(((inputYear%4==0)&&(inputYear%100!=0))||(inputYear%400==0))
		{
			System.out.println("The given year is a leap year");
		}
		else
		{
			System.out.println("The given year is not a leap year");
		}

	}

}
