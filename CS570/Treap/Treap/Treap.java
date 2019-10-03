package Treap;
import java.util.Random;
import java.util.Stack;

public class Treap<E extends Comparable<E>> {
		

	private Random priorityGenerator=new Random(10);
	private Node<E> root;
	private Stack<Node<E>> route=new Stack<Node<E>>();
	
	private static class Node<E>{
	
		public E data;
		public int priority;
		public Node<E> left;
		public Node<E> right;
		
			public Node(E data,int priority)
			{
			try
			{
			this.data=data;
			this.priority=priority;
			this.left= null;
			this.right= null;
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			}
			
				public Node<E> rotateRight()
				{
				Node<E> l=this.left;
				Node<E> r=l.right;
				l.right=this;
				this.left=r;
				return l;
				}
				
				
				public Node<E> rotateLeft()
				{
				Node<E> r=this.right;
				Node<E> l=r.left;
				
				r.left=this;
				this.right=l;
				return r;
				}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Treap<Integer> testTree = new Treap < Integer >();
		testTree.add(4 ,19);
		testTree.add(2 ,31);
		testTree.add(6 ,70);
		testTree.add(1 ,84);
		testTree.add(3 ,12);
		testTree.add(5 ,83);
		testTree.add(7 ,26);
		
		String str=testTree.toString();
		System.out.println(str);
		
		testTree.delete(6);
		if(testTree.find(6))
		{
			System.out.println("Found!");
		}
		else
		{
			System.out.println("Not found!");
		}
		
		
		
		String str1=testTree.toString();
		System.out.println(str1);
		
		
		
		/*
		boolean k=testTree.find(1);
		if(k==true)
		{
			System.out.println("Found!");
		}
		else
		{
			System.out.println("Not found!");
		}
		*/
	}
	
	
	
	

	
	public Treap()
	{
		this.priorityGenerator=new Random();
		this.root=null;
	}
	public Treap(long seed)
	{
		this.priorityGenerator=new Random(seed);
		this.root=null;
	}
	
	
	//Adding with key and priority provided
	public boolean add(E key,int priority)
	{
		Node<E> n=new Node<E>(key,priority);
		if(root==null)
		{
			root=n;
			return true;
		}
		
		Node<E> t=root;
		while(t!=null)
		{
			route.push(t);
			if(key.compareTo(t.data)>0)
			{
				t=t.right;
			}
			else
			{
				t=t.left;
			}
		}
		
		if(key.compareTo(route.peek().data)>0)
		{
			route.peek().right=n;
		}
		else
		{
			route.peek().left=n;
		}
		
	while(n.priority>route.peek().priority)
	{
		Node<E> prev=route.pop();
		if(!route.isEmpty())
		{
		Node<E> pprev=route.peek();
		if(prev.right!=null && prev.right.equals(n))
		{
			if(prev.equals(pprev.right))
			{
				pprev.right=prev.rotateLeft();
			}
			else
			{
				pprev.left=prev.rotateLeft();
			}
		}
		else
		{
			if(prev.equals(pprev.right))
			{
				pprev.right=prev.rotateRight();
			}
			else
			{
				pprev.left=prev.rotateRight();
			}
		}	
		}
		else
		{
			if(n.equals(prev.right))
			{
				root=prev.rotateLeft();
				return true;
			}
			else if(n.equals(prev.left))
			{
				root=prev.rotateRight();
				return true;
			}
			else
			{
				root=prev.rotateLeft();
				root=prev.rotateRight();
			}
		}
		
	}
		
		
		return true;
	}
	
	
	
	
	//Adding with only the key provided

	private boolean add(E key)
	{
	if(add(key,priorityGenerator.nextInt()))
		return true;
	else
		return false;
	
	}
	
	
//Deleting a node
	public boolean delete(E key)
	{
		Node<E> temp=root;
	if(deleteH(root,key)!=null)
	return true;
	
	else
		return false;
	}
	
	public Node<E> deleteH(Node<E> root,E key)
	{

	if(root==null)
	{
		return null;
	}
	if(key.compareTo(root.data)<0)
	{
		root.left=deleteH(root.left,key);
	}
	else if(key.compareTo(root.data)>0)
	{
		root.right=deleteH(root.right,key);
	}
	else
	{
	if(root.left==null)
	{
		root=root.right;
	}
	else if(root.right==null)
	{
		root=root.left;
	}
	
	else if(root.right.priority>root.left.priority)
	{
	root=root.rotateLeft();	
	root.right=deleteH(root.right,key);
	}
	else if(root.right.priority<root.left.priority)
	{
		root=root.rotateRight();
		root.left=deleteH(root.left,key);
	}
	}
	return root;
	}
	
	public boolean find(Node<E> root,E key)
	{
		boolean t=find(key);
		return t;
	}
	
	public boolean find(E key)
	{
		Node<E> d=root;
		while(true)
		{
		
		if(d!=null)
		{
			if(d.data==key)
			{
				return true;
			}
			else if(d.data.compareTo(key)>0)
			{
				d=d.left;
			}
			else if(d.data.compareTo(key)<0)
			{
				d=d.right;
			}
		}
		else
		{
			return false;
		}
		}
	}
	
	
	
	//Traversing the treap
	private void preTrav(Node<E> n,int d,StringBuilder s)
	{
	int i;
	for(i=0;i<d;i++)
	{
		s.append(" ");
	}
	if(n==null)
	{
		s.append("null Child\n");
	}
	else
	{
		s.append("(key="+n.data.toString()+" priority="+n.priority+")\n");
		preTrav(n.left,d+1,s);
		preTrav(n.right,d+1,s);
	}
	}
	//Coverting and returing treap as a string
	public String toString()
	{
		StringBuilder s=new StringBuilder();
		preTrav(root,1,s);
		return s.toString();
	}

	
	private Stack<Node<E>> counter=new Stack<Node<E>>();
	public Node<E> getNode(E key)
	{
		Node<E> n=root;
		while(true)
		{
			if(n.data==key)
			{
			//counter.push(n);
			break;
			}
			else if(n.data.compareTo(key)>0)
			{
			counter.push(n);
			n=n.left;
			}
			else if(n.data.compareTo(key)<0)
			{
			counter.push(n);
			n=n.right;
			}
		}
		return n;
	}
	}
