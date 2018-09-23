package week4.day1;

import java.util.Scanner;

public class LargestNumberWithoutDigit {

	public static void main(String[] args)
	{
		Scanner scr  =  new Scanner(System.in);
		System.out.println("Enter the number :");
		int number =  scr.nextInt();
		System.out.println("Enter the digit :");
		int digit =  scr.nextInt();
		boolean isDigitFound ;
		int j;
		for (int i=number-1;i>=0;i--)
		{
			 j=i;
			 isDigitFound = false;
			while(j>0)
			{
				if((j%10)==digit)
				{
					isDigitFound = true;	
					break;
				}
				j=j/10;
			}
			if(!isDigitFound)
			{
				System.out.println("The largest number that doea not have the digit is :"+ i);
				break;
			}
		}

	}

}
