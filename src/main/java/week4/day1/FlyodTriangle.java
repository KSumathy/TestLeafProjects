package week4.day1;

import java.util.Scanner;

public class FlyodTriangle {

	public static void main(String[] args)
	{
		Scanner scr =  new Scanner(System.in);
		System.out.println("Enter no of rows for the Triangle :");
		int rowsCount = scr.nextInt();
		int num=1;
		for(int i=1;i<=rowsCount;i++)
		{
			System.out.println();
			for(int j=1;j<=i;j++)
			{
				System.out.print(num++);
				System.out.print(" ");
			}
		}

	}

}
