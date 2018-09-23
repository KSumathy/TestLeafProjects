package week3.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SecondLargestNumberInArray {

	public static void main(String[] args)
	{
	Scanner scr  = new Scanner(System.in);
	System.out.println("Enter the size of Array :");
	int arraySize =  scr.nextInt();
	System.out.println("Enter the elements one by one :");
	//int[] inputArray = new int[arraySize];
	List<Integer> inputArray = new ArrayList();
	for(int i=0;i<arraySize;i++)
	{
		inputArray.add(scr.nextInt());
	}
	Collections.sort(inputArray);
	System.out.println("The second largeest number is : "+ inputArray.get(arraySize-2));

	}

}
