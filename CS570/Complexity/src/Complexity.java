import java.util.Random;

public class Complexity {
	public static int counter1=1;	//NOTE:This variable only concerns the method6 as it uses recursion. It is not related to any other method.
	public static void main(String[] args) {
		System.out.println("----------Method 1-----------");
		method1(5);
		System.out.println("----------Method 2-----------");
		method2(2);
		System.out.println("----------Method 3-----------");
		method3(10);
		System.out.println("----------Method 4-----------");
		method4(10);
		System.out.println("----------Method 5-----------");
		method5(256);
		System.out.println("----------Method 6-----------");
		System.out.println("Initial value of counter is: "+counter1);
		method6(4);
		System.out.println("Final value of counter is: "+counter1);
		
	}
	
	//This implements two basic loops which increment the counter
	public static void method1(int n)
	{
		int i,j;
		int counter=0;
		System.out.println("Value of n: "+n);
		System.out.println("Initial value of counter: "+counter);
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				System.out.println(counter);
				counter++;
			}
		}
		System.out.println("Final Value of counter: "+counter);
	}
	
	//This implements three basic loops which increment the counter
	public static void method2(int n)
	{
		int i,j,k;
		int counter=0;
		System.out.println("Value of n: "+n);
		System.out.println("Initial value of counter: "+counter);
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{	
				for(k=0;k<n;k++)
				{
									
				System.out.println(counter);
				counter++;
				}
			}
		}	
		System.out.println("Final Value of counter: "+counter);
	}
	
	//This implements a binary search tree which has the complexity O(log(n))
	public static void method3(int n)
	{
		int i;
		int[] a = new int[n];
		int target=0;
		System.out.println("Value of n: "+n);
		for(i=0;i<n;i++)
		{
			a[i]=i;
		}
		int base=0,top=n-1;
		int mid;
		int counter=0;
		while(true)
		{
			counter++;
			System.out.println(counter);
		mid=(base+top)/2;
		if(base==top-1||base==top)
		{
			break;
		}
		
		if(a[mid]==target)
		{
		
		break;
		}
		
		if(a[mid]<target)
		{
			base=mid;
			
			continue;
		}
		if(a[mid]>target)
		{
			top=mid;
			
			continue;
		}
		
		
		
		}
		System.out.println("Final Value of counter: "+counter);
			}
	
	
	
	//This implements the binary search tree on an array of size n which contains random integers which results in a final complexity of O(n logn)
	//For the purpose of experimental observation we have taken the array containing all zeros
	public static void method4(int n)
	{
		int i;
		int[] a = new int[n];
		int[] target=new int[n];
		int counter=0;
		System.out.println("Value of n: "+n);
		System.out.println("Initial value of counter: "+counter);
		Random random=new Random();
		for(i=0;i<n;i++)
		{
			target[i]=0;   
			//System.out.println(target[i]);
		}
		for(i=0;i<n;i++)
		{
			a[i]=i;
		}
		
		
		
		int base,top;
		int mid;
		
		for(i=0;i<n;i++) 
		{
		
		
		base=0;top=n-1;
		while(true)
		{
			counter++;
			System.out.println(counter);
		mid=(base+top)/2;
		if(base==top-1||base==top)
		{
			//System.out.println(a[mid]);
			break;
		}
		if(a[mid]==target[i])
		{
		//System.out.println("We have found the target at index:"+mid);
		break;
		}
		if(a[mid]<target[i])
		{
			base=mid;
			//System.out.println("Target is greater than mid!");
			continue;
		}
		if(a[mid]>target[i])
		{
			top=mid;
			//System.out.println("Target is less than mid");
			continue;
		}
		}
		}
		System.out.println("Final Value of counter: "+counter);
		}
	
	
	//This method implements a for loop to get a complexity of O(log(logn))
	public static void method5(int n)
	{		
		int i;
		int counter=0;
		System.out.println("Value of n: "+n);
		System.out.println("Initial value of counter: "+counter);
		for(i=2;i<n;i=i*i)
		{	
			counter++;
			System.out.println(counter);
		}
		System.out.println("Final value of counter: "+counter);
	}
	
	//This method uses recursion to get the complexity of O(2^k)
	public static int method6(int n)
	{	
		counter1++;
		int counter=0;
		counter++;
		System.out.println(counter);
			if(n==0||n==1)
			{
				return 1;
			}
			else
			{
				return method6(n-1)+method6(n-1);
			}
		
	}	
	
	
	
	

}

