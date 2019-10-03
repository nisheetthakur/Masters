
public class IDLListTest{

	
	public static void main(String[] args) {
	
		IDLList<Integer> a=new IDLList<Integer>();
		//Filling up the linked list with values
		a.add(0);
		a.add(1,10);
		a.add(2,20);
		a.add(3,30);
		a.add(4,40);
		a.add(5,50);
		a.add(6,60);
		a.add(7,70);
		a.add(8,80);
		a.add(9,90);
		
		//Inserting value in middle
		a.add(5,111111);
		
		//Appending
		a.append(100);
		
		//Getting elements at head,last and at a specified index
		a.getHead();
		a.getLast();
		
		a.get(5);
		
		
		//Displaying size of linked list
		a.size();
		
		//Removing elements at head,last and at a specified index
		a.removeAt(5);
		a.remove();
		a.removeLast();
		
		//Converting to string and displaying the resultant linked list
		System.out.println("Final Linked List: ");
		String s=a.toString();
		System.out.println(s);
	}

}
