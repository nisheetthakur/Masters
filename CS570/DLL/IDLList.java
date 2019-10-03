import java.util.ArrayList; 

public class IDLList<E> {
	
	private class Node<E>{
		E data;
		Node<E> prev;
		Node<E> next;
		
		Node(E elem){
			data=elem;
			this.prev=null;
			this.next=null;
		}
		
		Node(E elem,Node<E> prev,Node<E> next)
		{
			data=elem;
			this.prev=prev;
			this.next=next;
		}
		
	}
	
	
	private Node<E> head ;
	private Node<E> tail;
	private int size;
	private ArrayList<Node<E>> indices;
	private Node<E> new_Node;
	

	public static void main(String[] args) {
		
	}
	
	//This creates a linked list of size zero
	public IDLList() {
			this.size=0;
			this.indices=new ArrayList<Node<E>>();
	}

	//This adds the node to the index specified. It checks if the index is at the head,tail or in the middle.
	public boolean add(int index,E elem) {
		boolean t=false;
		new_Node = new Node<E>(elem);
		Node<E> new_Node1;
		Node<E> new_Node2;
		
		
		if(index==0)
		{	t=true;
			new_Node2=indices.get(index+1);
			head=new_Node;
			new_Node.next=new_Node2;
			new_Node.prev=null;	
			new_Node2.prev=new_Node;
		}
		if(index>0 && index<size-1)
		{	t=true;
			new_Node1=indices.get(index-1);
			new_Node2=indices.get(index);
		new_Node.prev=new_Node1;
		new_Node.next=new_Node2;
		
		new_Node1.next=new_Node;
		new_Node2.prev=new_Node;	
		}
		if(index==size-1)
		{	t=true;
			new_Node2=indices.get(index-1);
			tail=new_Node;
			new_Node2.next=new_Node;
			new_Node.next=null;
			new_Node.prev=new_Node2;	
		}
		if(index>size)
		{
			t=false;
			System.out.println("Entered index is out of bounds!");
		}
		
		indices.add(index,new_Node);
		size++;
		System.out.println("Node with data "+elem+" is added at index "+index);
		System.out.println("Size: "+size);
		return t;
		
	}
	//This method adds the node to the head of the linked list
	public boolean add(E elem) {
		boolean t=false;
		if(size==0)
		{
		t=true;
		new_Node = new Node<E>(elem);
		head=new_Node;
		new_Node.next=null;
		new_Node.prev=null;
		}
		
		if(size>0)
		{	
			t=true;
			Node<E> new_Node1;
			new_Node=new Node<E>(elem);
			
			new_Node1=indices.get(0);
			new_Node1.prev=new_Node;
			
			head=new_Node;
			
			new_Node.prev=null;
			new_Node.next=new_Node1;
		}
		
		
		
		
		indices.add(0, head);
		size++;
		System.out.println("Node with data "+elem+" is added at index 0");
		System.out.println("Size: "+size);
		return t;
	}
	//This method appends the node at the end of the linked list
	public boolean append(E elem) {
		boolean t=false;
		Node<E> new_Node1;
		new_Node1=indices.get(size-1);
		
		new_Node=new Node<E>(elem);
		new_Node.next=null;
		new_Node.prev=new_Node1;
		tail=new_Node;
		indices.add(new_Node);
		size++;
		System.out.println("Node with data "+elem+" is added at index "+(size-1));
		t=true;
		System.out.println("Size: "+size);
		return t;
	}
	
	//This method gets the data of the node at the specified index.
	public E get(int index)
	{
		E data;
		new_Node=indices.get(index);
		data=new_Node.data;
		System.out.println("Data at "+index+" is "+data);
		return data;	
	}
	//This method gets the head of the linked list
	public E getHead() {
		E data;
		new_Node=indices.get(0);
		data=new_Node.data;
		System.out.println("Data at head is "+data);
		return data;
		
	}
	//This method gets the last data of the linked list
	public E getLast() {
		E data;
		new_Node=indices.get(size-1);
		data=new_Node.data;
		System.out.println("Data at last "+data);
		return data;
		
	}
	//This returns the size of the linked list
	public int size()
	{
		return size;
	}
	
	//This removes the node at the head of the linked list
	public E remove() {
		E data;
		Node<E> new_Node1;
		new_Node=indices.get(0);
		data=new_Node.data;
		new_Node1=indices.get(1);
		new_Node1.prev=null;
		head=new_Node1;
		indices.remove(0);
		System.out.println(data+" has been removed");
		size--;
		System.out.println("Size: "+size);
		return data;
	}
	
	//This removes the last node of the linked list
	public E removeLast() {
		E data;
		Node<E> new_Node1;
		new_Node=indices.get(size-1);
		data=new_Node.data;
		new_Node1=indices.get(size-2);
		new_Node1.next=null;
		tail=new_Node1;
		indices.remove(size-1);
		System.out.println(data+" has been removed");
		size--;
		System.out.println("Size: "+size);
		
		return data;
	}
	//This is used to remove the element at the specified index
	public E removeAt(int index) {
		E data=new_Node.data;
		Node<E> new_Node1;
		Node<E> new_Node2;
		int c=0;
		
		if(index==size-1 && c==0) {
			c++;
			data=removeLast();
		}
		
		if(index==0 && c==0) {
			c++;
			data=remove();
		}
		
		if(index<size-1 && index>0 && c==0)
		{
		new_Node=indices.get(index);
		data=new_Node.data;
		
		new_Node1=indices.get(index-1);
		new_Node2=indices.get(index+1);
		
		new_Node1.next=new_Node2;
		new_Node2.prev=new_Node1;
		
		indices.remove(index);
		System.out.println(data+" has been removed");
		size--;
		System.out.println("Size: "+size);
		c++;
		}
		return data;
		
	}
	//This removes the first instance of the element in the linked list
	public boolean remove(E elem) {
		boolean t=false;
		int i;
		Node<E> new_Node1;
		Node<E> new_Node2;
		for(i=0;i<size;i++)
		{
		new_Node=indices.get(i);
		if(new_Node.data==elem)
		{
			if(i==0)
			{
				t=true;
				new_Node1=indices.get(1);
				new_Node1.prev=null;
				head=new_Node1;
				indices.remove(0);
				System.out.println(elem+" has been removed");
				size--;
				System.out.println("Size: "+size);
				break;
			}
			
			if(i==size-1)
			{
				t=true;
				new_Node1=indices.get(size-2);
				new_Node1.next=null;
				tail=new_Node1;
				indices.remove(size-1);
				System.out.println(elem+" has been removed");
				size--;
				System.out.println("Size: "+size);
				break;	
			}
			
			if(i>0 && i<size-1)
			{
				t=true;
				new_Node1=indices.get(i-1);
				new_Node2=indices.get(i+1);
				
				new_Node1.next=new_Node2;
				new_Node2.prev=new_Node1;
				
				indices.remove(i);
				System.out.println(elem+" has been removed");
				size--;
				System.out.println("Size: "+size);	
				break;
			}
		
		}
		
		}
		
		
		
		return t;
	}
	
	//This return a string format of the linked list
	public String toString() {
		String link="";
		int i;
		for(i=0;i<size;i++)
		{
		new_Node=indices.get(i);
		link=link+" "+new_Node.data+" ";
		}
		
		return link;
	}
	
	
}



