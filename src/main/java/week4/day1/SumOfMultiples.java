package week4.day1;

import java.util.ArrayList;
import java.util.List;

public class SumOfMultiples {

	public static void main(String[] args) 
	{
		int sum=0;
		System.out.println("The numbers divisible by 3 and 5 are :");
	 for(int i=1;i<100;i++)
	 {
		 if(((i%3)==0)||((i%5)==0))
		 {
			sum=sum+i;
			System.out.print(i+" ");
			
			
		 }
	 }
	System.out.println();
	 System.out.println("Sum of the numbers is : "+ sum);
	}

}
