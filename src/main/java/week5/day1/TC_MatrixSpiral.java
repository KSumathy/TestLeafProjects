package week5.day1;

public class TC_MatrixSpiral
{

	public static void main(String[] args) 
	{
		/*int count =1;
		for(int i=0;i<4;i++)
		{
			System.out.println();
			for(int j=0;j<4;j++)
			{
				System.out.print(count++ +"  ");
			}
		}*/
		
		int arrayNumbers[][] = {{1,2,3,4},{5,06,07,8},{9,10,11,12},{13,14,15,16}};
		//System.out.println(arrayNumbers.length);
		int length = arrayNumbers.length;
		int lastIndex =length-1;
		for(int i=0;i<4;i++)
		{
			System.out.println();
			for(int j=0;j<4;j++)
			{
				System.out.print(arrayNumbers[i][j] + " ");
			}
		}
		int sumOfUpper =0, sumOfLower =0;
		System.out.println();
		System.out.println("The Numbers in diagnol are :");
		for (int i=0,j=lastIndex;i<length;i++)
		{
			System.out.print(arrayNumbers[i][j--]+" ");
		}
		
		for (int i=0;i<(lastIndex);i++)
		{
			System.out.println();
			for(int j=0;j<(lastIndex-i);j++)
			{
				//System.out.print(arrayNumbers[i][j]);
				sumOfUpper += arrayNumbers[i][j];
			}
			
			for (int j=(lastIndex-i);j<length;j++)
			{
				//System.out.print(arrayNumbers[i+1][j]);
				sumOfLower +=arrayNumbers[i+1][j];
			}
			
		}
		System.out.println("Sum of numbers above diagnol: "+sumOfUpper);
		System.out.println("Sum of numbers below diagnol: "+sumOfLower);
		
		if(sumOfUpper>sumOfLower)
		{
			System.out.println("Since sum of number above diagnol is large, printing them.");
			for (int i=0;i<(lastIndex);i++)
			{				
				for(int j=0;j<(lastIndex-i);j++)
				{
					System.out.println(arrayNumbers[i][j]);					
				}
				
				
			}
		}
		else
		{
			System.out.println("Since sum of number below diagnol is large, printing them.");
			for (int i=0;i<(lastIndex);i++)
			{				
				for (int j=(lastIndex-i);j<length;j++)
				{
				System.out.println(arrayNumbers[i+1][j]);
				
				}
				
			}	
		}
							
		}

	}


