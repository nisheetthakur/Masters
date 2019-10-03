import java.util.Scanner;
import java.util.Random;
import java.util.Timer; 
import java.util.TimerTask; 
import java.util.Date;
import java.util.concurrent.TimeUnit;




public class Buses {
	public static int p[][];
	public static void main(String args[])
	{
		
		
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter the number of bus stops:");
		int bs=sc.nextInt();
		System.out.println("Enter the number of buses:");
		int b=sc.nextInt();
		System.out.println("Enter time to drive between two stops in minutes:");
		int t=sc.nextInt();
		System.out.println("Enter mean arrival rate for people per minute:");
		int a=sc.nextInt();
		System.out.println("Enter boarding time in seconds:");
		int bt=sc.nextInt();
		System.out.println("Enter the time for running the program(in seconds)");
		int tp=sc.nextInt();
		System.out.println(bs);
		
		//Timer timer=new Timer();
		//timer.schedule(new TimerTask() {
		//	  @Override
			//  public void run() {
					
					
			    
			  //}
		//	}, tp*1000);
		
	person(3);
	
	}
	
	
	
	
	public static void person(int num1,int k[][])
	{
		Random rand=new Random();
		int i1=rand.nextInt(num1);
		k[i1][1]++;
		System.out.println("Number of people at stops:"+k[i1][1]);
		
	}
	
	public static void arrival(int num2,int num3,int l[][])
	{
		Date d=new Date();
		if(l[num2][1]==0)
		{System.out.println("There is nobody at the stop to board the bus");}
		else
		{
			System.out.println("People are boarding the bus now!");
			boarder(num2,num3);
			
		}
		
		System.out.println("Entered at:"+d);
		
	}
	
	public static void boarder(int num4,int num5)
	{
		while(p[num4][1]!=0)
		{
		try{TimeUnit.SECONDS.sleep(num5);}
		catch (InterruptedException e) { /* empty */ }
		p[num4][1]--;
		System.out.println("Passenger boarding!");
		}
		System.out.println("All passengers boarded!");
	}
}

