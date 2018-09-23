package week5.day1;

import java.util.ArrayList;
import java.util.List;

public class DuplicatesRemoval {

	public static void main(String[] args) 
	{
	String	 input = "Goodlooking";
	List<Character> outputList = new ArrayList<Character>();
	char[] inputChar = input.toCharArray();
	String output ="";
	/*for (char c : inputChar) 
	{
		if(!outputList.contains(c))
		{
		outputList.add(c);
		output+=c;
		
		}
	}*/
	for(int i=0;i<input.length();i++)
	{
	if(!outputList.contains(input.toLowerCase().charAt(i)))
			{
		outputList.add(input.toLowerCase().charAt(i));
		output+=input.charAt(i);
			}
		
	}
	
	System.out.println(output);

		
	}
			
	

	

}
