package week5.day1;

import java.util.Scanner;

public class RecursiveFunction {

	public int output =0;
	public String outputString ="";
	public static void main(String[] args) 
	{
		Scanner scr =  new Scanner(System.in);
		System.out.println("Enter the String : ");
		String input = scr.next();
		System.out.println("Enter the number :");
		int num = scr.nextInt();
		RecursiveFunction obj = new RecursiveFunction();
		obj.reverse(num);
		obj.reverse(input, input.length());
		

	}
	
	public void reverse(int input)
	{
		if(input>0)
		{
			output = (output*10)+ (input%10);
			input = input/10;
			reverse(input);
		}
		else
		{
			System.out.println(output);
		}
	}

	public void reverse(String input, int length)
	{
		if(length>0)
		{
			length = length-1;
			outputString = outputString + input.charAt(length);
			reverse (input, length);
		}
		else
		{
			System.out.println(outputString);
		}
	}
}
