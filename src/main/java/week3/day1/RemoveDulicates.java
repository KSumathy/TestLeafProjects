package week3.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class RemoveDulicates {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		int[] inputArray = {18,19,23,45,12,18,23,19,24,23,34,24,24,24,34};
	Set<Integer> outputArray = new TreeSet<Integer>();
	for(int i=0;i<inputArray.length;i++)
	{
		for(int j=i+1;j<inputArray.length;j++)
		{
			if(inputArray[i]==inputArray[j])
			{
				outputArray.add(inputArray[i]);
			}
		}
	}
	
	System.out.println("The duplicate numbers in the list are :");
	for (Integer num : outputArray) 
	{
		System.out.println(num);
	}
	

}
}
