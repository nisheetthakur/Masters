import java.util.Vector;

public class Tickets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tickets t=new Tickets();
		Vector<Integer> v=new Vector<Integer>();
		v.add(4);
		v.add(5);
		v.add(5);
		v.add(2);
		v.add(3);
		v.add(3);
		//v.add(2);
		int w=t.times(v, 4);
		System.out.println(w);
	}
	
	
	
	
	public int times(Vector<Integer> line,int p )
	{
		int t=0;
		int i,len,temp;
		len=line.size();
		int target=(int) line.get(p);
		System.out.println(target+"target");
		for(i=0;i<len;i++)
		{	
			temp=(int) line.get(i);
			if(temp<target)
			{
				t=t+temp;
			}
			if(temp>=target)
			{
				t=t+target;
			}
			if(i>=p)
			{
				t--;
			}
			
		}
		
		
		return t;
	}

}
