package week3.day1;

public class Armstrong {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int sum,n;	
		System.out.println("Armstrong Numbers between 100 and 1000 are :");
		for(int i=100;i<1000;i++)
		{
			sum=0;
			n =i;
			while(n>0)
			{
			sum += (n%10)*(n%10)*(n%10);
			n=n/10;
			}
			
			if(sum==i)
			{
				System.out.println(i);
			}
			
		}

	}

}
