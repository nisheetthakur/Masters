import java.util.Arrays;
public class BinaryNumber {
	private int data[];
	private static boolean overflow;
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		BinaryNumber bn=new BinaryNumber("11111111");
		int n=bn.getDigit(2);
		System.out.println(n);
		int n1=bn.getLength();
		System.out.println(n1);
		int n2=bn.toDecimal();
		System.out.println(n2);
		bn.add(new BinaryNumber("00000001"));
		
	}

	
	
	
	public BinaryNumber(int length)
	{	
		int i;
		if(length==0)
		{
			System.out.println("Length cannot be zero!");return;
		}
		data=new int[length];
		for(i=0;i<length;i++)
		{
			data[i]=0;
		}
		System.out.println("We have stored a binary number consisting of "+length+" zeros!");
		for(i=0;i<length;i++)
		{
			System.out.print(data[i]);
		}
	}
	
	
	public BinaryNumber(String str)
	{
		int i;
		data=new int[str.length()];
		int n=str.length();
		char[] str1 = str.toCharArray();
		for(i=0;i<n;i++)
		{
		data[i]=Character.getNumericValue(str1[i]);		
		}
		System.out.println("We have converted the given string and stored it as a numeric array!");
		for(i=0;i<n;i++)
		{
			System.out.print(data[i]);
		}
		System.out.println();
	}
	
	
	public int getLength()
	{
		System.out.println("The length of the binary number is :");
		return data.length;
	}
	
	
	public int getDigit(int index)
	{
	if(index>data.length-1 || index<0)
	{
		System.out.println("Given Index is out of bounds!"); 
	}
	System.out.println("The digit at index "+index+" is :");
	return data[index];
	
	}
	
	
	//I have used the little endian format to represent it in decimals
	public int toDecimal()
	{	
		
		int value=0;
		int i,m=1;
		for(i=0;i<data.length;i++)
		{
		value=value+(data[i]*m);
		m=m*2;
		}
		System.out.println("The decimal value of the supplied binary number is :");
		return value;
	}
	
	//The right shifted binary number is stored in the array sr
	public void shiftR(int amount)
	{	
			int i;
			int[] sr=new int[amount+data.length];
			System.out.println("After right shifting by "+amount+" amount we get :");
			for(i=0;i<amount;i++)
			{
				sr[i]=0;
				System.out.print(sr[i]);
			}
			int j=0;
			
			for(i=amount;i<amount+data.length;i++)
			{
				sr[i]=data[j];
				j++;
				System.out.print(sr[i]);
			}	
	}
	

	public void add(BinaryNumber aBinaryNumber)
	{	
		int i;
		
		if(data.length!=aBinaryNumber.data.length)
		{
			System.out.println("The length of the binary numbers is different!");            
			return;
		}
		
		int[] data1= new int[data.length];
		for(i=0;i<data.length;i++)
		{
		data1[i]=aBinaryNumber.data[i];	
		}
		//for(i=0;i<data.length;i++)
		//{
		//System.out.print(data[i]);
		//}
		
		
		
		int[] carry=new int[data.length+1]; 		//Used to keep track of carry for each addition
		
		int j=carry.length-1;
		for(i=0;i<carry.length;i++)
		{
			carry[i]=0;
		}
		int k=data.length-1;
		
		for(i=k;i>=0;i--)
		{
		
		//Check if the bits are both 1
		if(data[i]==1 && data1[i]==1)
		{
		if(carry[j]==0)
		{
		data[i]=0;
		carry[j-1]=1;
		
		}
		else
		{
			data[i]=1;
			carry[j-1]=1;
		}
		
		j--;
		continue;	
		}
		
		//Check if one of the bits is 0 and other is 1
		if((data[i]==1 && data1[i]==0) || (data[i]==0 && data1[i]==1))
		{
		if(carry[j]==0)
		{
			data[i]=1;
			carry[j-1]=0;
		}
		else
		{
			data[i]=0;
			carry[j-1]=1;
		
		}
		
		j--;
		continue;	
		}
		
		//Check if both the bits are 0
		if(data[i]==0 && data1[i]==0)
		{
		if(carry[j]==0)
		{
			data[i]=0;
			carry[j-1]=0;
		}
		else
		{
			data[i]=1;
			carry[j-1]=0;
		}
	
		j--;
		continue;
		}
		
		
		
		}
		
		if(carry[0]==1)
		{
			overflow=true;
		}
		System.out.println("The addition of the two binary numbers is :");
		
		for(i=0;i<data1.length;i++)
		{
			System.out.print(data[i]);
		}
		System.out.println();
		System.out.println("The value of the overflow flag is :"+overflow);
	
	
}

	public void clearOverflow()
	{
		overflow=false;
		System.out.println("The overflow flag has been set as false");
	}


	public String toString()
	{
	String value="";
	if(overflow==true)
	{
		value="Overflow";
	}
	if(overflow==false)
	{
		value=Arrays.toString(data);
	}
	return value;	
	}
	
}

